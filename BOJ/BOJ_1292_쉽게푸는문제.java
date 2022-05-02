import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[] arr = new int[1001];
		int num = 1;
		for(int i=1;i<=1000;){
			for(int j=0;j<num;j++){
				if(i>1000) break;
				arr[i] = arr[i-1]+num;
				i++;
			}
			num++;
		}

		System.out.println(arr[B]-arr[A-1]);
	}
}
