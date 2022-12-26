import java.io.*;
import java.util.*;
class Main {
	static Map<Integer, Integer> map = new HashMap<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int MAX = 0;
		for(int i=A;i<=B;i++){
			MAX = Math.max(MAX,dfs(i));
		}
		
		System.out.println(MAX);
	}
	
	private static int dfs(int a){
		if(map.containsKey(a)) return map.get(a);
		if(a<1) return 0;
		if(a==1) return 1;
		
		int result = 1;
		if(a%2==0) result += dfs(a/2);
		else result += dfs(a*3+1);
		map.put(a,result);
		return result;
	}
}