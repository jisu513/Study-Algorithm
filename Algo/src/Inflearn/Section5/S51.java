package Inflearn.Section5;

import java.io.*;
import java.util.*;

public class S51 {//올바른 괄호
	public String solution(String s) {
		String answer = "YES";
		
		Stack<Character> st =new Stack<>();
		for(char x : s.toCharArray()) {
			if(x == '(') {
				st.push(x);
			}else {
				if(st.isEmpty()) { // '('이 있어야 ')'을 pop()하는데 stack이 비어있다는 것은 ')'가 더 많다는 의미!
					return "NO";
				}
				st.pop();
			}
		}
		
		if(!st.isEmpty()) {//'('와 ')'이 짝에 맞게 pop했는데 stack이 비어있지 않다면 '('이 더 많다는 의미!
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
