package com.github.thedeadone.unchecker;

import java.util.Optional;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static com.github.thedeadone.unchecker.Helper.uncheck;

public class SupplierUncheckTest {
    private static boolean throwException = false;

    private static String supplier() throws InterruptedException {
        if (throwException) {
            throw new InterruptedException();
        } else {
            return "success";
        }
    }

    @Test
    public void success() {
        throwException = false;

        assertThat(Optional.empty()
                           .orElseGet(uncheck(SupplierUncheckTest::supplier)), is("success"));
    }

    @Test(expected=InterruptedException.class)
    public void fail() {
        throwException = true;

        Optional.empty()
                .orElseGet(uncheck(SupplierUncheckTest::supplier));
    }
}
