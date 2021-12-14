package Inflearn.Section1;

import java.io.*;

public class S01 {// 문자 찾기

	public int solution(String str, char c) {
		int answer = 0;

		str = str.toUpperCase();
		c = Character.toUpperCase(c);

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c)
				answer++;
		}

		return answer;

	}

	public static void main(String[] args) throws IOException {
		S01 M = new S01();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char c = br.readLine().charAt(0);

		System.out.println(M.solution(str, c));
	}

}
