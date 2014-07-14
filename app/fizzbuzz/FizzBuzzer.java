package fizzbuzz;

public class FizzBuzzer {

   public String go(int number) {
      if (number == 0) {
         return "0";
      } else if (number % 3 == 0) {
         return "fizz";
      } else if (number % 5 == 0) {
         return "buzz";
      }
      return new Integer(number).toString();
   }
}
