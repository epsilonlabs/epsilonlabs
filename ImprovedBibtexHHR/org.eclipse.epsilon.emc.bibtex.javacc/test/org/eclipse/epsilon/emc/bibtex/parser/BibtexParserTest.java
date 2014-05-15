package org.eclipse.epsilon.emc.bibtex.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;

public class BibtexParserTest {

	@Test
	public void testBibliography() {
		String path = "C:/Users/hhoyos/epsilonws/org.eclipse.epsilon.emc.bibtex.javacc/test/org/eclipse/epsilon/emc/bibtex/parser/SmallTest.bib";
		BibtexParser bibtex = null;
		try {
			bibtex = new BibtexParser(new FileInputStream(path));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			bibtex.bibliography();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
