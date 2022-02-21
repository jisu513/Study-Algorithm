package Inflearn.Section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S62 {//��������
	public int[] solution(int n, int[] arr) {
		
		/*���� ����: �̿��� �� ����� ��Ұ��踦 ���Ͽ� ��ȯ�ϸ� �����ϴ� �˰���
		 �ð����⵵ = O(N*N) 
		   --> ��������, �������İ� ���� ���⵵�� �������� ���� ���� ���� ���� ��������� ���� ������ ��ȿ����!*/
		
		for(int i = 0; i<n-1; i++) { 
			for(int j = 0; j<n-1-i; j++) { 
				// **j ���� �߿�** ������ index�� ���� �Ǿ� �����Ƿ� n-1 ����! �׸��� iī Ŀ������ ��Ƚ�� �������Ƿ� (n-1)-i!
				if(arr[j] > arr[j+1]) { // �̿��� �� ��� �� --> j�� j+1 ��!
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}				
			} // for-j �� ���� ���� ���ؼ� �ִ� �������� ����!
		}
		return arr;
		
	}

	public static void main(String[] args) throws IOException {
		S62 S = new S62();

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
