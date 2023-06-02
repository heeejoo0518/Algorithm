import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BOJ_5052_전화번호목록2 {
	static class Trie {
		Trie[] next = new Trie[10];
		boolean isEnd;
		Trie(boolean isEnd){
			this.isEnd = isEnd;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();

		int N;
		String[] tell;
		for(int tc=0;tc<T;tc++){
			N = Integer.parseInt(in.readLine());
			tell = new String[N];
			for(int i=0;i<N;i++) tell[i] = in.readLine();
			Arrays.sort(tell, (a,b)->a.length()-b.length());

			if(check(tell)) sb.append("YES\n");
			else sb.append("NO\n");

		}

		System.out.print(sb);
	}

	public static boolean check(String[] tell){
		Trie head = new Trie(false);
		Trie node;
		int num;
		for (String s : tell) {
			node = head;
			for (int j = 0; j < s.length(); j++) {
				num = s.charAt(j) - '0';
				if (node.next[num] == null) node.next[num] = new Trie(j==s.length()-1);
				else if (node.next[num].isEnd) return false;
				node = node.next[num];
			}
		}
		return true;
	}
}
