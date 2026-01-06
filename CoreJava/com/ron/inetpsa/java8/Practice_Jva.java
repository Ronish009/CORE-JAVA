package com.ron.inetpsa.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Practice_Jva {
    public static void main(String[] args) {
        String s = "ro12ni89sh765";
        // Output Alphabet : r,o,n,i,s,h    Number : 1,2,8,9,6,5
        var res = IntStream.range(0, s.length()).
                mapToObj(s::charAt).
                collect(Collectors.partitioningBy(Character::isDigit, Collectors.mapping(String::valueOf, Collectors.joining(","))));
        System.out.println("Alphabet : " + res.get(false));
        System.out.println("Number : " + res.get(true));
        String s1 = "ro92ni68sh21a";
        var res1 = IntStream.range(0, s1.length()).
                mapToObj(s1::charAt).
                collect(Collectors.partitioningBy(Character::isDigit, Collectors.collectingAndThen(Collectors.mapping(String::valueOf, Collectors.toList()), list -> {
                            if (list.isEmpty()) return list;
                            if (Character.isDigit(list.get(0).charAt(0))) {
                                return list.stream()
                                        .map(Integer::valueOf)
                                        .sorted()
                                        .map(String::valueOf)
                                        .toList();
                            } else {
                                return list.stream()
                                        .sorted()
                                        .toList();
                            }
                        })
                ));
        System.out.println("Alphabet : " + res1.get(false));
        System.out.println("Number : " + res1.get(true));
        System.out.println();
        String s2 = "ron12ed";
        for (Character c : s2.toCharArray()) {
            if (Character.isDigit(c)) {
                System.out.println("is Number" + c);
            }
        }
        String s3 = "ro12ni81sh765";
        System.out.println(
                Pattern.compile("\\d+").matcher(s3).results().map(a -> Integer.parseInt(a.group())).map(n -> n + 1).toList());
        List<Integer> final1 = Pattern.compile("\\d+").matcher(s3).results().map(s4 -> s4.group()).map(s5 -> s5.chars().sorted().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining())).map(Integer::parseInt).toList();
        System.out.println(final1);
        List<Integer> final2 = Pattern.compile("\\d")
                .matcher(s3)
                .results()
                .map(s5 -> Integer.parseInt(s5.group()))
                .sorted()
                .toList();
        System.out.println(String.valueOf(49));
        System.out.println(String.valueOf((char) 49));
        System.out.println(final2);
        Integer k = Character.getNumericValue('a');
        System.out.println(k);

        List<Integer> secondDigits = Pattern.compile("\\d+")
                .matcher(s3)
                .results()
                .map(m -> m.group())
                .filter(num -> num.length() == 2)   // only 2-digit numbers
                .map(num -> num.charAt(1) - '0')
                .sorted()
                .collect(Collectors.toList());
        System.out.println(secondDigits);

        String str5 = "ro12ni82sh76fgd76jgd89dsd45saa90adsa12";
        Map<Integer, Long> map = Pattern.compile("\\d+")
                .matcher(str5)
                .results()
                .map(MatchResult::group)
                .filter(a -> a.length() == 2)
                .map(a -> a.charAt(1) - '0')
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
        System.out.println(map);
        String input = "GBE100-19-8-2";
        String replaced = input.replaceFirst("^GBE100", "PORT");
        String[] parts = replaced.split("-");
        if (parts[3].equals("1")) {
            parts[3] = "17";
        } else if (parts[3].equals("2")) {
            parts[3] = "18";
        }
        String output = String.join("-", parts);
        System.out.println(output);
        /*List<String> mplstps = new ArrayList<>();
        mplstps.add("AD_PSS32_55/PORT-2-7-17/100GbELANETH/10");
        mplstps.add("AD_PSS16II_65/PORT-2-4-1/10GbELANETH/10");*/

        List<String> mplstps = new ArrayList<>();
        mplstps.add("No/de-F/PORT-1-3-1/10GbELANETH/1");
        mplstps.add("Node-D//PORT-1-2-1/10GbELANETH/1");
        mplstps.add("/Node-G/PORT-1-6-1/10GbELANETH/1");


        String mplsWithoutRate="";
        if (mplstps != null) {
            List<String> mplsQueueTps = new ArrayList<String>();
            List<String> mplsTpsToDelete = new ArrayList<String>();

            for (int i = 0; i < mplstps.size(); i++) {
                String mplstpStr = ((String) mplstps.get(i));
                String subStr = "";
                for (int k1 = 0; k1 < 3; k1++) {
                    int lastIndex = mplstpStr.lastIndexOf('/');
                    System.out.println(lastIndex);
                    subStr = mplstpStr.substring(0, lastIndex);
                    mplstpStr = subStr;
                    System.out.println(mplstpStr);
                }
                String neName = subStr;
                String netp[] = ((String)mplstps.get(i)).substring(neName.length()+1).split("/");
                if(netp.length>=2)
                {
                    if(netp[1].contains("OTU"))
                    {
                        mplsTpsToDelete.add((String)mplstps.get(i));
                        mplsWithoutRate = neName+"/"+netp[0];
                        mplstps.add(mplsWithoutRate);

                    }
                }
                System.out.println(netp[0]);
                System.out.println(netp[0].contains("-C"));
                System.out.println(netp[0].contains("-X"));
                System.out.println(netp[0].contains("-M"));
                System.out.println((netp.length==2 && Integer.parseInt(netp[1]) > 0));
                System.out.println((netp.length==3 && Integer.parseInt(netp[2]) > 0));
                if(netp[0].contains("-C") || netp[0].contains("-X") || netp[0].contains("-M") || (netp.length==2 && Integer.parseInt(netp[1]) > 0)
                        ||(netp.length==3 && Integer.parseInt(netp[2]) > 0)) {
                    String mpls=neName+"/"+netp[0]+"-Queue";
                    for(int q=1; q<=8 ; q++) {
                        mplsQueueTps.add(mpls+q);
                    }
                }


            } //close Loop

            for(int j=0;j<mplsTpsToDelete.size();j++)
            {
                mplstps.remove(mplsTpsToDelete.get(j));
            }
            mplstps.addAll(mplsQueueTps);
        }

        System.out.println("Final" +mplstps);
            List<String> s67 = new ArrayList<>();
            s67.clear();
        System.out.println(s67!=null);
    }
    }



