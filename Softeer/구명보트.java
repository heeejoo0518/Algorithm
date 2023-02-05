import java.util.*;
 
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int first = 0;
        int last = people.length-1;
        
        int answer = 0;
        while(first <= last){
            if(people[last]+people[first] <= limit){
                first++;
            }
            last--;
            answer++;
        }
        
        return answer;
    }
}