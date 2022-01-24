package Inflearn.Section4;

import java.io.*;
import java.util.*;

public class S43 {// 매출액의 종류 (HashMap + SlidingDoor)
	public ArrayList<Integer> solution(int n, int k, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();

		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < k - 1; i++) {
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
		}
		int lt = 0;
		for (int rt = k - 1; rt < n; rt++) {
			hm.put(arr[rt], hm.getOrDefault(arr[rt], 0) + 1); // arr[]의 k번째 까지 HashMap에 put!
			answer.add(hm.size());

			// 한 칸씩 옆으로 이동해주는 과정
			hm.put(arr[lt], hm.get(arr[lt]) - 1);
			if (hm.get(arr[lt]) == 0) {
				// hm에서 arr[lt]의 vlaue 값이 0이면 삭제! -> 하지 않으면 다음번에 answer.add할 때 카운팅됨!
				hm.remove(arr[lt]);
			}
			lt++;
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S43 S = new S43();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int x : S.solution(n, k, arr)) {
			System.out.print(x + " ");
		}

	}

}
