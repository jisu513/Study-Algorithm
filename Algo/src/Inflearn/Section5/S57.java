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
		// 필수과목 q에 넣기
		for(char x : s.toCharArray()) { 
			q.offer(x);
		}
		for(int i = 0; i<str.length(); i++) {
			if(q.contains(str.charAt(i))) {
				if(q.poll() != str.charAt(i)) {
					// **poll()한 값과 같지 않다면 순서가 다르다는 의미이므로 No를 리턴!(s = "abc" str = "cba"이면 NO)
					return "NO";
				}
			}
		}
		if(!q.isEmpty()) {  // q가 비어있지 않다면 str에 포함되지 못한 s가 있다는 의미이므로 No 리턴!
			return " NO";
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
