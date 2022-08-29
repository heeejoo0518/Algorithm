import java.io.*;
import java.util.*;

public class p1 {
	static int N;
	static int bit;
	static int[][] map;
	static House[] houses;
	static int D;
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine().trim());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			sb.append('#').append(tc).append(' ');
			
			D = Integer.MAX_VALUE;
			
			map = new int[31][31];//x y 순서
			for(int i=0;i<31;i++) Arrays.fill(map[i], 1);
			
			N = Integer.parseInt(in.readLine().trim());
			houses = new House[N+1];
			bit = (1<<N+1)-1;
			int x,y,d;
			for(int n=1;n<=N;n++) {
				st = new StringTokenizer(in.readLine());
				x = Integer.parseInt(st.nextToken())+15;
				y = Integer.parseInt(st.nextToken())+15;
				d = Integer.parseInt(st.nextToken());
				
				houses[n] = new House(x,y,d);
				map[x][y] = 0;
				
				for(int i=x-d;i<=x+d;i++) {
					for(int j=y-d;j<=y+d;j++) {
						if(i==x && j==y) continue;
						else if(i<0 || i> 30 || j<0 || j>30) continue;
						else if(Math.abs(x-i)+Math.abs(y-j) > d) continue;
						if(map[i][j]!=0) map[i][j] |= (1<<n);
						if(n==N && map[i][j]==bit) {//하나로 전부 해결됨.
							int tmp = 0;
							for(House h:houses) {
								if(h == null) continue;
								tmp += Math.abs(h.x-i)+Math.abs(h.y-j);
							}
							D = Math.min(D, tmp);
						}
					}
				}
			}
			
			if(D != Integer.MAX_VALUE) {//하나로 전부 해결됨.
				sb.append(D).append('\n');
				continue;
			}
			
			int[] distance;
			int flag = 0;
			
			for(int i=0;i<31;i++) {
				for(int j=0;j<31;j++) {
					if(map[i][j]==0)continue;
					flag = map[i][j];
					distance = new int[N+1];
					for(int h=1;h<=N;h++) {
						if((flag & 1<<h) !=0) {
							distance[h] = Math.abs(i-houses[h].x)+Math.abs(j-houses[h].y);
						}
					}
					
					for(int ii=i;ii<31;ii++) {
						for(int jj=0;jj<31;jj++) {
							if(ii==i && jj<=j) continue;
							if(map[ii][jj]==0)continue;
							if((flag | map[ii][jj]) < bit) continue;
							
							int tmp = 0;
							
							for(int h=1;h<=N;h++) {
								if((map[ii][jj] & 1<<h) !=0) {
									int dis = Math.abs(ii-houses[h].x)+Math.abs(jj-houses[h].y);
									if(distance[h]==0 || distance[h]> dis) tmp += dis;
									else tmp += distance[h];
								}else {
									tmp+= distance[h];
								}
							}
							
							D = Math.min(D, tmp);
						}
					}
				}
			}
			
			if(D != Integer.MAX_VALUE) {
				sb.append(D).append('\n');
			}else {
				sb.append(-1).append('\n');
			}
			
		}
		System.out.println(sb);
	}
	
	private static class House {
		int x, y, d;
		House(int x, int y, int d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
