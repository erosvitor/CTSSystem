package com.ctseducare.ctssystem.util;

public class SystemUtils {

    public static int getAPILevel() {
        return android.os.Build.VERSION.SDK_INT;
    }

    public static String getAPIName() {
        String apiName;
        switch (getAPILevel()) {
            case 14:
            case 15:
                apiName = "Ice Cream Sandwich"; break;
            case 16:
            case 17:
            case 18:
                apiName = "Jelly Bean"; break;
            case 19:
            case 20:
                apiName = "KitKat"; break;
            case 21:
            case 22:
                apiName = "Lollipop"; break;
            case 23:
                apiName = "Marshmallow"; break;
            case 24:
            case 25:
                apiName = "Nougat"; break;
            case 26:
            case 27:
                apiName = "Oreo"; break;
            case 28:
                apiName = "Pie"; break;
            case 29:
                apiName = "Android 10"; break;
            case 30:
                apiName = "Android 11"; break;
            default:
                apiName = "Other"; break;
        }
        return apiName;
    }

    public static String getVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

}
