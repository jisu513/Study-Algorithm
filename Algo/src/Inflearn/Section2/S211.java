package Inflearn.Section2;

import java.io.*;
import java.util.*;

public class S211 {// �ӽ� ���� ���ϱ�
	public int solution(int n, int[][] arr) {
		int answer = 0;

		int cnt = 0, max = 0;
		// 3�� for��
		for (int i = 1; i < n + 1; i++) {// ���� �л�
			cnt = 0;
			for (int j = 1; j < n + 1; j++) {// �� �л�
				for (int k = 1; k < 6; k++) {// �г�(5�г������)
					if (arr[i][k] == arr[j][k]) {
						cnt++;
						break; // �� ���̶� ���� ���̾��� ��� count(������ ���� ���̾������ �ѹ���!)
					}
				}
				if (cnt > max) {
					max = cnt;
					answer = i; // �ִ밪�� ����� i�� �л��� ��
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		S211 S = new S211();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n + 1][6];
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 6; j++) { // 5�г� ����!
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(S.solution(n, arr));
	}

}
