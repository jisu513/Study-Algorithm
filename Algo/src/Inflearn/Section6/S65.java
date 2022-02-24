package Inflearn.Section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S65 {
	public char solution(int n, int[] arr) {
		char answer = 'U';

		// 1) 해시맵 사용
		/* HashMap<Integer, Integer> hm = new HashMap<>();
		for (int x : arr) {
			hm.put(x, hm.getOrDefault(x, 0) + 1);
		}

		for(int x : hm.keySet()) {
			if(hm.get(x) >= 2) {
				return 'D';
			}
		}*/
		
		// 2)정렬 사용
		Arrays.sort(arr);
		for(int i = 0; i<n-1; i++) {
			if(arr[i] == arr[i+1]) {
				return 'D';
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S65 S = new S65();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(S.solution(n, arr));
	}

}
