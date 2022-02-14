package Inflearn.Section5;

import java.io.*;
import java.util.*;

public class S51 {// 올바른 괄호
	public String solution(String s) {
		String answer = "YES";

		Stack<Character> st = new Stack<>();
		for (char x : s.toCharArray()) {
			if (x == '(') {
				st.push(x);
			} else {
				if (st.isEmpty()) { //*** ')'가 있는데 스택이 비어있다면 ')'가 더 많다는 뜻! ***
					return "NO";
				}
				st.pop();
			}
		}

		if (!st.isEmpty()) { //for문 이후에도 스택이 비어있지 않다면 '(' 이 더 많다는 뜻!
			return "NO";
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		S51 S = new S51();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		System.out.println(S.solution(s));

	}

}
