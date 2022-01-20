package Inflearn.Section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class S42 {// 아나그램(해쉬)
	public String solution(String s, String str) {
		String answer = "YES";

		HashMap<Character, Integer> hm = new HashMap<>();

		for (char x : s.toCharArray()) {
			hm.put(x, hm.getOrDefault(x, 0) + 1);
		}
		for (char x : str.toCharArray()) {
			if (!hm.containsKey(x) || hm.get(x) == 0) {
				//containsKey() : 특정 key 존재 여부를 확인할 때 사용!
				answer = "NO";
			}
			hm.put(x, hm.get(x) - 1);
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
