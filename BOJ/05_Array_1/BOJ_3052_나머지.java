import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_3052_나머지 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<10;i++) {
			int num = Integer.parseInt(in.readLine())%42;
			set.add(num);
		}
		System.out.println(set.size());
	}

}
