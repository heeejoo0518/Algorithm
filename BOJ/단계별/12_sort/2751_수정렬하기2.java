import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		ArrayList<Integer> num = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			num.add(in.nextInt());
		}
		
		in.close();
		
		//merge-sort
		Collections.sort(num);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {			
			sb.append(num.get(i)+"\n");
		}
		
		System.out.println(sb.toString());
	}
}
