package com.bridglabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyserReflector {
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

    public static Constructor getConstructor(Class<?>... parameter) throws NoSuchMethodException, ClassNotFoundException {

        Class moodAnalyserClass = Class.forName("com.bridglabz.MoodAnalyzer");
        Constructor moodConstructor = moodAnalyserClass.getConstructor(parameter);
        return moodConstructor;
    }

    public static Object moodAnalyserGetObject(Constructor constructor,String... message) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        try {
            System.out.println(message);
            Object moodObj = constructor.newInstance(message);
            return moodObj;
        }catch (NullPointerException e){
            throw new MoodException(MoodException.ExceptionType.ENTERD_NULL,"Null_Pointer_Exception");
        }
    }

    public static Object getMethod(String param,Object moodObject) {
        Object obj = null;
        try {

            Class<?> aClass = moodObject.getClass();
            Method method = aClass.getDeclaredMethod(param);
            obj = method.invoke(moodObject);

        } catch (NoSuchMethodException e) {
            throw new MoodException(MoodException.ExceptionType.NO_SUCH_METHOD_ERROR,"No_Such_Method");
        }
         catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return obj;
    }

    public static Field getField(String fieldName) {

        Field field = null;
        try {
             field = Class.forName("com.bridglabz.MoodAnalyzer").getField(fieldName);
        } catch (NoSuchFieldException e) {
            throw new MoodException(MoodException.ExceptionType.NO_SUCH_FIELD,"No_Such_Field");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return field;
    }
}
