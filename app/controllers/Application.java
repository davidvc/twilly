package controllers;

import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import security.RequestVerifier;

import com.twilio.sdk.verbs.Gather;
import com.twilio.sdk.verbs.Say;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;

public class Application extends Controller {

   public static Result index() {
      Logger.debug("verifying request");
      if (!(new RequestVerifier().verifyRequest(request()))) {
         Logger.debug("unauthorized");
         return unauthorized();
      }

      TwiMLResponse twiml = new TwiMLResponse();

      try {
         Gather gather = new Gather();
         gather.setMethod("GET");
         gather.setAction("/fizzbuzz");

         Say say = new Say("Please enter a number to fizz up to");
         gather.append(say);

         twiml.append(gather);

      } catch (TwiMLException e) {
         e.printStackTrace();
      }

      response().setContentType("application/xml");
      return ok(twiml.toXML());
   }

}
