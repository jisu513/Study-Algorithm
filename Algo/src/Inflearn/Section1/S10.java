package Inflearn.Section1;

import java.io.*;
import java.util.*;

public class S10 {// 가장 짧은 문자거리(문자열의 최대 길이는 100)
	public int[] solution(String s, String c) {
		int[] answer = new int[s.length()];

		char t = c.charAt(0);
		int cnt = 1000; 
		// 처음 cnt를 큰 숫자로 잡아 놓은 것이 중요! -> cnt=0 일 경우 첫번째 문자열은 항상 최소값이므로 오답!

		for (int i = 0; i < s.length(); i++) { // 왼쪽 -> 오른쪽 최소거리 비교
			cnt++;
			if (s.charAt(i) == t) {
				cnt = 0;
			}
			answer[i] = cnt;
		}

		cnt = 1000;
	    
		for (int i = s.length() - 1; i >= 0; i--) { // 오른쪽 -> 왼쪽 최소거리 비교
			cnt++;
			if (s.charAt(i) == t) {
				cnt = 0;
			}

			answer[i] = Math.min(answer[i], cnt);
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
