import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main{	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());	
		
		int[] nums = new int[n];
		
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			nums[i] = num;
		}
		
		br.close();
		
		String avg = String.format("%.0f",Arrays.stream(nums).average().getAsDouble());
		int max = Arrays.stream(nums).max().getAsInt();
		int min = Arrays.stream(nums).min().getAsInt();
		
		Arrays.sort(nums);
		int mid = nums[n/2];
		
		int mode=nums[0];
		int modeCnt = 0;
		int tmpCnt = 1;
		boolean isSecond = false;
		
		for(int i=1;i<=n;i++) {
			if(i!=n && nums[i]==nums[i-1]) {
				tmpCnt++;
				continue;
			}
			
			if(modeCnt<tmpCnt) {
				modeCnt = tmpCnt;
				mode=nums[i-1];
				isSecond = true;
			}else if(modeCnt==tmpCnt && isSecond) {
				mode=nums[i-1];
				isSecond=false;
			}
			
			tmpCnt=1;
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(avg+"\n");
		sb.append(mid+"\n");
		sb.append(mode+"\n");
		sb.append(max-min+"\n");
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}
	
}
