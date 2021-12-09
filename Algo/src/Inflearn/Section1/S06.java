package Inflearn.Section1;

import java.io.*;
import java.util.*;

public class S06 {//�ߺ��� ���� ���� �� ���
	public String solution(String str) {
		String answer = "";
		
		for(int i = 0; i<str.length(); i++) {
			if(str.indexOf(str.charAt(i)) == i) {
				//indexOf() : char ��� ���� ���ڿ� ��ü���� �ش� ����(char c)�� ó�� �߰ߵ� ��ġ�� index ��ȯ!
				//            String ��� ���� ���ڿ� ��ü���� �ش� ���ڿ�(String s)�� ã�Ƽ� �����ϸ� ���ڿ��� ù������ �ش� index ��ȯ!(������ -1 ��ȯ!) 
				answer += str.charAt(i);
			}
		// i�� str.indexOf()�� ��ȣ�� ���� ���� ���� �ߺ��� ������!
		}
		
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S06 S = new S06();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		System.out.println(S.solution(str));

	}

}
