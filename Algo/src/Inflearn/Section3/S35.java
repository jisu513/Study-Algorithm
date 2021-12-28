package Inflearn.Section3;

import java.io.*;

public class S35 {
	public int solution(int n) {// ���ӵ� �ڿ����� ��(�� n�� �Ǵ� ����)
		int answer = 0;

		int len = n / 2 + 1;
		int sum = 0, lt = 0;
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {// ���ӵ� �ڿ����� ���� �迭 �����!(���� n�� �� �迭�� n/2 ������ ����� ��!)
			arr[i] = i + 1;
		}

		for (int rt = 0; rt < len; rt++) {
			sum += arr[rt];
			if (sum == n) {
				answer++;
			}
			while (sum >= n) {
				sum -= arr[lt];
				if (sum == n) {
					answer++;
				}
				lt++;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		S35 S = new S35();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		System.out.println(S.solution(n));

	}

}
