import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436_영화감독숌2 {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        in.close();

        //깔끔한 코드작성 위해 N==1일때는 따로 추가
        if(N==1) {
            System.out.println(666);
            return;
        }

        //탐색
        //현재숫자=처음숫자
        //끝숫자 정하기
        //  현재숫자가 "666"으로 끝나면 + 000~999 = 666000~666999
        //      N-카운트>1000이면 바로 카운트+=1000하고 다음으로 넘어감
        //                 아니면 끝숫자="666"+(N-카운트-1)
        //  현재숫자가 "66"으로 끝나면 + "6" + 00~99 = 66600~66699
        //      N-카운트>100이면 카운트+=100하고 다음으로 넘어감
        //                 아니면 끝숫자="66"+(N-카운트-1)
        //  현재숫자가 "6"으로 끝나면 + "66" + 0~9 = 6660~6669
        //      N-카운트>10이면 카운트+=10하고 다음으로 넘어감
        //                 아니면 끝숫자="6"+(N-카운트-1)
        //  세 경우 모두 아니면 카운트+1하고 다음탐색

        //카운트==N이면 현재숫자+끝숫자 출력
        //* N-카운트에서 1 빼는 이유 : 0부터 가능하니까

        int count = 1;
        String end = "666";
        for (int start = 1; start < N; start++) {
            switch (checkNum(start)) {
                case 3:
                    if (N - count > 1000) {
                        count += 1000;
                    } else {
                        end = String.format("%03d", N - count - 1);
                        count = N;
                    }
                    break;
                case 2:
                    if (N - count > 100) {
                        count += 100;
                    } else {
                        end = String.format("6%02d", N - count - 1);
                        count = N;
                    }
                    break;
                case 1:
                    if (N - count > 10) {
                        count += 10;
                    } else {
                        end = String.format("66%d", N - count - 1);
                        count = N;
                    }
                    break;
                default:
                    count++;
                    break;
            }

            if (count == N) {
                System.out.println(start+end);
                break;
            }
        }


    }


    //맨 끝에 6이 연속으로 몇 개 들어있는지 체크하는 함수
    public static int checkNum(int n) {
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            if (n % 10 != 6) break;

            cnt++;
            n /= 10;
        }

        return cnt;
    }
}
