package com.github.thedeadone.unchecker;

import java.util.Optional;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static com.github.thedeadone.unchecker.Helper.uncheck;

public class ConsumerUncheckTest {
    private static void consumer(String value) throws InterruptedException {
        if (!"success".equals(value)) {
            throw new InterruptedException();
        }
        assertThat(value, is("success"));
    }

    @Test
    public void success() {
        Optional.of("success")
                .ifPresent(uncheck(ConsumerUncheckTest::consumer));
    }

    @Test(expected=InterruptedException.class)
    public void fail() {
        Optional.of("fail")
                .ifPresent(uncheck(ConsumerUncheckTest::consumer));
    }
}
