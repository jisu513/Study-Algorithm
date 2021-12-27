package Inflearn.Section1;

import java.io.*;

public class S112 {// ��ȣ
	public String solution(int n, String str) {
		String answer = "";
		
		str = str.replace("#", "1").replace("*", "0");
		//str�� 2������ ������� �ٲ���!
		
		for(int i=0; i<n; i++) {
			String tmp = str.substring(0,7);
			/* subString(begin index, end index): ���ڿ� �ڸ���! (end index -1 ���� �ڸ�!)
			  ()�ȿ� ���� �ϳ� ������ �� index���� ������ ���� �ڸ�! 
			   ex) String s = "abcedf"
			      a = a.subString(0,3) --> ��� abc
			      a = a.subString(3) --> ��� def
			*/
			int num = Integer.parseInt(tmp,2);
			//2������ 10������ ��ȯ!
			answer += (char)num;
			
			str = str.substring(7);
		}
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S112 S = new S112();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());		
		String str = br.readLine();
		
		System.out.println(S.solution(n, str));

	}

}
