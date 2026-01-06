package datastructure.dsa;

public class longestStringwithNoRepetition {
    void main() {
        String s = "abacbde";
        int res=0;
        for (int i = 0; i < s.length();i++){

            boolean[] arr=new boolean[26];

            for(int j=i;j<s.length();j++){

                if(arr[s.charAt(j)-'a']==true)
                    break;
                else{
                    arr[s.charAt(j)-'a']=true;
                    res=Math.max(res,j-i+1);
                }

            }

        }
        System.out.println("First Native Approach");
        System.out.println(res);
    }
}