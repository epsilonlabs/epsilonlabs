package org.eclipse.epsilon.eol.coverage.analysis.context;

import log.LogBook;

public class CoverageAnalysisContext {
			
		protected LogBook logBook = new LogBook();
		protected CoverageAnalysisRepo coverageAnalysisRepo = new CoverageAnalysisRepo();
		
		public CoverageAnalysisContext()
		{
			
		}
		
		public CoverageAnalysisRepo getCoverageAnalysisRepo() {
			return coverageAnalysisRepo;
		}
		
		public LogBook getLogBook() {
			return logBook;
		}
		
}
