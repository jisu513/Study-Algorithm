package Inflearn.Section1;

import java.io.*;

public class S19 {// ���ڸ� ����
	public int solution(String str) {
		int answer = 0;

		str = str.replaceAll("[^0-9]", "");
		answer = Integer.parseInt(str);

		return answer;
	}

	public static void main(String[] args) throws IOException {
		S19 S = new S19();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		System.out.println(S.solution(str));

	}

}
