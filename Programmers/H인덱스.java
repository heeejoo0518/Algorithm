import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[] citations) {
        Integer[] cit = Arrays.stream(citations).boxed().toArray(Integer[]::new);
		Arrays.sort(cit,Comparator.reverseOrder());

        int size = cit.length;
		int h=0;
		while(h<size) {
			if(h >= cit[h]) break;
	        h++;
		}
		
		return h;
    }
}