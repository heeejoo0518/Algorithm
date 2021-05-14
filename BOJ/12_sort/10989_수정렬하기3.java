import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());		
		
		int[] nums = new int[n];
		int[] sort = new int[10000000];
		int max = 0;
		
		for(int i=0;i<n;i++) {
			nums[i] = Integer.parseInt(br.readLine());
			sort[nums[i]]++;
			if(nums[i]>max) max=nums[i];
		}
		
		br.close();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=max;i++) {
			for(int j=0;j<sort[i];j++) {
				sb.append(i+"\n");
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}
	
}
