package Inflearn.Section1;

import java.io.*;
import java.util.*;

public class S17 {// �Էµ� ���ڸ� �տ��� ���� ���� �ڿ��� ���� ���� ���ڿ��� �������
	public String solution(String str) {
		String answer = "YES";

		str = str.toLowerCase();
		int len = str.length() / 2;
		int rt = str.length() - 1;

		// --> ���� Ǭ ��
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == str.charAt(rt)) {
				rt--;
			} else {
				return "NO";
			}
		}

		// ���1) for�� ���
		for (int i = 0; i < len; i++) {
			char[] c = str.toCharArray();
			if (c[i] != c[rt - i]) {
				answer = "NO";
			}
		}

		// ���2) reverse()���
		// *** �� ��� String answer = "NO"; ������! ***
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
