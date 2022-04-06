package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S801 { // ���� ���� �κ����� (DFS)
	static int n, total = 0; // total�� arr�� �� ��
	static String answer = "No";
	boolean flag = false; // answer = "YES" �� �߰ߵ��� �� �� ���� ��͵��� ��� return ��Ű�� ���� ǥ��

	public void DFS(int L, int sum, int[] arr) { // sum�� �κ������� ����
		if (flag) {
			return;
		}
		if (sum > total / 2) { // �κ�����(sum)�� ������ total/2���� ũ�� �� �غ� �ʿ� X (���� ���� �κ������� ã�� �ֱ⶧����!)
			return;
		}
		if (n == L) { // index�� 0 ~ n-1 ���� -> n==L�̸� �κ����� �ϼ�
			if ((total - sum) == sum) { // �� �κ������� ���� �����Ƿ�
				answer = "YES";
				flag = true;
			}
		} else {
			DFS(L + 1, sum + arr[L], arr); // �����е�� Ȯ��!  O(����)
			DFS(L + 1, sum, arr); // X(������)
		} 
	}

	public static void main(String[] args) throws IOException {
		S801 S = new S801();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			total += arr[i];
		}

		S.DFS(0, 0, arr); // (int L, int sum, int[] arr)
		System.out.println(answer);

	}

}
