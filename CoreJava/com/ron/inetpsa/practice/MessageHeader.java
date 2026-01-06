package com.ron.inetpsa.practice;

import java.util.HashMap;
import java.util.List;

public class MessageHeader {

    HashMap<String,String> map;

    public HashMap<String, String> getMap() {
        return map;
    }

    public MessageHeader(HashMap<String, String> map) {
        this.map = map;
    }

    public void setMap(HashMap<String, String > map) {
        this.map = map;
    }

}
