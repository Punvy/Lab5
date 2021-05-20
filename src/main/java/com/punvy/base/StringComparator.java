package com.punvy.base;

import java.util.Comparator;

public class StringComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1 == null) {
            return -o2.toString().length();
        }
        if (o2 == null) {
            o1.toString().length();
        }
        return o1.toString().length() - o2.toString().length();
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
