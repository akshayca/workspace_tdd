package com.workspace_tdd.strings.custom_exceptions;

public class EmptyStringException extends Exception {
    
    public EmptyStringException(String str){  
        super(str);  
    }
}
