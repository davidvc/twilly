import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

import static org.fluentlenium.core.filter.FilterConstructor.*;

public class IntegrationTest {
    @Test
    public void fizzBuzzTest() {
        running(testServer(8000, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
            public void invoke(TestBrowser browser) {
                browser.goTo("http://localhost:8000/twilly/fizzbuzz?Digits=7");
                assertThat(browser.pageSource()).contains("1, 2, fizz, 4, buzz, fizz, 7");
            }
        });
    }

}
