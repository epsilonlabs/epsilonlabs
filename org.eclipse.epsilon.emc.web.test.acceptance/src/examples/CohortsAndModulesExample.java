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

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.epsilon.emc.web.WebDriver;
import org.eclipse.epsilon.emc.web.model.Resource;
import org.eclipse.epsilon.emc.web.scrapers.PageScraper;
import org.eclipse.epsilon.emc.web.scrapers.ReferenceScraper;
import org.eclipse.epsilon.emc.web.scrapers.RegionScraper;


public class CohortsAndModulesExample {
	
	public void run() throws Exception {
		WebDriver driver = new WebDriver("http://www.cs.york.ac.uk/");
		
		Map<String, Module> modules = new PageScraper<Module>(Module.class, driver).scrape("modules/index.html", driver.xpath("//h2/following-sibling::ul/li/a"));
        
        ReferenceScraper<Module> cohortToModules = new ReferenceScraper<Module>();
        cohortToModules.pattern = driver.xpath(".//following-sibling::ul[1]/li/a");
        cohortToModules.field = Cohort.class.getDeclaredField("modules");
        cohortToModules.targets = modules;
        
		Map<String, Cohort> cohorts = new RegionScraper<Cohort>(Cohort.class, driver).scrape("modules/index_course.html", driver.xpath("//*[@id='mdcolumn']/a[@name]"), cohortToModules);
        
        for (Cohort c : cohorts.values()) {
        	System.out.println(c.name + " -- " + c.url);
        	for (Module m : c.modules) {
        		System.out.println(" - " + m.name + " -- " + m.url);
        	}
        }
        
        driver.quit();
	}

	
	
	// @web.regions(page="modules/index_course.html", elements="//*[@id='mdcolumn']/a[@name]")
	// class Cohort {
	//   attr String name;
	//   @web(xpath=".//following-sibling::ul[1]/li/a")
	//   ref Module[*] modules;
	// }
	//
	// @web.pages(index="modules/index.html", elements="//h2/following-sibling::ul/li/a")
	// class Module {
	//   attr String name;
	// }
	
	public static class Cohort extends Resource {
		public final List<Module> modules = new LinkedList<Module>();
	}
	
	public static class Module extends Resource {}
	
	public static void main(String[] args) throws Exception {
        new CohortsAndModulesExample().run();
    }
}
