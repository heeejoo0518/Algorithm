import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		br.close();
		
		StringBuilder sb = new StringBuilder();

		sb.append((a+b)%c+"\n");
		sb.append(((a%c)+(b%c))%c+"\n");
		sb.append((a*b)%c+"\n");
		sb.append(((a%c)*(b%c))%c+"\n");
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}
}
