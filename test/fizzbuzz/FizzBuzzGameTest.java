package fizzbuzz;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


public class FizzBuzzGameTest {
   private FizzBuzzGame underTest;
   @Mock private FizzBuzzer fizzBuzz;
   
   @Before
   public void setup() {
      initMocks(this);
      underTest = new FizzBuzzGame(fizzBuzz);
   }
   
   @Test
   public void returnsEmptyStringForNegativeInteger() {
      assertEquals("",  underTest.play("-28"));
   }
   
   @Test
   public void returnsEmptyStringForZero() {
      assertEquals("", underTest.play("0"));
      
   }

   @Test
   public void returnsListOfResults() {
      when(fizzBuzz.go(anyInt())).thenReturn("1", "fizz buzz", "buzz", "7");
      
      assertEquals("1, fizz buzz, buzz, 7", underTest.play("4"));
   }

   @Test
   public void returnsSingleResult() {
      when(fizzBuzz.go(anyInt())).thenReturn("1");
      
      assertEquals("1", underTest.play("1"));
   }

}
