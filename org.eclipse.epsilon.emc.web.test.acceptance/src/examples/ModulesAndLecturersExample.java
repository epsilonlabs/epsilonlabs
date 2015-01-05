/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package examples;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.epsilon.emc.web.WebDriver;
import org.eclipse.epsilon.emc.web.model.Resource;
import org.eclipse.epsilon.emc.web.scrapers.PageScraper;
import org.eclipse.epsilon.emc.web.scrapers.ReferenceScraper;


public class ModulesAndLecturersExample {
	
	public void run() throws Exception {
		WebDriver driver = new WebDriver("http://www.cs.york.ac.uk/");
		
        Map<String, Lecturer> lecturers = new PageScraper<Lecturer>(Lecturer.class, driver).scrape("people", driver.xpath("//td[@class='white']/a"));

		ReferenceScraper<Lecturer> r = new ReferenceScraper<Lecturer>();
		r.pattern = driver.xpath("//*[@id='ModuleInfo']//tr[2]/td/a");
        r.field = Module.class.getDeclaredField("lecturers");
        r.targets = lecturers;
        
        Map<String, Module> modules = new PageScraper<Module>(Module.class, driver).scrape("modules/index.html", driver.xpath("//h2/following-sibling::ul/li/a"), r);
        
        for (Module m : modules.values()) {
        	System.out.print(m.name + " taught by: ");
        	
        	for (Iterator<Lecturer> iterator = m.lecturers.iterator(); iterator.hasNext();) {
        		Lecturer lecturer = iterator.next();
        		if (lecturer == null) {
        			System.out.print("UNKNOWN");
        		} else {
        			System.out.print(lecturer.name);
        		}
        		if (iterator.hasNext()) { System.out.print(", "); };
			}
	        
	        System.out.println();
        }

        driver.quit();
	}
	
	// @web.pages(index="modules/index.html", elements="//h2/following-sibling::ul/li/a")
	// class Module {
	//   attr String name;
	//
	//	 @web(xpath="//*[@id='ModuleInfo']//tr[2]/td/a")
	//   ref Lecturer[*] lecturers
	// }
	// 
	// @web.pages(index="people", elements="//td[@class='white']/a")
	// class Lecturer {
	//   attr String name;
	// }
	
	public static class Module extends Resource {
		public final List<Lecturer> lecturers = new LinkedList<Lecturer>();
	}
	public static class Lecturer extends Resource {}
	
	
	public static void main(String[] args) throws Exception {
        new ModulesAndLecturersExample().run();
    }
}
