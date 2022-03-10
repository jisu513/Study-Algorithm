package Inflearn.Section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S610 {// ������ ���ϱ�(���� �˰���)
	public int count(int[] arr, int dist) {
		int cnt = 1; // ��ġ�� ���� ����
		int ep = arr[0]; // ���� ��ġ�� ��ǥ (ù ���� �迭�� ù��°�� ��ġ�Ǵ� ���� ���� ����)

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] - ep >= dist) { // ���� ��ġ�Ϸ��� �ϴ� ��ǥ�� �̹� ���� ����ִ� ��ǥ ������ �Ÿ��� dist(=mid) ���� ũ�ų� ���ƾ���
				cnt++;
				ep = arr[i]; // ���� ��ġ�� ��ǥ ������Ʈ
			}
		}
		return cnt;
	}

	public int solution(int n, int c, int[] arr) {
		int answer = 0;

		Arrays.sort(arr); // �����˻��� �ݵ�� ������ �Ǿ��־�� ��!
		int lt = 1; // ������ ������ �ּҰŸ�
		int rt = arr[n - 1]; // ���� ������ ��ǥ ��

		while (lt <= rt) {
			int mid = (lt + rt) / 2; // �� ���� �ִ�Ÿ�
			if (count(arr, mid) >= c) {
				answer = mid;
				lt = mid + 1;
			} else {
				rt = mid - 1;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		S610 S = new S610();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(S.solution(n, c, arr));

	}

}
