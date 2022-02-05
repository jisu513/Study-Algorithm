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
				if (s.charAt(i - 1) == '(') {//else의 경우는 s.charAt(i)의 값이 ')'인데 i-1의 값이 '('라는 것은 
					                         // '()'의 모양이라는 의미 -> 레이저!
					answer += sk.size();
				} else {//s.charAt(i - 1)의 값이 ')'라는 것은 쇠막대기의 끝이라는 의미!
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
