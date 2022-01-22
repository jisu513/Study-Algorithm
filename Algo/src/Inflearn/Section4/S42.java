package Inflearn.Section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class S42 {// �Ƴ��׷�(�ؽ�)
	public String solution(String s, String str) {
		String answer = "YES";

		HashMap<Character, Integer> hm = new HashMap<>();

		for (char x : s.toCharArray()) {
			hm.put(x, hm.getOrDefault(x, 0) + 1);
		}
		for (char x : str.toCharArray()) {
			if (!hm.containsKey(x) || hm.get(x) == 0) {
				//containsKey() : Ư�� key ���� ���θ� Ȯ���� �� ���!
				// hm.get(x)== 0 : str�� �ִ� �ܾ hm(s�� ����)�� ���ٴ� �ǹ��̹Ƿ� No ���!
				answer = "NO";
			}
			hm.put(x, hm.get(x) - 1);
			//s�� str�� ���ڰ� ��ġ�ϸ� -1����! 
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
