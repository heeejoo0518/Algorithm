import java.io.*;
import java.util.*;

public class BOJ_13900_순서쌍의곱의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Map<Integer,Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(in.readLine());

		int num;
		for(int i=0;i<N;i++) {
			num = Integer.parseInt(st.nextToken());
			map.put(num,map.getOrDefault(num,0)+1);
		}

		List<Integer> keyList = new ArrayList<>(map.keySet());
		long sum = 0,val;
		int key;
		for(int i=0;i<keyList.size();i++){
			key = keyList.get(i);
			val = map.get(key);
			if(val>1) sum += (val*(val-1)/2)*key*key;
			for(int j=i+1;j<keyList.size();j++){
				sum += val*map.get(keyList.get(j))*key*keyList.get(j);
			}
		}

		System.out.println(sum);
	}
}
