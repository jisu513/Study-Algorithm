package Inflearn.Section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S210 {// ���츮 (�����¿캸�� ū ���ڴ� ���츮) 2-10��
	public int solution(int n, int[][] arr) {
		int answer = 0;
		// ����迭 ���� ����!
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		// 3�� for�� ���
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				boolean flag = true;// ���츮 ���� �ƴ��� �Ǻ�
				for (int k = 0; k < 4; k++) {// �����¿� 4�� ��!
					int nx = i + dx[k]; // �����¿� ��ǥ�� �� ��
					int ny = j + dy[k]; // �����¿� ��ǥ�� �� ��
					if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] > arr[i][j]) {
						// nx�� ny�� ��� ���� ���� ���������! -> �����ָ� outOfIndex~ ������
						flag = false;
						break; // arr[i][j]�� �����¿�(arr[nx][ny]) �� �ϳ��� ũ�Ⱑ ũ�ų� ������ �ߴ� -> ���츮 �ƴ�!
					}

				}
				if (flag) {
					answer++;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		S210 S = new S210();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(S.solution(n, arr));
	}

}
