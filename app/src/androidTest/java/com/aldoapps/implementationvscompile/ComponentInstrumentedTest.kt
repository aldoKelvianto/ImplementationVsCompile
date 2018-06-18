package com.aldoapps.implementationvscompile

import android.support.test.runner.AndroidJUnit4
import com.aldoapps.myandroidlibrary.MyAndroidComponent
import junit.framework.Assert.assertNotNull
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ComponentInstrumentedTest {

    @Test
    fun moneyIsTheSecret() {
        // Given
        // When
        val component = MyAndroidComponent.getComponent()

        // Then
        assertNotNull(component)
        assertEquals("My Component: Money", component)
    }

}
