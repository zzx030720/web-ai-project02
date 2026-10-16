package com.zzx.utils;

public class CurrentHolder {

    private static final ThreadLocal<Integer> CURRENT_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<String>  CURRENT_NAME = new ThreadLocal<>();

    public static void setCurrentId(Integer employeeId) {
        CURRENT_LOCAL.set(employeeId);
    }

    public static Integer getCurrentId() {
        return CURRENT_LOCAL.get();
    }

    public static void remove() {
        CURRENT_LOCAL.remove();
        CURRENT_NAME.remove(); // 同时移除姓名，避免线程池复用导致脏数据
    }

    public static void setCurrentName(String name) {
        CURRENT_NAME.set(name);
    }
    public static String getCurrentName() {
        return CURRENT_NAME.get();
    }

}
