package Inflearn.Section6;

import java.io.*;
import java.util.StringTokenizer;

public class S61 {// ���� ����
	public int[] solution(int n, int[] arr) {
		
		/* ��������: ���� ���� ��Һ��� ������ �˸��� ��ġ�� �Űܼ� ������� �����ϴ� �˰���!
		   �ð����⵵ = O(N*N) --> ��ȿ����
		 */
		
		for (int i = 0; i < n -1 ; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[min]; // arr[i]�� �ּڰ��� arr[min]���� swap!
			arr[min] = tmp;
		}
		return arr;
	}

	public static void main(String[] args) throws IOException {
		S61 S = new S61();

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
