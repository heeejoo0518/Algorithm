import java.io.*;
import java.util.*;

public class Main{
	static int[] q = new int[2000000];
	static int size=0;
	static int front=0;
	static int back=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		String line;
		
		for(int i=0;i<n;i++) {
			switch(line = br.readLine()) {
			case "pop":
				sb.append(pop()+"\n"); break;
			case "size":
				sb.append(size()+"\n");break;
			case "empty":
				sb.append(empty()+"\n");break;
			case "front":
				sb.append(front()+"\n");break;
			case "back":
				sb.append(back()+"\n");break;
			default:
				push(Integer.parseInt(line.split(" ")[1]));
				break;
			}
		}
		br.close();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}
	
	public static void push(int x) {
		q[back++] = x;
		size++;
	}
	public static int pop() {
		if(size==0) return -1;
		size--;
		return q[front++];
	}
	public static int size() {
		return size;
	}
	public static int empty() {
		return size==0? 1 : 0;
	}
	public static int front() {
		return size==0? -1 : q[front];
	}
	public static int back() {
		return size==0? -1 : q[back-1];
	}
}