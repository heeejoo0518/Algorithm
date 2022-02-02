import java.util.Scanner;

public class BOJ_11653_소인수분해 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.close();

        //N이 1인경우 아무것도 출력하지 않음
        if(N==1) return;

        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=N;i++){
            if(N%i==0){
                sb.append(i).append("\n");
                N/=i;
                i=1;
            }
        }

        System.out.print(sb.toString());
    }
}
