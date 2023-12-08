package com.vzurauskas.advent.day3;

import java.util.Set;

public interface Element {
    int value();
    Set<? extends Element> children();
}
