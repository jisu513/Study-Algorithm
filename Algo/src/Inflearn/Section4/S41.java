package Inflearn.Section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class S41 {// 학급회장(해쉬)
	public char solution(int n, String str) {
		char answer = ' ';

		HashMap<Character, Integer> hm = new HashMap<>();

		for (char x : str.toCharArray()) {
			hm.put(x, hm.getOrDefault(x, 0) + 1);
			// hm.getOrDefault(x, 0)+1 : (x라는 값이 존재하면 x의 값을 넣어주고 없다면 0)을 한 후 +1
			// --> key의 개수를 셀 때 사용!
		}
		int max = Integer.MIN_VALUE;
		for (char key : hm.keySet()) {
			// keySet(): map의 전체의 key 값을 출력하고 싶을 때 사용!
			if (max < hm.get(key)) {
				// get(): 특정 key값의 value를 가져올 때 사용! (이 문제에서는 key값의 개수가 들어있음!)
				max = hm.get(key);
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
