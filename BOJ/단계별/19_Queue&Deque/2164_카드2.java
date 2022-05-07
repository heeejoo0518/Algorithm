import java.io.*;
import java.util.*;

public class Main{
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		br.close();
		
		for(int i=1;i<=n;i++) {
			queue.offer(i);
		}
		
		int num=0;
		for(int i=0;!queue.isEmpty();i++) {
			num = queue.poll();
			if(i%2==0) continue;
			else queue.offer(num);
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(num));
		
		bw.flush();
		bw.close();
	}
}