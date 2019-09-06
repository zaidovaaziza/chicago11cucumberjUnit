import org.junit.Assert;
import org.junit.Test;

public class TimeFormatIbrayimMentoring {

    public double getSumofOdds(int[] numbers){
        if(numbers == null) return -1;
        double sum = 0;
        for(int number : numbers){
            if(number % 2 != 0){
                sum += number;
            }
        }
        return sum;
    }

    @Test
    public void happyPath(){
        int[] testData = {1,2,3,4,5};
        double expectedResult = 9;
        Assert.assertTrue
                ( expectedResult == new TimeFormatIbrayimMentoring().getSumofOdds(testData));
    }

    /*
   you have a map API that returns time needed to get from origin to destination in "hh:mm" format.
   Write a method that will accept String and return integer minutes. Examples input "12:15" output 735.
   Throw IllegalFormatException if invalid format  like "", "ab:bc", "12-15" passed.
   throw NullPointerException if null value passed
   create unit tests to validate all the above requirements.
   5:61
   1234:33
   12-44
   */

//    static int convertHoursToMin(String hours) throws Exception{
//
//        if(hours == null) throw new NullPointerException();
//        String regex = "^-?\\d*\\:\\d{2}$";
//
//        if(!hours.matches(regex)) throw new com.sun.media.sound.InvalidFormatException();
//        String[] split = hours.split(":");
//
//
//        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
//
//    }

//    @Test
//    public void testValidInput() throws Exception{
//        String testData = " 5:55";
//        int expected = 355;
//        Assert.assertEquals(expected, convertHoursToMin(testData));
//    }

//    @Test
//    public void testInvalidInput() throws Exception{
//        String testData = "12:444";
//        Exception actualException = null;
//        try{
//            convertHoursToMin(testData);
//
//        }catch (Exception e){
//            actualException = e;
//        }
//        Assert.assertTrue("Invalid format exception validation failed, Expected: InvalidFormatException, but was: "+ actualException.toString(),actualException instanceof InvalidFormatException);
//
//    }
//
//    @Test
//    public void testNullInput(){
//        String testData = "shgslkjhgf";
//        Exception actualException = null;
//        try{
//            convertHoursToMin(testData);
//
//        }catch (Exception e){
//            actualException = e;
//        }
//        Assert.assertTrue("Invalid format exception validation failed, Expected: NullPointerException, but was: "+ actualException.toString(),actualException instanceof NullPointerException);

//    }





}
