package com.vzurauskas.advent.day1;

import com.vzurauskas.advent.tech.LinesOfFile;

public final class Solution {
    private final CalibrationDoc doc;

    Solution() {
        this.doc = new CalibrationDoc(
            new LinesOfFile(
                "com\\vzurauskas\\advent\\day1\\input.txt"
            ).value()
        );
    }

    @Override
    public String toString() {
        return String.valueOf(doc.value());
    }

    public static void main(String[] args) {
        System.out.println(new Solution());
    }
}
