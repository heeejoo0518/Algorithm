import java.io.*;
import java.util.*;

public class BOJ_1337_올바른배열2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<N;i++) list.add(Integer.parseInt(in.readLine()));
		Collections.sort(list);

		int answer = 4;
		int tmp;
		for(int item:list){
			tmp = 0;
			for(int j=item+1;j<item+5;j++){
				if(Collections.binarySearch(list,j) < 0) tmp++;
			}
			answer = Math.min(answer, tmp);
		}

		System.out.println(answer);
	}
}
