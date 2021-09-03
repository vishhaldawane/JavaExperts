package com.thothit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//meta-data means data's data


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DevelopedBy { //this is a modern way to store meta-data
    String developerName();
    String date();
    String time();
    double version();
}
