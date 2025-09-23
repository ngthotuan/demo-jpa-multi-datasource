package com.tuannt.demo.configs;

/**
 * Created by tuannt7 on 23/09/2025
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE;

@Retention(RetentionPolicy.RUNTIME)
@Target(TYPE)
public @interface PrdRepositoryMarker {}
