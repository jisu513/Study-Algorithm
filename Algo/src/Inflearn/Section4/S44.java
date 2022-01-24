package Inflearn.Section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class S44 {//��� �Ƴ��׷� ã�� (t�ܾ s���ڿ��� �� �� ����ִ���)
	public int solution(String s, String t) {
		int answer = 0;

		//HashMap 2�� ���!
		HashMap<Character, Integer> smap = new HashMap<>();
		HashMap<Character, Integer> tmap = new HashMap<>();
		
		for (char x : t.toCharArray()) {
			tmap.put(x, tmap.getOrDefault(x, 0) + 1);
		}
		int len = t.length(); //�񱳴���� t�ܾ� ����
		char sarr[] = s.toCharArray(); //s���ڿ� �迭�� �ٲ�
		for (int i = 0; i < len - 1; i++) { //t�ܾ� ���� -1 ��ŭ�� s���ڿ� smap�� �ֱ�(Slidingdoor ����ϱ� ����)
			smap.put(sarr[i], smap.getOrDefault(sarr[i], 0) + 1);
		}
		int lt = 0;
		for (int rt = len - 1; rt < s.length(); rt++) {
			smap.put(sarr[rt], smap.getOrDefault(sarr[rt], 0) + 1);
			if (smap.equals(tmap)) {//t���ڿ��� s���ڿ��� ������ Ȯ��!
				answer++;
			}

			//���ڸ��� ������ �̵���Ű�� ���� ����!
			smap.put(sarr[lt], smap.get(sarr[lt]) - 1);
			if (smap.get(sarr[lt]) == 0) {
				smap.remove(sarr[lt]);
			}
			lt++;
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S44 S = new S44();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String t = br.readLine();

		System.out.print(S.solution(s, t));

	}

}
