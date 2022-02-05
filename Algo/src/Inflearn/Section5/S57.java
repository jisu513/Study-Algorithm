package Inflearn.Section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S57 {// 교육과정 설계 - 필수과목 순서 중요!
	public String solution(String s, String str) {
		String answer = "YES";

		Queue<Character> q = new LinkedList<>();
		
		for(char x : s.toCharArray()) { //필수과목 s를 q에 setting!
			q.offer(x);
		}
		for(int i = 0; i<str.length(); i++) {
			if(q.contains(str.charAt(i))) {
				//***if문 생각해내기 어려움.. ***
				if(str.charAt(i) != q.poll()) {//str 안에 s가 있지만 순서가 다르다면 NO!
					return "NO";
				}
			}
		}
		if(!q.isEmpty()) {
			return "NO"; //q가 비어있지 않다면 str이 필수과목인 s를 모두 포함하고 있지는 않다는 의미이므로 NO!
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
