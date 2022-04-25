import java.io.*;
import java.util.*;

public class _0425_Algo1 {

	public static void main(String[] args) throws Exception {
		//숫자를 입력받는다. StringTokenizer를 사용해 공백으로 숫자를 구분한다.
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		//숫자를 영어로 바꾸기 위한 배열을 만든다. 
		//각 자리수를 영어로 표시한 배열과 저장할 배열이 필요하다.
		String[] word = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		String[] num = new String[100];
	
		//사전 순 가장 끝에 있을 문자열로 초기화시킨다.
		Arrays.fill(num, "zzzzz");
		
		//영어로 읽을 때의 숫자를 저장한다.
		//M부터 시작해야하기 때문에 처음 i와 j는 각각 M/10, M%10이다.
		//숫자가 N과 같으면 끝낸다.
		int j = M % 10;
		for(int i=M/10;i<=N/10;i++) {
			for(;j<10;j++) {
				if(i!=0) num[i*10+j] = word[i]+" "+word[j];
				else num[j] = word[j];
				if(i==N/10 && j==N%10) break;
			}
			j=0;
		}
		
		//저장된 문자열을 정렬한다.
		Arrays.sort(num);
		
		//cnt를 하나씩 더하면서 10의 배수일 때 sb에 \n을 더한다.
		//현재 영어숫자를 StringTokenizer로 자르고 그 개수가 0이 될 때까지 
		//각 영어에 맞는 숫자로 변환해서 sb에 더한다. 
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for(int i=0;i<=N-M;i++) {
			st = new StringTokenizer(num[i]);
			while(st.countTokens()!=0) {
				switch(st.nextToken()) {
				case "zero":sb.append(0);break;
				case "one":sb.append(1);break;
				case "two":sb.append(2);break;
				case "three":sb.append(3);break;
				case "four":sb.append(4);break;
				case "five":sb.append(5);break;
				case "six":sb.append(6);break;
				case "seven":sb.append(7);break;
				case "eight":sb.append(8);break;
				case "nine":sb.append(9);break;
				}
			}
			sb.append(' ');
			cnt++;
			if(cnt%10==0) sb.append('\n');
		}
		
		//출력한다.
		System.out.print(sb);
	}

}
