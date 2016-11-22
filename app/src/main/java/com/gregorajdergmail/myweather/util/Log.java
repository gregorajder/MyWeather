package com.gregorajdergmail.myweather.util;

import android.text.TextUtils;

public final class Log {
    static String TAG = "fewf";

    public static void d(String tag, String msg) {
        android.util.Log.d(tag, getLocation() + " " + msg);
    }

    public static void d(String msg) {
        android.util.Log.d(TAG, getLocation() + " " + msg);
    }

    public static void d() {
        android.util.Log.d(TAG, getLocation());
    }

    public static void i(String tag, String msg) {
        android.util.Log.i(tag, getLocation() + " " + msg);
    }

    public static void i(String msg) {
        android.util.Log.i(TAG, getLocation() + " " + msg);
    }

    public static void i() {
        android.util.Log.i(TAG, getLocation());
    }

    public static void v(String tag, String msg) {
        android.util.Log.v(tag, getLocation() + " " + msg);
    }

    public static void v(String msg) {
        android.util.Log.v(TAG, getLocation() + " " + msg);
    }

    public static void v() {
        android.util.Log.v(TAG, getLocation());
    }

    public static void e(String tag, String msg) {
        android.util.Log.e(tag, getLocation() + " " + msg);
    }

    public static void e(String tag, String msg, Exception e) {
        android.util.Log.e(tag, getLocation() + " " + msg, e);
    }

    public static void e(String msg) {
        android.util.Log.e(TAG, getLocation() + " " + msg);
    }

    public static void e(String msg, Exception e) {
        android.util.Log.e(TAG, getLocation() + " " + msg, e);
    }

    public static void e() {
        android.util.Log.e(TAG, getLocation());
    }

    public static void w(String tag, String msg) {
        android.util.Log.w(tag, getLocation() + " " + msg);
    }

    public static void w(String msg) {
        android.util.Log.w(TAG, getLocation() + " " + msg);
    }

    public static void w() {
        android.util.Log.w(TAG, getLocation());
    }

    private static String getLocation() {
        final String className = Log.class.getName();
        final StackTraceElement[] traces = Thread.currentThread().getStackTrace();
        boolean found = false;
        for (int i = 0; i < traces.length; i++) {
            StackTraceElement trace = traces[i];
            try {
                if (found) {
                    if (!trace.getClassName().startsWith(className)) {
                        Class<?> clazz = Class.forName(trace.getClassName());
                        return "[" + getClassName(clazz) + ":" + trace.getMethodName() + ":" + trace.getLineNumber() + "]: ";
                    }
                } else if (trace.getClassName().startsWith(className)) {
                    found = true;
                    continue;
                }
            } catch (ClassNotFoundException e) {
            }
        }
        return "[]: ";
    }

    private static String getClassName(Class<?> clazz) {
        if (clazz != null) {
            if (!TextUtils.isEmpty(clazz.getSimpleName())) {
                return clazz.getSimpleName();
            }
            return getClassName(clazz.getEnclosingClass());
        }
        return "";
    }

}
