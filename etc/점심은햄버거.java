import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//데우는 시간은 무조건 포함됨.
		//따라서 먹는 시간이 긴 -> 짧은 사람 순, 같다면 데우는 시간이 짧은 사람 먼저.
		//총 시간 Total
		//만약 현재 데우는 시간 + 먹는시간보다 Total이 크면 그 차이를 더함. 
		int N = Integer.parseInt(br.readLine());
		StringTokenizer eat = new StringTokenizer(br.readLine());
		StringTokenizer cook = new StringTokenizer(br.readLine());
		PriorityQueue<Burger> pq = new PriorityQueue<>((o1,o2)->{
																												if(o1.eat == o2. eat) return o1.cook-o2.cook;
																												else return o2.eat - o1.eat;});
		
		for(int i=0;i<N;i++){
			pq.offer(new Burger(Integer.parseInt(cook.nextToken()),Integer.parseInt(eat.nextToken())));
		}
		
		int cookTime = 0;//전자렌지 돌리는 시간
		int total = 0;//먹는시간까지 포함한 시간
		Burger now;
		while(!pq.isEmpty()){
			now = pq.poll();
			cookTime += now.cook;
			if(cookTime + now.eat > total){
				total += (cookTime + now.eat - total);
			}
		}
		
		System.out.println(total);
	}
	static class Burger {
		int cook, eat;
		public Burger(int cook, int eat){
			this.cook = cook;
			this.eat = eat;
		}
	}
}