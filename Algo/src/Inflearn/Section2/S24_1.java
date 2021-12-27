package Inflearn.Section2;

import java.io.*;


public class S24_1 {// �Ǻ���ġ ����
	public int[] solution(int n) {
		int[] answer = new int[n];
		
		// �迭 ����ؼ� �ذ��� ���
		answer[0] = 1;
		answer[1] = 1;
		
		for(int i = 2; i<n; i++) {
			answer[i] = answer[i-1] + answer[i-2];
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S24_1 S = new S24_1();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int x : S.solution(n)) {
			System.out.print(x + " ");
		}

	}

}
