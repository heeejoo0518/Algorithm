import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5635_생일 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());

		st = new StringTokenizer(in.readLine());
		String maxName,minName;
		maxName = minName = st.nextToken();
		int[] max = new int[3];
		int[] min = new int[3];
		for(int i=0;i<3;i++){
			max[i] = min[i] = Integer.parseInt(st.nextToken());
		}

		String tmp;boolean m,n;
		int[] now;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			now = new int[3];
			tmp = st.nextToken();
			m = n = false;
			for(int j=0;j<3;j++){
				now[j] = Integer.parseInt(st.nextToken());
			}
			for(int j=2;j>=0;j--){
				if(!m && now[j] != max[j]){
					m = true;
					if(now[j]>max[j]){
						maxName = tmp;
						max = now;
					}
				}
				if(!n && now[j]!=min[j]){
					n = true;
					if(now[j]<min[j]){
						minName = tmp;
						min = now;
					}
				}
			}

		}
		System.out.println(maxName);
		System.out.println(minName);
	}

}
