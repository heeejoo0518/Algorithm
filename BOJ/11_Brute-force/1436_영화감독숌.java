import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436_영화감독숌 {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        in.close();

        //탐색
        int count = 1;
        int number = 666;
        while(count != N){
            if(checkNum(++number)==3) count++;
            //if(String.valueOf(++number).contains("666")) count++;
        }

        //출력
        System.out.println(number);
    }


    //6이 연속으로 3번 들어와있는지 체크하는 함수
    public static int checkNum(int n){
        int cnt = 0;

        while(n!=0){
            if(cnt==3) break;

            if(n%10==6) cnt++;
            else cnt=0;

            n/=10;
        }

        return cnt;
    }
}
