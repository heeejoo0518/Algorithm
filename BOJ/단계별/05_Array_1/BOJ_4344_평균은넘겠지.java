import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4344_평균은넘겠지 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();

		int C = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < C; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			int[] scores = new int[N];
			for(int i=0;i<N;i++) {
				scores[i] = Integer.parseInt(st.nextToken());
				sum += scores[i];
			}
			
			double avg = (double)sum/N;
			
			int cnt = 0;
			for(int score:scores) {
				if(avg<score) cnt++;
			}
			
			double rate = (double)cnt/N*100;
			
			builder.append(String.format("%.3f%%\n", rate));
		}

		System.out.println(builder.toString());
	}
}
