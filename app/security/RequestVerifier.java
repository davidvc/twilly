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
   public boolean verifyRequest(Request request, String fullPath) {
      String signature = request.getHeader("X-Twilio-Signature");
      
      // Strip off the last slash in the uri
      fullPath = fullPath.substring(0, fullPath.length() - 1);
      
      // Strip off the first slash from the uri
      String uri = request.uri().substring(1, fullPath.length());
      String fullURI = fullPath + uri;

      Logger.debug("Signature is " + signature);
      Logger.debug("URI is " + fullURI);
      
      // Not currently supporting POST params...
      return twilioUtils.validateRequest(signature, fullURI, null);
   }
}
