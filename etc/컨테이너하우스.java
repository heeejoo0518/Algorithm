import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//최대한 높은 건물
		//위로 갈수록 점점 크기가 작아져야 함.
		//크기 = 정수의 절대값
		//페인트칠은 색상을 층마다 교차로 칠함(음수=흰색, 양수=검은색)
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> buildings = new ArrayList<>();
		for(int i=1;i<=N;i++){
			buildings.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(buildings,(o1,o2)->Math.abs(o1)-Math.abs(o2));
		
		int[] count = new int[N];
		count[0] = 1;//첫번째 컨테이너 쌓았을 때
	
		int MAX = 1;
		for(int i=1;i<N;i++){
			for(int j=i-1;j>=0;j--){
				if((buildings.get(j) < 0 && buildings.get(i) > 0) || (buildings.get(j) > 0 && buildings.get(i) < 0)){
					//서로 다를 때
					count[i] = count[j]+1;
					break;
				}else{
					//같으면 그대로 저장
					count[i] = Math.max(count[i],count[j]);
				}
			}
			MAX = Math.max(MAX, count[i]);
		}
		
		System.out.println(MAX);
		
	}
}