package Inflearn.Section2;

import java.io.*;
import java.util.*;

public class S08 {// ������ϱ�
	public int[] solution(int n, int[] arr) {
		int[] answer = new int[n];

		int cnt;

		// ���� for�� ���!
		for (int i = 0; i < n; i++) {//���� arr[]
			cnt = 1;
			for (int j = 0; j < n; j++) {//�񱳵Ǵ� arr[]
				if (arr[j] > arr[i]) {
					cnt++;
				}
			}
			answer[i] = cnt;
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S08 S = new S08();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for(int x : S.solution(n, arr)) {
			System.out.print(x + " ");
		}

	}

}
