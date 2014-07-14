package security;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import play.mvc.Http.Request;

import com.twilio.sdk.TwilioUtils;

import controllers.routes;

public class RequestVerifierTest {
   private RequestVerifier underTest;

   @Mock TwilioUtils twilioUtils;
   @Mock Request request;
   
   @Before
   public void setup() {
      initMocks(this);
      underTest = new RequestVerifier(twilioUtils);
   }

   @Test
   public void verifiesRequest() {
      String uri = "this/is/the/uri/";
      String params = ""
      String signature = "signature";

      when(request.getHeader("X-Twilio-Signature")).thenReturn(signature);
      
      when(twilioUtils.validateRequest(signature, uri, null)).thenReturn(true);
      
      assertTrue(underTest.verifyRequest(request, uri));
   }
   

}
