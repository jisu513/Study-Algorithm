package Inflearn.Section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class S42 {// 아나그램(해쉬)
	public String solution(String s, String str) {
		String answer = "YES";
		HashMap<Character, Integer> hs = new HashMap<>();

		for (char x : s.toCharArray()) {
			hs.put(x, hs.getOrDefault(x, 0) + 1);
		}

		for (char x : str.toCharArray()) {
			if (!hs.containsKey(x) || hs.get(x) == 0) {
				// containsKey(): key존재의 유무를 알아보는 메소드
				return "NO";
			}
			hs.put(x, hs.get(x) - 1);
			//s 와 str의 해당 알파벳 갯수가 같은지 확인할 수 있음 (-> key 값)
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S42 S = new S42();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String str = br.readLine();

		System.out.println(S.solution(s, str));

	}

}
