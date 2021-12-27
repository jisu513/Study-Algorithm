package Inflearn.Section1;

import java.io.*;

public class S12 { //�빮�� -> �ҹ��ڷ� �ҹ��� -> �빮�ڷ� ��ȯ
	public String solution(String str) {
		String answer = "";

		for (int i = 0; i < str.length(); i++) {
			if (Character.isLowerCase(str.charAt(i))) { 
				answer += Character.toUpperCase(str.charAt(i));
			} else {
				answer += Character.toLowerCase(str.charAt(i));
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S12 M = new S12();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		System.out.print(M.solution(str));

	}

}
