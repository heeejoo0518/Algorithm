import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941_크로아티아알파벳 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();//두번째 방법 사용 위해 나눠놓음
		char[] chars = str.toCharArray();
		in.close();

		int count = 0;
		for (int i = chars.length - 1; i >= 0; i--) {
			count++;
			if(chars[i]=='=') {
				i--;
				if(i-1>=0 && chars[i]=='z' && chars[i-1]=='d') i--;
			}else if(chars[i]=='-') {
				i--;
			}else if(chars[i]=='j') {
				if(i-1>=0 && (chars[i-1]=='n' || chars[i-1]=='l')) i--;
			}
		}
		
		System.out.println(count);
		
		//검색해서 알게된 두 번째 방법
//		String[] croatian = {"c=","c-","dz=","d-","lj","nj","s=","z="};
//		for(String word:croatian) {
//			if(str.contains(word)) str = str.replace(word, "*"); //단어 길이만 찾을거니까 한글자로 대체
//		}
//		System.out.println(str.length());
		

	}
}
