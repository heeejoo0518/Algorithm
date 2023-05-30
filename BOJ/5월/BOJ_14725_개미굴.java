import java.io.*;
import java.util.*;

public class BOJ_14725_개미굴 {
	static class Trie {
		Map<String,Trie> child;
		String info;
		Trie(String info){
			child = new HashMap<>();
			this.info = info;
		}
	}

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;

		Trie head = new Trie("-");

		int M;
		String info;
		Trie node;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken());
			node = head;
			for(int j=0;j<M;j++){
				info = st.nextToken();
				if(!node.child.containsKey(info)){
					node.child.put(info, new Trie(info));
				}
				node = node.child.get(info);
			}
		}

		print(head,-2);
		System.out.print(sb);
	}

	private static void print(Trie node, int hyphen){
		//1. 현재 노드 이름 출력
		if(hyphen>=0){
			for(int i=0;i<hyphen;i++) sb.append('-');
			sb.append(node.info).append('\n');
		}

		//2. 자식 노드 정렬
		//3. 자식 노드로 재귀호출
		List<String> list = new ArrayList<>(node.child.keySet());
		Collections.sort(list);
		for(String ch:list){
			print(node.child.get(ch),hyphen+2);
		}
	}
}
