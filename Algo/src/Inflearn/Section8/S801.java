package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S801 { // ���� ���� �κ�����
	static String answer = "NO";
	static int n, total = 0;
	boolean flag = false; // answer = "YES" �� �߰ߵ��� �� �� ���� ��͵��� ��� return ��Ű�� ���� �ϳ��� ��ġ

	public void DFS(int L, int sum, int[] arr) {
		if(flag) {
			return;
		}
		if(sum > total/2) { // �� �غ� �ʿ� ���� answer = NO (�� �κ������� ���� ���� ���� �����Ƿ�)
			return;
		}
		if (L == n) { // �ε����� n-1������ --> L==n�� �� ** �κ� ���� �ϼ� ** 
			if ((total - sum) == sum) { // total�� arr�� ����, sum�� �κ������� ��
				answer = "YES"; 
				flag = true;
			}
		} else { // �κ� ���� ���ϱ�
			DFS(L + 1, sum + arr[L], arr); // arr[L] ����
			DFS(L + 1, sum, arr); // arr[L] ������
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
