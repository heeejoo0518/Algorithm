import java.io.*;

public class BOJ_9252_LCS2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] str1 = in.readLine().toCharArray();
		char[] str2 = in.readLine().toCharArray();

		int[][] lcs = new int[str1.length+1][str2.length+1];
		for(int i=1;i<=str1.length;i++){
			for(int j=1;j<=str2.length;j++){
				if(str1[i-1]==str2[j-1]) lcs[i][j] = lcs[i-1][j-1]+1;
				else lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
			}
		}

		int y = str1.length, x = str2.length;
		StringBuilder sb = new StringBuilder();
		while(y > 0 && x > 0){
			if(lcs[y][x] == lcs[y-1][x]) y = y-1;
			else if(lcs[y][x] == lcs[y][x-1]) x = x-1;
			else {
				sb.append(str1[y-1]);
				y = y-1;
				x = x-1;
			}
		}

		System.out.println(lcs[str1.length][str2.length]);
		System.out.print(sb.reverse());
	}
}
