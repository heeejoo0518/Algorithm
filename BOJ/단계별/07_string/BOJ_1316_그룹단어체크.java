import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_1316_그룹단어체커 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		int count = 0;
		while(N-->0){
			char[] word = in.readLine().toCharArray();
			//이전 알파벳과 다르고 && 저장된 알파벳 set에 내가 있으면 이번 단어는 x -> 멈춤
			//set.add() --> true if this set did not already contain the specified element
			boolean isGroup = true;
			Set<Character> save = new HashSet<>();
			save.add(word[0]);

			for(int i=1;i<word.length;i++){
				if(word[i-1] != word[i] && !save.add(word[i])) {
					isGroup = false;
					break;
				}
			}

			if(isGroup) count++;
		}

		System.out.println(count);
	}
}
