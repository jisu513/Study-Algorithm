package Inflearn.Section3;

import java.io.*;
import java.util.*;

public class S31 {//두 배열 합치기(two pointers algorithm)
	public ArrayList<Integer> solution(int n, int m, int[] narr, int[] marr){
		ArrayList<Integer> answer = new ArrayList<>();
		
		int p1=0, p2=0;
		
		//narr과 marr 크기 비교후 작은 것 먼저 add
		while(p1 < n && p2 < m) {
			if(narr[p1] < marr[p2]) {
				answer.add(narr[p1]);
				p1++;
			}else {
				answer.add(marr[p2]);
				p2++;
			}
		}
		
		//비교 후 남은 배열 add
		while(p1 < n) {
			answer.add(narr[p1]);
			p1++;
		}
		
		while(p2 < m) {
			answer.add(marr[p2]);
			p2++;
		}
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S31 S = new S31();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		int[] narr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			narr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] marr = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			marr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		for(int x : S.solution(n, m, narr, marr)) {
			System.out.print(x + " ");
		}

	}

}
