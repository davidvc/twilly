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
      
      // Strip off the first slash from the uri
      String uri = request.uri();
      uri = uri.substring(1, uri.length());
      
      // Strip off the port number
      String host = request.host();
      host = host.substring(0, host.lastIndexOf(":"));

      Logger.debug("request host is " + host);
      Logger.debug("uri is " + uri);

      String fullURI = "https://" + host + uri;

      Logger.debug("Signature is " + signature);
      Logger.debug("URI is " + fullURI);
      
      // Not currently supporting POST params...
      return twilioUtils.validateRequest(signature, fullURI, null);
   }
}
