package com.safecode.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Timestamp {

    public static void main(String[] args) {
    String t1 = "2008-03-10 16:25:02";
    String t2 = "2008-03-10 18:26:02";

    Date d1 = null;
    Date d2 = null;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    try {
        d1 = sdf.parse(t1);
        d2 = sdf.parse(t2);
    } catch (ParseException pe) {
        System.out.println(pe.getMessage());
    }
    
    long dd1 = d1.getTime();
    long dd2 = d2.getTime();
    long hours =(dd2-dd1)/3600/1000;
    System.out.println("时间差是："+hours+"（小时）");
    
    }
}

