package controllers;

import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import security.RequestVerifier;

import com.twilio.sdk.verbs.Say;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;

public class FizzBuzz extends Controller {

   public static Result fizzbuzz(String digits) {
      if (!(new RequestVerifier().verifyRequest(request()))) {
         Logger.debug("not authorized");
         return unauthorized();
      }
      

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
