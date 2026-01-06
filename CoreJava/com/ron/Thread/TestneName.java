import com.google.common.base.Splitter;

public static List<Map<String, Object>> conversionKeyfromLowertoUpper(List<Map<String, Object>> result){
    List<Map<String, Object>> upperCaseList = new ArrayList<>();
    for (Map<String, Object> row : result) {
        Map<String, Object> newRow = new HashMap<>();
        for (Map.Entry<String, Object> e : row.entrySet()) {
            newRow.put(e.getKey().toUpperCase(), e.getValue());
        }
        upperCaseList.add(newRow);
    }
    return upperCaseList;
}

void main(){
    List<Map<String, Object>> temp = new ArrayList<>();
    HashMap<String, Object> hm = new HashMap<>();
    hm.put("ronish",1);
    temp.add(hm);
    System.out.println("Before = "+temp);
    System.out.println("After = "+conversionKeyfromLowertoUpper(temp));
    /*String linkIdCsv = "{521}";
    List<String> linkIdStrLst=Arrays.asList(linkIdCsv.split(","));
    List<Integer> linkIdList=linkIdStrLst.stream().filter(a -> !a.isEmpty()).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    System.out.println(linkIdList);*/
    Object op =21;
    Integer n = ((Number)op).intValue();
    System.out.println(n);
    List<String> li = new ArrayList<>();
    li.add("3");
    li.add("4");
    System.out.println(li);
    int x=5;
    int y=x;
    x=9;
    System.out.println(y);


    /*Splliter Function*/
    String value ="ronish=25,madhu=1";
    Map<String,String> map =new HashMap<>();
    map= Splitter.on(",").withKeyValueSeparator("=").split(value.trim());
    map.forEach((k,v)-> System.out.println(k +":"+v));

    String value1 ="";
    Map<String,String> map1 =new HashMap<>();
    map1= Splitter.on(",").withKeyValueSeparator("=").split(value1.trim());
    map1.forEach((k,v)-> System.out.println(k +":"+v));

    List l =new ArrayList();
    l.add(0,1);

String  s= """
            Hello Buudy
            adada
            adadada
            dadadad
            adad
            """;
    System.out.println();
}