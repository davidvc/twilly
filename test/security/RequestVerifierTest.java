package security;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import play.mvc.Http;

import com.twilio.sdk.TwilioUtils;

public class RequestVerifierTest {
   private RequestVerifier underTest;

   @Mock TwilioUtils twilioUtils;
   @Mock Http.Request request;
   
   @Before
   public void setup() {
      initMocks(this);
      underTest = new RequestVerifier(twilioUtils);
   }

   @Test
   public void verifiesRequest() {
      String host = "host";
      String uri = "this/is/the/uri/";
      String signature = "signature";

      when(request.getHeader("X-Twilio-Signature")).thenReturn(signature);
      when(request.host()).thenReturn(host);
      when(request.uri()).thenReturn(uri);
      
      when(twilioUtils.validateRequest(signature, "https://" + host + uri, null)).thenReturn(true);
      
      assertTrue(underTest.verifyRequest(request));
   }
   

}
