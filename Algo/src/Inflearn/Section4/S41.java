package Inflearn.Section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class S41 {// �б�ȸ��(�ؽ�)
	public char solution(int n, String str) {
		char answer = ' ';

		HashMap<Character, Integer> hm = new HashMap<>();

		for (char x : str.toCharArray()) {
			hm.put(x, hm.getOrDefault(x, 0) + 1);
			// hm.getOrDefault(x, 0)+1 : (x��� ���� �����ϸ� x�� ���� �־��ְ� ���ٸ� 0)�� �� �� +1
			// --> key�� ������ �� �� ���!
		}
		int max = Integer.MIN_VALUE;
		for (char key : hm.keySet()) {
			// keySet(): map�� ��ü�� key ���� ����ϰ� ���� �� ���!
			if (max < hm.get(key)) {
				// get(): Ư�� key���� value�� ������ �� ���! (�� ���������� key���� ������ �������!)
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
