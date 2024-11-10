package com.github.boros41.access;

public interface LivingEntityAccess {
    default boolean isBlessed() {
        return false;
    }
    default void setBlessed(boolean bool) {

    }
}
