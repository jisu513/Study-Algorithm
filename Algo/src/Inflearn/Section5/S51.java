package Inflearn.Section5;

import java.io.*;
import java.util.*;

public class S51 {//�ùٸ� ��ȣ
	public String solution(String s) {
		String answer = "YES";
		
		Stack<Character> st =new Stack<>();
		for(char x : s.toCharArray()) {
			if(x == '(') {
				st.push(x);
			}else {
				if(st.isEmpty()) { // ')'�� �� ���� ���
					return "NO";
				}
				st.pop();
			}
		}
		
		if(!st.isEmpty()) {//'('�� ')'�� ¦�� �°� pop�ߴµ� stack�� ������� �ʴٸ� '('�� �� ���ٴ� �ǹ�!
			return "NO";
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S51 S = new S51();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		System.out.println(S.solution(s));

	}

}
