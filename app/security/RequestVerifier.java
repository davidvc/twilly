package security;

import play.Logger;
import play.mvc.Http.Request;

import com.twilio.sdk.TwilioUtils;

public class RequestVerifier {
   private static final String AUTH_TOKEN = "b609955334e78ced687e15a6077672a5";
   
   private final TwilioUtils twilioUtils;
   
   public RequestVerifier() {
      this(new TwilioUtils(AUTH_TOKEN));
   }

   public RequestVerifier(TwilioUtils twilioUtils) {
      this.twilioUtils = twilioUtils;
   }

   public boolean verifyRequest(Request request) {
      String signature = request.getHeader("X-Twilio-Signature");
      
      String fullURI = "https://" + request.host() + request.uri();

      Logger.debug("Signature is " + signature);
      Logger.debug("URI is " + fullURI);
      
      // Not currently supporting POST params...
      boolean result = twilioUtils.validateRequest(signature, fullURI, null);
      
      if (!result) {
         Logger.debug("not authorized");
      }
      
      return result;
   }
}
