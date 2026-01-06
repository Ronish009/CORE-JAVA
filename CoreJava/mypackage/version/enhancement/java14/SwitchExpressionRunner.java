package mypackage.version.enhancement.java14;

public class SwitchExpressionRunner {
    public static String FindDayofWweek(int day){
        String dayOfWeek="";
        switch (day){
            case 0: dayOfWeek="Sunday";break;
            case 1: dayOfWeek="Monday";break;
            case 2: dayOfWeek="Tueday";break;
            case 3: dayOfWeek="Wednesday";break;
            case 4: dayOfWeek="Thrusday";break;
            case 5: dayOfWeek="Friday";break;
            case 6: dayOfWeek="Satarday";break;
            default: throw new IllegalArgumentException("Invalid Option"+day);
        }
        return dayOfWeek;
    }
    public static String FindDayofWweekwithSwitchExpression(int day){
        String dayOfWeek=switch (day){
            case 0 ->{
                System.out.println("Do Something");
                yield "Sunday";
            }
            case 1 ->"Monday";
            case 2 ->"Tueday";
            case 3 ->"Wednesday";
            case 4 ->"Thrusday";
            case 5 ->"Friday";
            case 6 ->"Satarday";
            default ->  throw new IllegalArgumentException("Invalid Option"+day);
        };
        return dayOfWeek;
    }
    public static void main(String[] args) {
        System.out.println(FindDayofWweek(4));
        System.out.println(FindDayofWweekwithSwitchExpression(0));
    }
}
