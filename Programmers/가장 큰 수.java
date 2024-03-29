import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];

        for(int i=0;i<numbers.length;i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o2+o1) - Integer.parseInt(o1+o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        boolean zero = true;

        for(String s:str) {
            sb.append(s);
            if(!s.equals("0")) zero = false;
        }

        if(zero) return "0";
        else return sb.toString(); 
    }
}
