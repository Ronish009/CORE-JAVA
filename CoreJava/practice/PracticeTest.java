package practice;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Test{
    int rollno;
    String name;

    public Test(int rollno, String name) {
        this.rollno = rollno;
        this.name=name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return rollno == test.rollno && Objects.equals(name, test.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollno, name);
    }

    @Override
    public String toString() {
        return "Test{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                '}';
    }
}

class EqmAlarmObject implements Serializable {
    private static final long serialVersionUID = 1L;
    private String neName;
    private String portName;

    public EqmAlarmObject(String portName, String neName) {
        this.portName = portName;
        this.neName = neName;
    }

    public EqmAlarmObject() {
    }

    public String getNeName() {
        return this.neName;
    }

    public void setNeName(String neName) {
        this.neName = neName;
    }

    public String getPortName() {
        return this.portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String toString() {
        return "EqmAlarmObject [neName=" + this.neName + ", portName=" + this.portName + "]";
    }
}

public class PracticeTest {

    public void Test25(List<String> list){
        System.out.println("R1"+ Arrays.toString(new Object() {}
                .getClass().getEnclosingMethod().getParameterTypes()));

    }
    public static void main(String[] args) {
        System.out.println("Program:1");
        List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
        list.stream().filter(a->a%2==0).forEach(System.out::println);
        Map<Boolean, List<Integer>> map = list.stream().collect(Collectors.partitioningBy(num->num%2==0));
        System.out.println(map);
        System.out.println("==End==");
        System.out.println("Program:2 Find Number starting with 1");
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
        myList.stream().map(s->s+"").filter(s->s.startsWith("1")).forEach(System.out::println);
        System.out.println("=====From Array====");
        int[] arr = {10,15,8,49,25,98,32};
        Arrays.stream(arr).boxed().map(s->s+"").filter(s->s.startsWith("1")).forEach(System.out::println);
        System.out.println("=====Counting========");
        Integer[] arr1 = {10,15,8,49,25,98,32};
        long count = Arrays.stream(arr1).collect(Collector.of(
                ()->new long[]{0}, //supplier
                (acc,num)->{
                    if(String.valueOf(num).startsWith("1")) {
                        acc[0]++;
                    }
                }, //accumulator
                (acc1,acc2)->{
                    acc1[0]+=acc2[0];
                    return acc1;
                }, //combiner
                acc->acc[0] //finisher
        ));
        System.out.println(count);
        System.out.println("Program:3 Find Duplicate element in the List");
        List<Integer> myList1 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Set<Integer> set = new HashSet();
        List<Integer> l = myList1.stream().filter(n->!set.add(n)).toList();
        l.forEach(System.out::println);
        System.out.println("Program:4 Find the First Element in the List");
        Integer a = myList1.stream().findFirst().get();
        myList1.stream().findFirst().ifPresentOrElse(System.out::println, ()-> System.out.println("No element is Present"));
        System.out.println(a);
        System.out.println("Program:5  total number of elements present");
        System.out.println(myList1);
        System.out.println(myList1.stream().count());
        long b = myList1.stream().collect(Collector.of(
                ()->new long[]{0,0},
                (br,num)->{br[0]++;br[1]+=num;},
                (br1,br2)->{
                    br1[1]+=br2[1];
                    return br1;
                },
                br->br[1]
        ));
        System.out.println(b);
        System.out.println("Program 6 : Find Even Number in the List and set into the Array");
        List<Integer> numbers = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        Integer[] result = numbers.stream()
                .filter(n -> n % 2 == 0).collect(
                        Collector.of(
                                ArrayList::new,
                                List::add,
                                (l1,l2)->{l1.addAll(l2);return l1;},
                                l3->l3.toArray(new Integer[0])

                        ));
        System.out.println(Arrays.toString(result));
        System.out.println("Program 7: Convert List to Array");
        List<Integer> numbers1 = Arrays.asList(10, 15, 8, 49);
        System.out.println(numbers1);
        Integer[] ak = numbers1.toArray(new Integer[0]);
        System.out.println(Arrays.toString(ak));
        System.out.println("Program 8: Max Value");
        System.out.println(numbers1);
        numbers1.stream().collect(Collectors.maxBy(Comparator.naturalOrder())).ifPresentOrElse(a9-> System.out.println(a9),()-> System.out.println("No Element is present"));
        numbers1.stream().max(Integer::compareTo).ifPresentOrElse(a10-> System.out.println("Max:"+a10),()-> System.out.println("List is Empty"));
        System.out.println("Program 9: find the first non-repeated character");
        String s = "JAava articles are Awesome";
        s.chars().forEach(System.out::println);
        String s5 = "swiaaWi";
        s5.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(h->h.getValue()==1).findFirst().ifPresentOrElse(h-> System.out.println("Element:"+h),()-> System.out.println("No Element"));
        System.out.println("Program:10 find the first repeated character in it ");
        s5.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c,LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(a1->a1.getValue()!=1).findFirst().ifPresentOrElse(d-> System.out.println("Result: "+d), ()-> System.out.println("No Element is Present"));
        System.out.println("Program:11 sort all the values and Reversed");
        List<Integer> l2 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        System.out.println(l2);
        System.out.println("Ascending Order:");
        l2.stream().sorted(Comparator.naturalOrder()).forEach(a11->System.out.print(a11 + " "));
        System.out.println("\nDescending Order:");
        l2.stream().sorted(Comparator.reverseOrder()).forEach(a11->System.out.print(a11 + " "));
        System.out.println("\nProgram:12 Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct");
        int[] arr2 = new int[]{1,2,3};
        Set<Integer> set1 = new HashSet<>();
        System.out.println(Arrays.stream(arr2).anyMatch(k->!set1.add(k)));
        System.out.println("\nProgram:13 concatenate two Streams");
        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");
        System.out.println(list1);
        System.out.println(list2);
        List<String> list3 = Stream.concat(list1.stream(), list2.stream()).toList();
        System.out.println("Concat List :"+list3);
        System.out.println("Program14:  to sort an array and then convert the sorted array into Stream");
        int[] ar = { 99, 55, 203, 99, 4, 91 };
        Arrays.parallelSort(ar);
        Arrays.stream(ar).forEach(ar1-> System.out.println(ar1+" "));
        System.out.println("\nProgram 15: only duplicate elements with its count from the String ArrayList");
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC","BB");
        Map<String, Long> map1 = names.stream().filter(x->Collections.frequency(names,x)>1).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map1);
        System.out.println("Program 16: find the Maximum element in an array");
        int[] b2 = {2,4,1,3,7,99,37};
        System.out.println(Arrays.stream(b2).max().getAsInt());
        System.out.println("============Sumit==========");
        List<Test> ltest = Arrays.asList(new Test(1,"Sumit"),new Test(1,"Sumit"), new Test(3,"Ronish"));
        System.out.println(ltest);
        Test t = new Test(1,"Sumit");
        Test t1 = new Test(4,"Arghyadip");
        Set<Test> stest = new HashSet<>(ltest);
        System.out.println(stest);
        System.out.println(stest.contains(t));
        System.out.println(stest.contains(t1));
        String fb = "best practice/Lag Tempalte/Lag25";
        System.out.println(fb);
        System.out.println(fb.replace("/","_").replace(" ",""));
        List<Object> list95 = Arrays.asList(new EqmAlarmObject("a","b"));
        System.out.println(list95);
       Iterator<Object> IT = list95.iterator();
       while(IT.hasNext()){
        EqmAlarmObject e = (EqmAlarmObject)IT.next();
       }
        PracticeTest p = new PracticeTest();
        p.Test25(Arrays.asList("Ronish"));
        String s91 = "\"\"[{\\\"neName\\\":\\\"10.43.227.54\\\",\\\"portName\\\":\\\"PACKETSWITCH-1-LAG1\\\"}]\"\"";
        System.out.println(s91);
        if (s91.startsWith("\"") && s91.endsWith("\"")) {
            // Remove outer quotes and unescape inner JSON
            s91 = s91.substring(1, s91.length() - 1)
                    .replace("\\\"", "\"");
        }
        System.out.println(s91); // /+ _
        String r2 ="/Best Practices/LAG Templates";
        System.out.println("Connn"+"-"+r2.replaceFirst("/","").replace("/","+").replace(" ","_"));



    }
}
