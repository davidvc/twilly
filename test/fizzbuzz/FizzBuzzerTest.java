package fizzbuzz;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FizzBuzzerTest {
   @Parameters
   public static Collection<Object[]> parameters() {
      return Arrays.asList(new Object[][] {
               // input, expected output
               {3, "fizz"},
               {6, "fizz"},
               {7, "7"},
               {15, "fizz buzz"}, 
               {30, "fizz buzz"}, 
               {5, "buzz"},
               {0, "0"},
               {-1, "-1"},
               {-3, "fizz"},
               {-5, "buzz"},
               {-15, "fizz buzz"},
      });
   }
   
   private final FizzBuzzer underTest;
   private final int input;
   private final String expectedOutput;
   
   public FizzBuzzerTest(int input, String expectedOutput) {
      this.input = input;
      this.expectedOutput = expectedOutput;
      this.underTest = new FizzBuzzer();
   }
   
   @Test
   public void fizzbuzz() {
      assertEquals(expectedOutput, underTest.go(input) );
   }

}
