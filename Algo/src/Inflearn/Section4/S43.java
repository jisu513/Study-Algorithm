package Inflearn.Section4;

import java.io.*;
import java.util.*;

public class S43 {// ������� ���� (HashMap + SlidingDoor)
	public ArrayList<Integer> solution(int n, int k, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();

		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < k - 1; i++) {
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
		}
		int lt = 0;
		for (int rt = k-1; rt < n; rt++) {
			hm.put(arr[rt], hm.getOrDefault(arr[rt], 0) + 1); //arr[]�� k��° ���� HashMap�� put!
			answer.add(hm.size());

			// �� ĭ�� ������ �̵����ִ� ����
			hm.put(arr[lt], hm.get(arr[lt]) - 1); 
			if (hm.get(arr[lt]) == 0) { 
				// hm���� arr[lt]�� vlaue ���� 0�̸� ����! -> ���� ������ �������� answer.add�� �� ī���õ�!
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
