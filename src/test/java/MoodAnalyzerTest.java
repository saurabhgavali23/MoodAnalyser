import com.bridglabz.MoodAnalyzer;
import com.bridglabz.MoodException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyzerTest {

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
}
