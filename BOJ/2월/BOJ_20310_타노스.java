import java.io.*;

public class BOJ_20310_타노스 {
	public static void main(String[] args) throws IOException {
		//입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] S = in.readLine().toCharArray();

		//0,1개수 세기
		int zero = 0;
		int one = 0;
		for(int i=0;i<S.length;i++){
			if(S[i]=='0') zero++;
			else one++;
		}
		zero/=2;
		one/=2;

		//1은 앞에서부터 빼기
		int idx = 0;
		while(one>0){
			if(S[idx]=='1') {
				S[idx]='*';
				one--;
			}
			idx++;
		}

		//0은 뒤에서부터 빼기
		idx = S.length-1;
		while(zero>0){
			if(S[idx]=='0') {
				S[idx]='*';
				zero--;
			}
			idx--;
		}

		//출력
		StringBuilder sb = new StringBuilder();
		for(char s:S){
			if(s!='*') sb.append(s);
		}
		System.out.println(sb);
	}
}
