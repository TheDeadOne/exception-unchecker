package dev.gornostaev;

import java.util.Optional;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import static dev.gornostaev.ExceptionUnchecker.uncheck;


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
    public void testSuccess() {
        throwException = false;

        assertThat(Optional.ofNullable(null)
                           .orElseGet(uncheck(SupplierUncheckTest::supplier)), is("success"));
    }

    @Test(expected=InterruptedException.class)
    public void testFail() {
        throwException = true;

        Optional.ofNullable(null)
                .orElseGet(uncheck(SupplierUncheckTest::supplier));
    }
}
