package com.tobedevoured.modelcitizen.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Field that is a List of Mapped Models defined by aliases
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MappedListByAliases {

    /**
     * The target Blueprint Class used to create Models.
     *
     * @return Class
     */
    Class target();

    /**
     * The List created, defaults to ArrayList
     *
     * @return Class
     */
    Class targetList() default NotSet.class;

    /**
     * If true, do not create instances for an empty List. Defaults
     * to true.
     *
     * @return boolean
     */
    boolean ignoreEmpty() default true;

    /**
     * Force the value of the MappedList to always be set, even if
     * the target field already has a value. Default is false.
     *
     * @return boolean
     */
    boolean force() default false;

    /**
     * Aliases of blueprints for populating from blueprints. Size will be overridden by this property, with size of array.
     */
    String[] aliases();

}
