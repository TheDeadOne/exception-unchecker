package dev.gornostaev;

import java.util.Optional;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import static dev.gornostaev.ExceptionUnchecker.uncheck;


public class FunctionUncheckTest {
    private static String function(String value) throws InterruptedException {
        if ("success".equals(value)) {
            return value;
        } else {
            throw new InterruptedException();
        }
    }

    @Test
    public void testSuccess() {
        assertThat(Optional.of("success")
                           .map(uncheck(FunctionUncheckTest::function))
                           .get(), is("success"));
    }

    @Test(expected=InterruptedException.class)
    public void testFail() {
        Optional.of("fail")
                .map(uncheck(FunctionUncheckTest::function))
                .get();
    }
}
