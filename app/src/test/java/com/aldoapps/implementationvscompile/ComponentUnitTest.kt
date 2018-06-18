package com.aldoapps.implementationvscompile

import com.aldoapps.myandroidlibrary.MyAndroidComponent
import junit.framework.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

class ComponentUnitTest {

    @Test
    fun moneyIsTheComponent() {
        // Given
        // When
        val component = MyAndroidComponent.getComponent()

        // Then
        Assert.assertNotNull(component)
        assertEquals("My Component: Money", component)
    }

    @Test
    fun unableToAccessSecret() {
        // Given
        // When
        // val secret = MySecret.getSecret()

        // Then
        // Assert.assertNotNull(secret)
        // assertEquals("Money", secret)
    }
}
