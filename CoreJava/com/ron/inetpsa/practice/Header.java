package com.ron.inetpsa.practice;

import java.util.HashMap;
import java.util.Map;

public class Header {
    public static void main(String[] args) {
       HashMap<String, String> hm = new HashMap<>();
            hm.put(  "argsClasses", "[int, java.lang.String, boolean]")
        ;

        String a =  String.valueOf(hm.get("argsClasses")).replaceAll("[()\\[\\]]","");
        System.out.println(a);
    }

}
