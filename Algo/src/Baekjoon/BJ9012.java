package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ9012 {// °ýÈ£
	public static String solution(String s) {
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				st.push(s.charAt(i));
			} else {
				if (st.isEmpty()) {
					return "NO";
				}
				st.pop();
			}
		}
		if (!st.isEmpty()) {
			return "NO";
		}

		return "YES";
	}

	public static void main(String[] args) throws IOException {
		BJ9012 B = new BJ9012();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			sb.append(solution(br.readLine())).append('\n');
		}

		System.out.println(sb);

	}

}
