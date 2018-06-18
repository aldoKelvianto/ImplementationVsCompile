package com.aldoapps.myandroidlibrary;

import com.aldoapps.myjavalibrary.MySecret;

public final class MyAndroidComponent {

    private static final String component = MySecret.getSecret();

    public static String getComponent() {
        return "My Component: " + component;
    }

    private MyAndroidComponent() {}
}
