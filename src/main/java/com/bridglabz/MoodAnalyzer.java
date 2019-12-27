package com.bridglabz;

public class MoodAnalyzer {

    private String message;

    public MoodAnalyzer(String message){
        this.message = message;
    }

    public String analyse(){
        try {

            if(message.length() == 0)
                throw new MoodException(MoodException.ExceptionType.ENTERD_EMPTY,"Please Enter Proper Message");
            if (message.contains("Sad"))
                return "Sad";
            else
                return "Happy";

        }catch (NullPointerException e){
            throw new MoodException(MoodException.ExceptionType.ENTERD_NULL,"Please Enter Proper Message");
        }
    }
}
