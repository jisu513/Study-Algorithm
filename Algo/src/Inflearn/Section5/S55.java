package Inflearn.Section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S55 {// 쇠막대기
	public int solution(String s) {
		int answer = 0;

		Stack<Character> sk = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				sk.push(s.charAt(i));
			} else {
				sk.pop();
				if (s.charAt(i - 1) == '(') { // '()' 모양이므로 구슬!
					answer += sk.size();
				} else {// 막대기의 끝을 의미!
					answer++;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		S55 S = new S55();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		System.out.println(S.solution(s));

	}

}
