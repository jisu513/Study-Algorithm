package Inflearn.Section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S52 {// 괄호 문자 제거
	public String solution(String s) {
		String answer = "";

		Stack<Character> st = new Stack<>();

		for (char x : s.toCharArray()) {
			if (x == ')') {
				while (st.pop() != '('); // pop(): 가장 상단에 있는 원소를 꺼냄과 동시에 꺼낸 값을 return!
		        // --> '('까지 pop하고 whlie문 탈출!			
			} else {
				st.push(x);
			}

		}

		for (int i = 0; i < st.size(); i++) { // size(): stack의 크기
			answer += st.get(i);
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S52 S = new S52();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		System.out.print(S.solution(s));

	}

}
