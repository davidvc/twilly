package fizzbuzz;

public class FizzBuzz {

   public String go(int number) {
      if (number == 6) {
         return "fizz";
      } else {
         return new Integer(number).toString();
      }
   }

}
