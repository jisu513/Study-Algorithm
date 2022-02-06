package Inflearn.Section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S57 {// �������� ���� - �ʼ����� ���� �߿�!
	public String solution(String s, String str) {
		String answer = "YES";

		Queue<Character> q = new LinkedList<>();
		for(char x : s.toCharArray()) { // �ʼ����� q�� �ֱ�
			q.offer(x);
		}
		for(int i = 0; i<str.length(); i++) {
			if(q.contains(str.charAt(i))) {
				if(str.charAt(i) != q.poll()) {// **poll()�� ���� ���� �ʴٸ� ������ �ٸ��ٴ� �ǹ��̹Ƿ� No�� ����!(s = "abc" str = "cba"�̸� NO)
					return "NO";
				}
			}
		}
		
		if(!q.isEmpty()) { // q�� ������� �ʴٸ� str�� ���Ե��� ���� s�� �ִٴ� �ǹ��̹Ƿ� No ����!
			return "NO";
		}
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S57 S = new S57();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String str = br.readLine();

		System.out.println(S.solution(s, str));

	}

}
