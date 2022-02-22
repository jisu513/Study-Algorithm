package Inflearn.Section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S64 {//Least Recently Used
	public int[] solution(int s, int n, int[] arr) {
		int[] answer = new int[s];
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S64 S = new S64();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int x : S.solution(s, n, arr)) {
			System.out.print(x + " ");
		}
	}

}
