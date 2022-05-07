import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int[] tiles;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());		
		br.close();
		
		tiles = new int[n+2];
		tiles[1] = 1;
		tiles[2] = 2;
		
		System.out.println(checkTile(n));
	}
	
	public static int checkTile(int n) {
		if(n<=1) return tiles[1];
		if(n==2) return tiles[2];
		
		if(tiles[n]!=0) return tiles[n];
		
		tiles[n] = (checkTile(n-1)+checkTile(n-2))%15746;
		return tiles[n];
	}
}
