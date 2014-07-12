package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import com.twilio.sdk.verbs.Say;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;

public class Application extends Controller {

    public static Result index() {
       TwiMLResponse twiml = new TwiMLResponse();
       Say say = new Say("Hello Monkey");
       try {
           twiml.append(say);
       } catch (TwiMLException e) {
           e.printStackTrace();
       }

       response().setContentType("application/xml");
       return ok(twiml.toXML());
    }

}
