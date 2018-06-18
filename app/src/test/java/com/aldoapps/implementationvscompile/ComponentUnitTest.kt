package com.aldoapps.implementationvscompile

import com.aldoapps.myandroidlibrary.MyAndroidComponent
import com.aldoapps.myjavalibrary.MySecret
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test


class ComponentUnitTest {

    @Test
    fun moneyIsTheComponent() {
        // Given
        // When
        val component = MyAndroidComponent.getComponent()

        // Then
        assertNotNull(component)
        assertEquals("My Component: Money", component)
    }

    @Test
    fun unableToAccessSecret() {
        // Given
        // When
        val secret = MySecret.getSecret()

        // Then
        assertNotNull(secret)
        assertEquals("Money", secret)
    }
}
