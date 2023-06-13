import java.io.*;
import java.util.*;

public class BOJ_20529_가장가까운세사람의심리적거리 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++){
			int N = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());
			if(N>=33){
				//16가지+16가지+1개 = 무조건 같은 타입 세 개 있음.
				sb.append("0\n");
				continue;
			}

			char[][] arr = new char[N][];
			for(int i=0;i<N;i++) arr[i] = st.nextToken().toCharArray();
			sb.append(find(arr)).append('\n');
		}
		System.out.print(sb);
	}

	public static int find(char[][] arr){
		int N = arr.length;
		int min = 12;
		for(int i=0;i<N-2;i++){
			for(int j=i+1;j<N-1;j++){
				for(int k=j+1;k<N;k++){
					int diff = check(arr[i],arr[j]);
					diff += check(arr[i],arr[k]);
					diff += check(arr[j],arr[k]);
					if(min>diff) min = diff;
					if(min==0) return 0;
				}
			}
		}

		return min;
	}

	public static int check(char[] A, char[] B){
		int count = 0;
		for(int i=0;i<4;i++){
			if(A[i] != B[i]) count++;
		}

		return count;
	}
}
