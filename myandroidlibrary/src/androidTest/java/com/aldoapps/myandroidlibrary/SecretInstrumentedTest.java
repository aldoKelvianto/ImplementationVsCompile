package com.aldoapps.myandroidlibrary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.runner.AndroidJUnit4;

import com.aldoapps.myjavalibrary.MySecret;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void moneyIsTheSecret() {
        // Given
        // When
        final String secret = MySecret.getSecret();

        // Then
        assertNotNull(secret);
        assertEquals("Money", secret);
    }
}
