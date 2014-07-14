package fizzbuzz;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {
   private FizzBuzz underTest;
   
   @Before
   public void setup() {
      underTest = new FizzBuzz();
   }

   @Test
   public void fizzOnNumbersDivisibleByThree() {
      assertEquals("fizz", underTest.go(6) );
   }
   
   @Test
   public void numberBackOnNumbersNotDivisibleByThreeOrFive() {
      assertEquals("7", underTest.go(7));
      
   }
   
   @Test
   public void buzzOnNumbersDivisibleByFiveAndNotByThree() {
      
   }
   
   @Test
   public void fizzOnNumbersDivisibleByFivenAndByThree() {
      
   }
   
   @Test
   public void numberBackOnZero() {
      
   }
   
   @Test
   public void negativeFizz() {
      
   }
   
   @Test
   public void negativeBuzz() {
      
   }

}
