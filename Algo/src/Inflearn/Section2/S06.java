package Inflearn.Section2;

import java.io.*;
import java.util.*;

public class S06 {// ������ �Ҽ�
	public boolean isPrime(int n) {//�Ҽ����� �Ǻ�!
		if (n == 1) {
			return false;
		}
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public ArrayList<Integer> solution(int n, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int tmp = arr[i];
			int rev = 0;

			while (tmp > 0) { // ***���� ������***
				int t = tmp % 10; // tmp�� ������(������ �ڸ� ����)
				rev = rev * 10 + t; // ������ ����
				tmp = tmp / 10; // tmp�� ��
			}
			if (isPrime(rev)) {
				answer.add(rev);
			}

		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		S06 S = new S06();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int x : S.solution(n, arr)) {
			System.out.print(x + " ");
		}

	}

}
