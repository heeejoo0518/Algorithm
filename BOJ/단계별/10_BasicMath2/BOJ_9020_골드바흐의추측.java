import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9020_골드바흐의추측 {
	public static void main(String[] args) throws IOException {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		boolean[] prime = new boolean[10001];//true 소수아님 false 소수

		prime[0] = prime[1] = true;
		for(int num=2;num<=10000;num++){
			if(prime[num]) continue;
			for(int i=num<<1;i<=10000;i+=num){
				prime[i] = true;
			}
		}

		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		outer:while(--T>=0){
			int N = Integer.parseInt(in.readLine());
			int mid = N/2;

			for(int i=0;i<mid;i++){
				if(!prime[mid-i] && !prime[mid+i]) {
					sb.append(mid-i).append(" ").append(mid+i).append("\n");
					continue outer;
				}
			}
		}
		System.out.print(sb);
	}
}
