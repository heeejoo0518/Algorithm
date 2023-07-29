import java.io.*;
import java.util.*;

public class BOJ_25192_인사성밝은곰곰이 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Map<String, Integer> user = new HashMap<>();

		int answer = 0;
		String name;
		int count = 0;
		for(int i=0;i<N;i++){
			name = in.readLine();
			if(name.equals("ENTER")) {
				count++;
				continue;
			}
			if(!user.containsKey(name)) user.put(name,0);
			if(user.get(name) != count){
				answer++;
				user.put(name, count);
			}
		}

		System.out.println(answer);
	}
}
