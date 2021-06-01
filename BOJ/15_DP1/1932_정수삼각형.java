import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[] triangle;	//삼각형 숫자
	static int[] way;		//경로
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		
		int size = n*(n+1)/2;
		triangle = new int[size+1];
		way = new int[size+1];
		
		int idx = 1;
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			while(st.hasMoreTokens()) {
				triangle[idx++] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();

		way[1] = triangle[1];
		getWay(n);
		System.out.println(max(n));
		
	}
	
	public static int max(int n) {
		int idx = (n-1)*n/2+1;
		int m = way[idx];
		
		for(int i = idx+1;i<idx+n;i++) {
			if(m<way[i]) m = way[i];
		}
		
		return m;
	}
	
	public static void getWay(int n) {
		if(n<1) return;
		
		int idx = (n-1)*n/2+1;
		int beforeIdx = n-2 > 0? (n-2)*(n-1)/2+1:0;
		if(way[idx]!=0) return;
		
		getWay(n-1);

		for(int i=idx;i<idx+n;i++) {
			if(way[i]!=0) continue;
			int left = i-n;
			int right = i-(n-1);
			// left, right 범위 벗어나면 0으로 저장
			if(left < 0 || left < beforeIdx || left >= idx) left = 0;
			if(right >= way.length || right < beforeIdx || right >= idx) right = 0;
			
			way[i] = Math.max(way[left], way[right])+triangle[i];
		}
		
		return;
	}
}