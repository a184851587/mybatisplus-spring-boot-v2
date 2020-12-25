package com.baomidou.springboot;

import org.thymeleaf.util.DateUtils;

import java.sql.Time;
import java.util.Date;

public class Test {


    public static void main(String[] args) {
        Date date = new Date();
        Time time = new Time(date.getTime());
        System.out.println(time);
    }
}
