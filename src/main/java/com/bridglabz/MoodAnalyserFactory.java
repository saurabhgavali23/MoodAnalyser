package com.bridglabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyzer createMoodAnalyser(String message) {
        try {

            Class<?> moodAnalyserClass = Class.forName("com.bridglabz.MoodAnalyzer");
            Constructor<?> moddConstructor = moodAnalyserClass.getConstructor(String.class);
            Object moodObj = moddConstructor.newInstance(message);
            return (MoodAnalyzer) moodObj;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
