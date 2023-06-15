import java.io.*;
import java.util.*;

public class BOJ_7662_이중우선순위큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for(int tc=0;tc<T;tc++){
			int K = Integer.parseInt(in.readLine());
			int count = 0;
			PriorityQueue<Integer> asc = new PriorityQueue<>();
			PriorityQueue<Integer> desc = new PriorityQueue<>((a,b)->b.compareTo(a));
			Map<Integer, Integer> map = new HashMap<>();
			for(int k=0;k<K;k++){
				st = new StringTokenizer(in.readLine());
				String command = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				switch (command){
					case "I":
						asc.offer(num);
						desc.offer(num);
						map.put(num,map.getOrDefault(num,0)+1);
						count++;
						break;
					case "D":
						if(count==0) break;

						int del;
						while(true){
							if(num>0) del = desc.poll();
							else del = asc.poll();
							if(map.get(del)>0) {
								map.put(del,map.get(del)-1);
								break;
							}
						}

						if(--count==0){
							desc.clear();
							asc.clear();
						}
						break;
				}
			}

			if(count<=0) {
				sb.append("EMPTY\n");
				continue;
			}

			int min = asc.poll(), max = desc.poll();
			while(map.get(min)==0) min = asc.poll();
			while(map.get(max)==0) max = desc.poll();
			sb.append(max).append(" ").append(min).append('\n');
		}

		System.out.print(sb);
	}
}
