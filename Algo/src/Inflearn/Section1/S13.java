package Inflearn.Section1;

import java.io.*;

public class S13 {//���� �ӿ��� ���� �� �ܾ� ã�� (���� ������ �ܾ� �ִ� ��� ���� ���� �ܾ� ���!)
	public String solution(String str) {
		String answer = ""; 
		
		String[] s = str.split(" ");
		int max = 0;
		
		for(int i = 0; i<s.length; i++) {
			if(s[i].length() > max) {// >= ����ϸ� ���� ������ �ܾ� �ִ� ��� �ڿ� ���� �ܾ� ���!
				max = s[i].length();
				answer = s[i];
			}
		}
		return answer;
	}
	

	public static void main(String[] args) throws IOException {
		S13 S = new S13();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		System.out.print(S.solution(str));
		

	}

}
