import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2304_창고다각형2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;

		int[][] col = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			col[i][0] = Integer.parseInt(st.nextToken());//위치
			col[i][1] = Integer.parseInt(st.nextToken());//높이
		}

		Arrays.sort(col, (o1, o2) -> o1[0] - o2[0]);

		int area = 0;
		for(int i=0;i<N;){
			int j=i+1; int max = j;
			while(j<N && col[i][1]>col[j][1]){
				if(col[max][1]<col[j++][1]) max = j-1;
			}

			if(j>=N){
				//나보다 큰 게 없는경우
				//나 다음으로 제일 큰 기둥(max)을 이용함
				//내 기둥 높이+다음기둥과 나+1 사이의 갭*다음기둥높이
				//새로운 i값은 다음기둥 인덱스로 설정
				area+=col[i][1];
				if(max<N) area+=col[max][1]*(col[max][0]-col[i][0]-1);
				i=max;
			}else{
				area+= col[i][1]*(col[j][0]-col[i][0]);
				i=j;
			}

		}
		System.out.println(area);
	}
}
