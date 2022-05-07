import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
		int[] nums = new int[10];
		for(int i=0;i<input.length();i++){
			nums[input.charAt(i)-'0']++;
		}

		int tmp = nums[6]+nums[9];
		nums[6] = tmp/2;
		nums[9] = tmp-nums[6];

		int max = nums[9];
		for(int i=0;i<9;i++){
			if(max<nums[i]) max = nums[i];
		}

		System.out.println(max);

	}
}
