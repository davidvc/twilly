package fizzbuzz;

import play.Logger;


public class FizzBuzzGame {

   private final FizzBuzzer fizzBuzzer;

   public FizzBuzzGame() {
      this(new FizzBuzzer());
   }

   FizzBuzzGame(FizzBuzzer fizzBuzzer) {
      this.fizzBuzzer = fizzBuzzer;
   }

   public String play(String numberString) {
      if (numberString == null || numberString.isEmpty()) {
         return "";
      }

      int number = Integer.parseInt(numberString);
      
      StringBuilder builder = new StringBuilder();
      for (int i = 1 ; i <= number ; i++) {
         builder.append(fizzBuzzer.go(i));
         builder.append(", ");
      }
      
      String result = builder.toString();

      if (result.length() == 0) {
         return result;
      }

      return result.substring(0, result.length() - 2);
   }

}
