import java.io.*;
import java.util.*;

public class Main {

	public String solution(String m, String s) {
		String answer = "YES";

		Queue<Character> Q = new LinkedList<>();

		for (int i = 0; i < m.length(); i++) {
			Q.offer(m.charAt(i));
		}
		
		for(int i = 0; i<s.length(); i++) {
			if(Q.contains(s.charAt(i))) {
				if(s.charAt(i) != Q.poll()) { //Q에 들어는 있지만 맨 처음의 자료와 다르다면 NO
					                           //--> 순서를 지키지 않음!
					return "NO";
				}
			}
		}
		
		if(!Q.isEmpty()) {
			return "NO";
		}
		
		
		
		return answer;

	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String m = br.readLine();
		String s = br.readLine();

		System.out.print(T.solution(m, s)); 

	}

}