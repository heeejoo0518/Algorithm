import java.io.*;

public class BOJ_12904_A와B {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder S = new StringBuilder().append(in.readLine());
		StringBuilder T = new StringBuilder().append(in.readLine());

		char now;
		while(S.length() != T.length()){
			now = T.charAt(T.length()-1);
			T.setLength(T.length()-1);
			if(now=='B') T.reverse();
		}

		if(S.toString().equals(T.toString())) System.out.println(1);
		else System.out.println(0);
	}

}
