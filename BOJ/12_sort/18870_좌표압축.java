import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		br.close();
		
		Integer[] nums = new Integer[n];
		for(int i=0;st.hasMoreTokens();i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> num_list = Arrays.stream(nums).distinct().sorted().collect(Collectors.toList());
		
		StringBuilder sb = new StringBuilder();		
		for(int i=0;i<n;i++) {
			sb.append(Collections.binarySearch(num_list, nums[i])+" ");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}
}
