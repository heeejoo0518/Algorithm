import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1546_평균 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		//조작평균 = 원래평균*100/M(최고성적)
		
		//최고성적
		int M = 0;
		//합계
		int sum = 0;
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			if(num>M) {
				M = num;
			}
			sum += num;
		}
		
		System.out.println((double)sum/N*100/M);
	}
}
