package com.aldoapps.myandroidlibrary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.aldoapps.myjavalibrary.MySecret;

public class SecretUnitTest {

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
