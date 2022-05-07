import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_7568_덩치 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        List<Body> persons = new ArrayList<>();

        //입력
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            persons.add(new Body(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        in.close();

        //탐색
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int tmp = 1;
            for (int j = 0; j < N; j++) {
                if(j==i) continue;
                if (persons.get(j).compareTo(persons.get(i)) > 0) tmp++;
            }
            sb.append(tmp).append(" ");
        }

        //출력
        System.out.println(sb.toString());
    }

}

class Body implements Comparable<Body> {
    int height;
    int weight;

    public Body(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public int compareTo(Body o) {
        if (this.height > o.height && this.weight > o.weight) return 1;
        else if (this.height < o.height && this.weight < o.weight) return -1;
        return 0;
    }
}
