package com.github.thedeadone.unchecker;

import java.util.Optional;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static com.github.thedeadone.unchecker.Helper.uncheck;

public class PredicateUncheckTest {
    private static boolean predicate(String value) throws InterruptedException {
        if (!"success".equals(value)) {
            throw new InterruptedException();
        }
        return true;
    }

    @Test
    public void success() {
        assertThat(Optional.of("success")
                           .filter(uncheck(PredicateUncheckTest::predicate))
                           .get(), is("success"));
    }

    @Test(expected=InterruptedException.class)
    public void fail() {
        Optional.of("fail")
                .filter(uncheck(PredicateUncheckTest::predicate))
                .get();
    }
}
