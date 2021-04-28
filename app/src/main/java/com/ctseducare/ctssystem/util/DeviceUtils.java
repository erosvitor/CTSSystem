package com.ctseducare.ctssystem.util;

import android.content.Context;
import android.content.res.Configuration;

public class DeviceUtils {

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public static String getDeviceType(Context context) {
        String deviceType;
        if (isTablet(context)) {
            deviceType = "Tablet";
        } else {
            deviceType = "Smartphone";
        }
        return deviceType;
    }

    public static String getBrand() {
        return android.os.Build.BRAND;
    }

    public static String getModel() {
        return android.os.Build.MODEL;
    }

    public static int getNumberCPUs() {
        return Runtime.getRuntime().availableProcessors();
    }
}
