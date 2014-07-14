package security;

import play.Logger;
import play.mvc.Http.Request;

import com.twilio.sdk.TwilioUtils;

import controllers.FizzBuzz;
import controllers.routes;

public class RequestVerifier {
   private static final String AUTH_TOKEN = "b609955334e78ced687e15a6077672a5";
   
   private final TwilioUtils twilioUtils;
   
   public RequestVerifier() {
      this(new TwilioUtils(AUTH_TOKEN));
   }
   public RequestVerifier(TwilioUtils twilioUtils) {
      this.twilioUtils = twilioUtils;
   }
   public boolean verifyRequest(Request request, String fullURI) {
      String signature = request.getHeader("X-Twilio-Signature");
      Logger.debug("Signature is " + signature);
      Logger.debug("URI is " + fullURI);
      
      // Not currently supporting POST params...
      return twilioUtils.validateRequest(signature, fullURI, null);
   }
}
