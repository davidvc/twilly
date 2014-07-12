package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import com.twilio.sdk.verbs.Say;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;

public class FizzBuzz extends Controller {
   public static Result fizzbuzz(String digits) {
      TwiMLResponse twiml = new TwiMLResponse();

      try {
         Say say = new Say("You entered the digits " + digits);
         twiml.append(say);

      } catch (TwiMLException e) {
         e.printStackTrace();
      }

      response().setContentType("application/xml");
      return ok(twiml.toXML());
      
   }

}
