package Inflearn.Section2;

import java.io.*;
import java.util.*;

public class S07 {// 점수계산
	public int solution(int n, int[] arr) {
		int answer = 0;

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			cnt++;
			if (arr[i] == 0) {
				cnt = 0;
			}
			answer += cnt;
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		S07 S = new S07();

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
