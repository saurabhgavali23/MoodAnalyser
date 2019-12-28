package com.bridglabz;

public class MoodException extends RuntimeException{

   public enum ExceptionType{
        ENTERD_NULL,ENTERD_EMPTY,NO_SUCH_CLASS_ERROR,NO_SUCH_METHOD_ERROR
    }

   public ExceptionType type;

    public MoodException(ExceptionType type, String message) {
        super(message);
        this.type=type;
    }
}
