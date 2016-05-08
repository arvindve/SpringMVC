package com.controller;

import java.beans.PropertyEditorSupport;


public class StudentNameEditor extends PropertyEditorSupport {
	
	 @Override
	 public void setAsText(String studentName) {
		 
		 if(studentName.contains("Mr.") ||studentName.contains("Ms.")){
			 
			 setValue(studentName);
		 }
		 else{
			 
			 studentName = "Ms."+studentName;
			 setValue(studentName);
		 }
       
    }

}
