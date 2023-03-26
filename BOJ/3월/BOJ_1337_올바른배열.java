import java.io.*;
import java.util.*;

public class BOJ_1337_올바른배열 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(in.readLine());
		Arrays.sort(arr);

		int prev, cnt;
		int min = 4;
		for(int start = 0;start<N;start++){
			prev = arr[start];
			cnt = 0;//추가해야하는 개수
			//반복 : 추가한 개수(cnt)+i까지 합해서 start+5넘으면 안됨
			for(int i = start+1; i+cnt<start+5;i++){
				if(i == N){
					//끝 요소까지 왔으니 그 나머지 싹 더하고 끝
					cnt+= 5-(N-start);
					break;
				}
				else if(prev+1 != arr[i]){
					//다르다면 그 차이만큼 더하기
					cnt += arr[i]-prev-1;
				}
				//교체
				prev = arr[i];
			}
			min = Math.min(min,cnt);
		}

		System.out.println(min);
	}
}
