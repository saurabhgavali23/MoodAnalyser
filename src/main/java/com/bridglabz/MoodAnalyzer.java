package com.bridglabz;

import java.util.Objects;

public class MoodAnalyzer {

    private String message;

    public MoodAnalyzer(){}
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyzer that = (MoodAnalyzer) o;
        return message.equals(that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
