package com.epam.testdata.xlsparser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Oleh_Maksymuk on 11/6/2015.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface KeyLabel {

    String value() ;

}
