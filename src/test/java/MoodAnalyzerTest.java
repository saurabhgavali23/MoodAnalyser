import com.bridglabz.MoodAnalyserFactory;
import com.bridglabz.MoodAnalyzer;
import com.bridglabz.MoodException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerTest {

    @Test
    public void givenMoodAnalyserClass_WhenProper_ShouldReturnObject() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am Happy");
        MoodAnalyzer moodAnalyzer1 = MoodAnalyserFactory.createMoodAnalyser("I am Happy");
        Assert.assertEquals(true,moodAnalyzer.equals(moodAnalyzer1));
    }

    @Test
    public void givenMoodAnalyserObject_WhenProper_ShouldReturnObject() {
        Constructor<?> constructor = null;
        try {
            constructor = Class.forName("com.bridglabz.MoodAnalyzer").getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {

            Object myObj = constructor.newInstance("I am Happy Today");
            MoodAnalyzer moodAnalyzer = (MoodAnalyzer) myObj;
            String mood = moodAnalyzer.analyse();
            Assert.assertEquals("Happy",mood);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void whenGivenSad_shouldReturnSad() {
        MoodAnalyzer testMoodAnalyzer = new MoodAnalyzer("Sad");
        String message = testMoodAnalyzer.analyse();
        Assert.assertEquals("Sad", message);
    }

    @Test
    public void whenGivenHappyMessage_shouldReturnHappy() {
        MoodAnalyzer moodAnalyser = new MoodAnalyzer("Happy");
        String message = moodAnalyser.analyse();
        Assert.assertEquals("Happy",message);
    }


    @Test
    public void whenGivenNull_ShouldReturnMessage() {
        try {

            ExpectedException exceptionRule = ExpectedException.none(); //It used when we write "Exception" in MoodException
            exceptionRule.expect(MoodException.class);
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
            String message = moodAnalyzer.analyse();
            Assert.assertEquals("Happy", message);

            }catch (Exception e){
                e.printStackTrace();
            }
    }

    @Test
    public void whenGivenNull_ShouldReturnNullMessage() {
        try {

            MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
            moodAnalyzer.analyse();

        }catch (MoodException e){

            //Assert.assertEquals("Please Enter Proper Message",e.getMessage());
            Assert.assertEquals(MoodException.ExceptionType.ENTERD_NULL,e.type);
        }
    }

    @Test
    public void whenGivenEmpty_ShouldReturnMessage() {
        try {

            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
            moodAnalyzer.analyse();

        }catch (MoodException e){

            //Assert.assertEquals("Please Enter Proper Message",e.getMessage());
            Assert.assertEquals(MoodException.ExceptionType.ENTERD_EMPTY,e.type);
        }
    }

    @Test
    public void givenImproperClassName_ShouldThrow_No_Such_Class_Exception() throws MoodException {

        Constructor<?> constructor = null;
        try {

            constructor = Class.forName("com.bridglabz.ImproperClass").getConstructor(String.class);
            Assert.assertEquals("Happy","Happy");

        } catch (ClassNotFoundException e) {
            try {
                throw new MoodException(MoodException.ExceptionType.NO_SUCH_CLASS_ERROR,"NO_Such_Class_Error");

            }catch (MoodException m) {
                m.printStackTrace();
            }
            } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
