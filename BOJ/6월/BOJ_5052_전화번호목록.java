import java.io.*;
import java.util.*;

public class BOJ_5052_전화번호목록 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();

		int N;
		String[] tell;
		for(int tc=0;tc<T;tc++){
			N = Integer.parseInt(in.readLine());
			tell = new String[N];
			for(int i=0;i<N;i++) tell[i] = in.readLine();
			Arrays.sort(tell, (a,b)->a.length()-b.length());

			if(check(tell)) sb.append("YES\n");
			else sb.append("NO\n");

		}

		System.out.print(sb);
	}

	public static boolean check(String[] tell){
		Set<String> set = new HashSet<>();
		for (String s : tell) {
			for (int len = s.length(); len > 0; len--) {
				if (set.contains(s.substring(0, len))) return false;
			}
			set.add(s);
		}
		return true;
	}
}
