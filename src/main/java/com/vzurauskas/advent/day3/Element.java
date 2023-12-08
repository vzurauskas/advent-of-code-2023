package com.vzurauskas.advent.day3;

public interface Element {
    int value();
    Iterable<Element> children();
}
