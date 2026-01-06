package com.ron.inetpsa.collection;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test11 {

    public void MethodTest(){
        int i=20;
        class MethodTest1{
            int i=10;
        }
        System.out.println(MethodTest1.class.getEnclosingMethod().getName());
        System.out.println(i);
    }
    public static void main(String[] args) {
        Test11 t = new Test11();
        //t.MethodTest();
        Map<String, String> map = new HashMap<>();
        map.put("ABC", "12a3");
        map.put("ACB", "1d32");
        map.put("BCA", "1f13");
        map.put("BAC", "131");
       /* try {
            int a = 5 / 0;
        }finally {
            System.out.println("Hi");
        }*/
        Double a = 25.6;
        Double b = 24.6;
        System.out.println(a>b);
        String s1 = "R24.67";
       Double f =  Double.parseDouble(s1.substring(s1.indexOf('R') + 1, s1.indexOf("R") + 5));
        System.out.println(f);
        System.out.println(24.5>45);
        String ehname = "/shelf=1/slot=3/";
        Pattern pattern = Pattern.compile("shelf\\s*=(.*?)/\\s*slot\\s*=(.*?)/");
        Matcher matcher = pattern.matcher(ehname);
        String shelfNumber = "0";
        String slotNumber = "0";
        if (matcher.find()) {
            shelfNumber = matcher.group(1).trim();
            slotNumber = matcher.group(2).trim();
        }
        System.out.println(shelfNumber);
        System.out.println(slotNumber);
        int shelf = Integer.parseInt(shelfNumber);
        int slot = Integer.parseInt(slotNumber);
        slot = (slot << 16) & 0x003f0000;
        shelf = (shelf << 22) & 0x0fc00000;
        int switchId = 0x10000000 | shelf | slot;
        System.out.println(switchId);
        int neId = 1;
        List<String> vsidList = new ArrayList<>();
        vsidList.add("11QPE24-3-10-%");
        int count = 0;
        String query = "select count(*) from TP where NEID = " + neId
                + " and ETHERNETTPROLE = " + 1 + " AND ";
        HashMap<String ,Object> queryMap = new HashMap<>();
        Iterator<String> it = vsidList.iterator();
        StringBuilder vsListStr = new StringBuilder();
        int i =0;
        while (it.hasNext()) {
            String tempString = it.next();
            String tempStr = "tpNativeName"+i;
            queryMap.put(tempStr,tempString);
            vsListStr.append("(tpnativename like '").append(tempString).append("')").append(" OR ");
            i++;
        }
        if (!vsListStr.toString().isEmpty()) {
            vsListStr = new StringBuilder(vsListStr.substring(0, vsListStr.lastIndexOf(" OR")));
            System.out.println(vsListStr);
        }
        query = query + vsListStr;
        System.out.println(query);
        System.out.println("Ronish"+queryMap);
        StringBuilder vsListStr1 = new StringBuilder();
        System.out.println(vsListStr1.isEmpty());
        List<Long> lt = new ArrayList<>();
        lt.add((long)1);
        int k = (int)(long)lt.get(0);
        System.out.println(k);
        Date localDate = new Date();
        System.out.println(localDate);
        TimeZone localZone = Calendar.getInstance().getTimeZone();
        if (localZone.inDaylightTime(localDate)) {
            Date dayLightSavingDate = new Date(localDate.getTime()
                    - localZone.getDSTSavings());
            if (localZone.inDaylightTime(dayLightSavingDate)) {
                localDate = dayLightSavingDate;
            }
        }
        System.out.println(localDate.getTime());
    }
    }

