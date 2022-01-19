package Inflearn.Section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S222 {// ���丵
	// ***�ʾ �򰥸�..***
	public int solution(int n, int m, int[][] arr) {// n�� �л� ��, m�� test��
		int answer = 0;

		// 4�� for�� ���
		for (int i = 1; i <= n; i++) {// n:�л� �� i=����
			for (int j = 1; j <= n; j++) {//     j=��Ƽ --> (i, j) = (����, ��Ƽ) ����� ��
				int cnt = 0;
				for (int k = 0; k < m; k++) {// m:test ��
					int pi = 0, pj = 0;
					for (int s = 0; s < n; s++) {// n:�� �� --> �л� �� = ���(�翬�� �Ҹ�����.. �򰥷���)
						if (arr[k][s] == i) {// arr[k][s]�� ���� ����/��Ƽ �л���ȣ!
							pi = s; // i�� s��
							// -->arr[k][s]�� ���� i�� ���� ���� �� ���� s���� i�� ���!
						}
						if (arr[k][s] == j) {
							pj = s;
						}

					}
					if (pi < pj) {// ����� ���� ������ ���� ���!(�򰥸�..)
						cnt++;
					}
				}
				if (cnt == m) {// cnt�� ���� test���� ���ƾ� ��� test���� i�� j���� ���� ��� --> ���丵 ����!
					answer++;
				}

			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		S222 S = new S222();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = null;
		StringTokenizer st2 = null;

		st1 = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st1.nextToken()); // �л� ��
		int m = Integer.parseInt(st1.nextToken()); // �׽�Ʈ ��

		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		System.out.println(S.solution(n, m, arr));

	}

}
