package Inflearn.Section1;

import java.io.*;
import java.util.*;

public class S110 {// ���� ª�� ���ڰŸ�(���ڿ��� �ִ� ���̴� 100)
	public int[] solution(String s, String c) {
		int[] answer = new int[s.length()];

		char t = c.charAt(0);
		int cnt = 1000; 
		// ó�� cnt�� ū ���ڷ� ��� ���� ���� �߿�! -> cnt=0 �� ��� ù��° ���ڿ��� �׻� �ּҰ��̹Ƿ� ����!

		for (int i = 0; i < s.length(); i++) { // ���� -> ������ �ּҰŸ� ��
			cnt++;
			if (s.charAt(i) == t) {
				cnt = 0;
			}
			answer[i] = cnt;
		}

		cnt = 1000;
	    
		for (int i = s.length() - 1; i >= 0; i--) { // ������ -> ���� �ּҰŸ� ��
			cnt++;
			if (s.charAt(i) == t) {
				cnt = 0;
			}

			answer[i] = Math.min(answer[i], cnt);
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		S110 S = new S110();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String s = st.nextToken();
		String c = st.nextToken();

		for (int x : S.solution(s, c)) {
			System.out.print(x + " ");
		}

	}

}
