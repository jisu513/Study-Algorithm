package Inflearn.Section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class S44 {//모든 아나그램 찾기 (t단어가 s문자열에 몇 번 들어있는지)
	public int solution(String s, String t) {
		int answer = 0;

		//HashMap 2개 사용!
		HashMap<Character, Integer> smap = new HashMap<>();
		HashMap<Character, Integer> tmap = new HashMap<>();
		
		for (char x : t.toCharArray()) {
			tmap.put(x, tmap.getOrDefault(x, 0) + 1);
		}
		int len = t.length(); //비교대상이 t단어 길이
		char sarr[] = s.toCharArray(); //s문자열 배열로 바꿈
		for (int i = 0; i < len - 1; i++) { //t단어 길이 -1 만큼의 s문자열 smap에 넣기(Slidingdoor 사용하기 위해)
			smap.put(sarr[i], smap.getOrDefault(sarr[i], 0) + 1);
		}
		int lt = 0;
		for (int rt = len - 1; rt < s.length(); rt++) {
			smap.put(sarr[rt], smap.getOrDefault(sarr[rt], 0) + 1);
			if (smap.equals(tmap)) {//t문자열과 s문자열이 같은지 확인!
				answer++;
			}

			//한자리씩 옆으로 이동시키기 위한 과정!
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
