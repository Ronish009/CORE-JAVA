void main(){
    String s="2sffd44ffjkf7k444kdfd9ff";
    Pattern p = Pattern.compile("\\d+");
    Matcher m = p.matcher(s);
    System.out.println(m.matches());
    int sum=0;
    int i=0;
    while(m.find()){
        sum+=Integer.parseInt(m.group());
        System.out.println(m.group());
        System.out.println("Ronish");
        System.out.println(m.group(0));
    }
    System.out.println("Total");
    System.out.println(sum);
    s="Aronish";
    s.chars().forEach(System.out::println);
    List<Integer> list = Arrays.asList(1,2,3,4,5);
    int window=3;
    IntStream.range(0,list.size()-(window-1))
                    .mapToObj(i1->list.subList(i1,i1+window))
                            .map(k->k.stream().mapToInt(Integer::intValue).average().orElse(0.0))
            .forEach(System.out::println);

    String str= "Java is platform independent. Java is good language.";
    System.out.println(str);
    String[] arr= str.toLowerCase().replaceAll("[^a-z\\s]","")
            .split(" ");
    List<String> list1= IntStream.range(0,arr.length-1)
            .mapToObj(i2->arr[i2] + " "+arr[i2+1])
            .toList();
    list1.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).forEach((x,y)->System.out.println(x+ " -> "+y));
    System.out.println(list1);

}