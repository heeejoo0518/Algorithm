import java.io.*;
import java.util.*;

public class BOJ_2143_두배열의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		int N = Integer.parseInt(in.readLine());
		ArrayList<Integer> A = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) A.add(Integer.parseInt(st.nextToken()));
		int M = Integer.parseInt(in.readLine());
		ArrayList<Integer> B = new ArrayList<>();
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<M;i++) B.add(Integer.parseInt(st.nextToken()));

		//가능한 부분합 집합
		add(A,N);
		add(B,M);

		Collections.sort(B);

		long answer = 0;
		int l, u;
		for(int a:A){
			l = lower_bound(B,T-a);
			u = upper_bound(B,T-a);
			answer += u-l;
		}

		System.out.println(answer);
	}
	public static void add(List<Integer> list, int size){
		int sum;
		for(int i=0;i<size;i++){
			sum = list.get(i);
			for(int j=i+1;j<size;j++){
				sum += list.get(j);
				list.add(sum);
			}
		}
	}

	public static int lower_bound(List<Integer> list, int x){
		int l = 0, r = list.size(), m;
		while(l<r){
			m = (l+r)/2;
			if(list.get(m)>=x) r = m;
			else l = m+1;
		}
		return l;
	}

	public static int upper_bound(List<Integer> list, int x){
		int l = 0, r = list.size(), m;
		while(l<r){
			m = (l+r)/2;
			if(list.get(m)>x) r = m;
			else l = m+1;
		}
		return r;
	}
}
