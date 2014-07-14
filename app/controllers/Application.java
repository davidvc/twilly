package controllers;

import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import security.RequestVerifier;

import com.twilio.sdk.verbs.Gather;
import com.twilio.sdk.verbs.Say;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;

import fizzbuzz.FizzBuzzGame;

public class Application extends Controller {

   public static Result start() {
      if (isUnauthorized()) {
         return unauthorized();
      }

      TwiMLResponse twiml = new TwiMLResponse();

      try {
         Gather gather = new Gather();
         gather.setMethod("GET");
         gather.setAction("/twilly/fizzbuzz");

         Say say = new Say("Please enter a number to fizz up to");
         gather.append(say);

         twiml.append(gather);

      } catch (TwiMLException e) {
         Logger.error("Unable to create TWIML response", e);
         return internalServerError();
      }

      response().setContentType("application/xml");
      return ok(twiml.toXML());
   }

   public static Result fizzbuzz(String digits) {
      if (isUnauthorized()) {
         return unauthorized();
      }

      TwiMLResponse twiml = new TwiMLResponse();

      try {
         FizzBuzzGame game = new FizzBuzzGame();
         Say say = new Say(game.play(digits));
         twiml.append(say);
      } catch (TwiMLException e) {
         Logger.error("Unable to create TWIML response", e);
         return internalServerError();
      }

      response().setContentType("application/xml");
      return ok(twiml.toXML());
      
   }

   private static boolean isUnauthorized() {
      return !(new RequestVerifier().verifyRequest(request()));
   }
   

}
