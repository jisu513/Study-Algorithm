package Inflearn.Section1;

import java.io.*;
import java.util.*;

public class S05 { //Ư�� ���� ������!(���ڰ� ���ĺ��� ��츸 ������!)
	public String solution(String str) {
		String answer = "";

		char[] c = str.toCharArray();
		int lt = 0;
		int rt = str.length() - 1;

		while (lt < rt) {
			if (!Character.isAlphabetic(c[lt])) { //���ĺ��� �ƴѰ�� lt�� ��ġ�� �̵�
				lt++;
			} else if (!Character.isAlphabetic(c[rt])) { //���ĺ��� �ƴѰ�� rt�� ��ġ�� �̵�
				rt--;
			} else {
				char tmp = c[lt];
				c[lt] = c[rt];
				c[rt] = tmp;
				lt++;
				rt--;
			}
		}
		answer = String.valueOf(c);
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S05 S = new S05();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		System.out.println(S.solution(str));

	}

}
