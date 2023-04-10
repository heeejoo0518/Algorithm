import java.io.*;

public class BOJ_12919_A와B2 {
	static char[] S,T;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		S = in.readLine().toCharArray();
		T = in.readLine().toCharArray();

		if(check(0,T.length-1,true)) System.out.println(1);
		else System.out.println(0);
	}

	public static boolean check(int a, int b, boolean way){
		boolean ans = false;
		if(b-a == S.length-1){
			for(int i=0;i<=b-a;i++){
				if(way && S[i] != T[a+i]) return false;
				else if(!way && S[i] != T[b-i]) return false;
			}
			return true;
		}

		if(way){
			if(T[b]=='A') ans = check(a,b-1,way);
			if(!ans && T[a]=='B') ans = check(a+1,b,!way);
		}else{
			if(T[a]=='A') ans = check(a+1,b,way);
			if(!ans && T[b]=='B') ans = check(a,b-1, !way);
		}

		return ans;
	}
}
