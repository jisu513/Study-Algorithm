package Inflearn.Section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S52 {// ��ȣ ���� ����
	public String solution(String s) {
		String answer = "";

		Stack<Character> st = new Stack<>();
		for (char x : s.toCharArray()) {
			if (x == ')') {
				while (st.pop() != '('); 
				// pop() : ������ ���� �� return! --> ** st.pop() == '(' �̸� '(' ������ while�� ��������!  
			} else {
				st.push(x);
			}
		}

		for (int i = 0; i < st.size(); i++) { // size(): ������ ũ��!
			answer += st.get(i);
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		S52 S = new S52();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		System.out.print(S.solution(s));

	}

}
