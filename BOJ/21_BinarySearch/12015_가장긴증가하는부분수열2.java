import java.io.*;
import java.util.*;

public class Main{
	static List<Integer> subsequence;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());

		subsequence = new ArrayList<>();
		subsequence.add(0);
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			int value = Integer.parseInt(st.nextToken());
			if(subsequence.get(subsequence.size()-1) < value) {
				subsequence.add(value);
				continue;
			}
			
			//search
//			int left = 1;
//			int right = subsequence.size()-1;
//			while(left<right) {
//				int mid = (left+right)/2;
//				if(subsequence.get(mid)<value) {
//					left = mid+1;
//				}else {
//					right = mid;
//				}
//			}
//			int idx = right;
			
			int idx = Collections.binarySearch(subsequence, value);
			idx = idx>0? idx:-idx-1;
			subsequence.set(idx, value);
			
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(subsequence.size()-1));
		
		bw.flush();
		bw.close();
	}
}