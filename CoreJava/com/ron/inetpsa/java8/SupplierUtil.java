package com.ron.inetpsa.java8;

import java.util.function.Supplier;

public class SupplierUtil {
    public static void main(String[] args) {
        Supplier<Boolean> sb = ()->Boolean.valueOf("false");
        System.out.println(sb.get());
    }
}

