package Inflearn.Section1;

import java.io.*;
import java.util.*;

public class S17 {// 입력된 문자를 앞에서 읽을 때와 뒤에서 읽을 때의 문자열이 같은경우
	public String solution(String str) {
		String answer = "YES";

		str = str.toLowerCase();
		int len = str.length() / 2;
		int rt = str.length() - 1;

		// --> 내가 푼 답
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == str.charAt(rt)) {
				rt--;
			} else {
				return "NO";
			}
		}

		// 방법1) for문 사용
		for (int i = 0; i < len; i++) {
			char[] c = str.toCharArray();
			if (c[i] != c[rt - i]) {
				answer = "NO";
			}
		}

		// 방법2) reverse()사용
		// *** 이 경우 String answer = "NO"; 여야함! ***
		String rev = new StringBuilder(str).reverse().toString().toLowerCase();
		if (str.equals(rev)) {
			answer = "YES";
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S17 S = new S17();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		System.out.println(S.solution(str));

	}

}
