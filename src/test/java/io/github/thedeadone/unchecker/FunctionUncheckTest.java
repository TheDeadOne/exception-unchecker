package io.github.thedeadone.unchecker;

import java.util.Optional;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static io.github.thedeadone.unchecker.Helper.uncheck;

public class FunctionUncheckTest {
    private static String function(String value) throws InterruptedException {
        if ("success".equals(value)) {
            return value;
        } else {
            throw new InterruptedException();
        }
    }

    @Test
    public void success() {
        assertThat(Optional.of("success")
                           .map(uncheck(FunctionUncheckTest::function))
                           .get(), is("success"));
    }

    @Test(expected=InterruptedException.class)
    public void fail() {
        Optional.of("fail")
                .map(uncheck(FunctionUncheckTest::function))
                .get();
    }
}
