package Inflearn.Section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S69 { // �������� (�����˰���) -> dvd �ּҿ뷮 ���ϱ�
	public int count(int[] arr, int capacity) {
		int cnt=1, sum=0;
		for(int x : arr) {
			if(sum +x > capacity) {
				cnt++;
				sum = x;
			}else {
				sum += x;
			}
		}
		return cnt;
		
	}

	public int solution(int n, int m, int[] arr) {
		int answer = 0;

		/*
		 * ���� �˰��� : �̺а˻��� �̿��ϴ� �˰��� Stream : �迭 �Ǵ� �÷����� �ν��Ͻ��� �Լ� ���� ���� �����ؼ� ���ϴ� �����
		 * ���͸��ϰ� ������ ����� ���� �� ���� --> �迭�� �÷����� �Լ������� ó�� ���� (���ٸ� �̿��ؼ� �ڵ带 �����ϰ� ǥ���ϴ� �͵� ����)
		 * �迭 ��Ʈ��) Arrays.stream() �޼ҵ� ��� https://wakestand.tistory.com/419 �����ؼ� ����!
		 */

		int lt = Arrays.stream(arr).max().getAsInt();
		int rt = Arrays.stream(arr).sum();

		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			if(count(arr, mid) <= m) {
				answer = mid;
				rt = mid -1;
			}else {
				lt = mid +1;
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S69 S = new S69();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(S.solution(n, m, arr));

	}

}
