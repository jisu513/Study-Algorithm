package Inflearn.Section3;

import java.io.*;
import java.util.*;

public class S36 {// �ִ���� ���Ӻκм���
	public int solution(int n, int k, int[] arr) {
		int answer = 0;

		int cnt = 0, len = 0, lt = 0;
		for (int rt = 0; rt < n; rt++) {
			if (arr[rt] == 0) {
				cnt++;
			}
			while (cnt > k) {
				if (arr[lt] == 0) {// arr[lt]�� ���� 0�̸� cnt�� �ϳ� ����!(cnt > k ��� ������ �ϳ� ���°� �ƴ�!)
					cnt--;
				}
				lt++;
			}
			len = rt - lt + 1;
			answer = Math.max(answer, len);
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		S36 S = new S36();

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

		System.out.println(S.solution(n, k, arr));
	}

}
