package Inflearn.Section1;

import java.io.*;
import java.util.*;

public class S10 {
	public int[] solution(String s, String c) {
		int[] answer = new int[s.length()];

		char t = c.charAt(0);
		int cnt = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == t) {
				cnt = 0;
				answer[i] = cnt;
			} else {
				cnt++;
				answer[i] = cnt;
			}

		}

		cnt = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == t) {
				cnt = 0;
			} else {
				cnt++;
				answer[i] = Math.min(answer[i], cnt);
			}

		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		S10 S = new S10();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String s = st.nextToken();
		String c = st.nextToken();

		for (int x : S.solution(s, c)) {
			System.out.print(x + " ");
		}

	}

}
