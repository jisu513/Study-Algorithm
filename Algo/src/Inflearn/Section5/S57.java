package Inflearn.Section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S57 {// 교육과정 설계
	public String solution(String s, String str) {
		String answer = "YES";

		Queue<Character> q = new LinkedList<>();
		for (char x : s.toCharArray()) {
			q.offer(x);
		}

		for (int i = 0; i < str.length(); i++) {
			if (q.contains(str.charAt(i))) {// str안에 s가 포함되어 있는 것 뿐만 아니라 순서도 같은 순서로 있어야함
				if (str.charAt(i) != q.poll()) {
					return "NO";
				}
			}
		}
		if (!q.isEmpty()) {
			return "NO";
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S57 S = new S57();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String str = br.readLine();

		System.out.println(S.solution(s, str));

	}

}
