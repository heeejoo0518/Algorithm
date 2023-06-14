import java.io.*;
import java.util.*;

public class BOJ_1107_리모컨2 {
	static boolean[] remote;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());

		remote = new boolean[10];
		if(M !=0){
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i=0;i<M;i++) remote[Integer.parseInt(st.nextToken())] = true;
		}

		int answer = Math.abs(100-N);

		for(int channel=0;channel<=1_000_000;channel++){
			int cnt = count(channel);
			if(cnt==0) continue;
			answer = Math.min(answer, cnt + Math.abs(channel-N));
		}

		System.out.println(answer);
	}

	public static int count(int channel){
		if(channel==0) return remote[0]?0:1;
		int cnt = 0;
		while(channel>0){
			if(remote[channel%10]) return 0;
			cnt++;
			channel/=10;
		}
		return cnt;
	}
}
