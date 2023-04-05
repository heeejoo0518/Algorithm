import java.io.*;

public class BOJ_20365_블로그2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int blue = 0, red = 0;
		char prev = '.';
		for(char c:in.readLine().toCharArray()){
			if(c == prev) continue;
			if(c == 'B') blue++;
			else red++;
			prev = c;
		}
		System.out.println(Math.min(blue,red)+1);
	}
}
