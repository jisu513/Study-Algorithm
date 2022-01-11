package Inflearn.Section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class S41 {// �б�ȸ��(�ؽ�) ����� �������� Ȯ��
	public char solution(int n, String str) {
		char answer = ' ';
		
		HashMap<Character, Integer> hs = new HashMap<>();
		for (char x : str.toCharArray()) {
			hs.put(x, hs.getOrDefault(x, 0) + 1);
			// **getOrDefault(key,#) : Ű���� ������ �������� ������ # �����ϴ� �޼ҵ� 
			//   -> Hashmap���� ī���� �� �� ���� ���!
		} 

		int max = 0;
		for (char key : hs.keySet()) {// keySet(): map�� �����ϴ� ��� Ű�� �������� �޼ҵ� 
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