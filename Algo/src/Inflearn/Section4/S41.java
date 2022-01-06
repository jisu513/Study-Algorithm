package Inflearn.Section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class S41 {// 학급회장(해쉬)
	public char solution(int n, String str) {
		char answer = ' ';
		
		HashMap<Character, Integer> hs = new HashMap<>();
		for (char x : str.toCharArray()) {
			hs.put(x, hs.getOrDefault(x, 0) + 1);
			// **getOrDefault(key,#) : 키값이 있으면 가져오고 없으면 # 리턴하는 메소드 
			//   -> Hashmap에서 카운팅 할 때 많이 사용!
		}

		int max = 0;
		for (char key : hs.keySet()) {// keySet(): map에 존재하는 모든 키를 가져오는 메소드 
			if (hs.get(key) > max) {
				max = hs.get(key);
				answer = key;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S41 S = new S41();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();

		System.out.println(S.solution(n, str));

	}

}
