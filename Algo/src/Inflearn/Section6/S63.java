package Inflearn.Section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S63 {
	public int[] solution(int n, int[] arr) {
		/*
		 * �������� : ������ ��Ҹ� �׺��� �� ������ �˸��� ��ġ�� '�����ϴ�' �۾��� �ݺ��Ͽ� �����ϴ� �˰���! 
		 * �ð� ���⵵ = O(N*N)
		 *   --> ���� �ð����⵵�� ������ ����, ���� ���Ŀ� ���� �ʿ��� ���� �����Ѵٴ� ������ ���� ���� ���� ���� ȿ����
		 */

		for (int i = 1; i < n; i++) { // i�� 1���� ����!!
			int tmp = arr[i];
			int j;
			for (j = i - 1; j >= 0; j--) {
				if (arr[j] > tmp) {
					arr[j + 1] = arr[j];
				} else {
					break;
				}
			}
			arr[j + 1] = tmp;
		}
		return arr;
	}

	public static void main(String[] args) throws IOException {
		S63 S = new S63();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

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
