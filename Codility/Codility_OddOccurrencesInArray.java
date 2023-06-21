import java.util.*;
class Codility_OddOccurrencesInArray {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for(int item:A){
            if(set.contains(item)) set.remove(item);
            else set.add(item);
        }
 
        return set.iterator().next();
    }
}