package Inflearn.Section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S25 {// �Ҽ� ���� ���ϱ� (�����佺�׳׽� ü) --> �Ҽ��� �Ǵ� ���� ����� ����� ������ �Ҽ�
	public int solution(int n) {
		int answer = 0;

		// �迭 ����
		int[] num = new int[n + 1]; // ���ڿ� index��ȣ�� ���� �ϱ� ���ؼ� n+1���� ���� --> num[1] �� ���� 1, num[2]�� ���� 2 ...
		
		for (int i = 2; i < n + 1; i++) { // ���� 1�� ����
			if (num[i] == 0) {
				answer++;
			}
			for (int j = i; j < n + 1; j += i) { // **KeyPoint! -> i����� �ε����� ���� �迭�� ���� 1�� ����
				                                 // --> �ش� �迭�� �������� ���� �ִٴ� �ǹ��̹Ƿ� �Ҽ��� �ƴ�!
				num[j] = 1;
			}

		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S25 S = new S25();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		System.out.println(S.solution(n));

	}

}
