package com.example.demo;

public class JsonParsingException extends Exception {
	

		private static final long serialVersionUID = 1L;

		private String errorMessage;


		public JsonParsingException(String errorMessage) {
			super(errorMessage);
			this.errorMessage = errorMessage;
		}

	
		public String getErrorMessage() {
			return errorMessage;
		}

		

	}
		
		



