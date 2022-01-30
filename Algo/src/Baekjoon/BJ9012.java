package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9012 {//°ýÈ£
	public static String solution(String s) {
		String answer="Yes";
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BJ9012 B = new BJ9012();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i<n; i++) {
			sb.append(solution(br.readLine())).append('\n');
		}
		
		System.out.println(sb);

		
		
		
		

	}

}
