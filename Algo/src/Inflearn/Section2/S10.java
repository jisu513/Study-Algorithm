package Inflearn.Section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S10 {//���츮 (�����¿캸�� ū ���ڴ� ���츮)
	public int solution(int n, int[][] arr) {
		int answer = 0;
		//���� �迭 ���� ����!
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		
		return answer;
	}
	public static void main(String[] args) throws IOException {
		S10 S = new S10();
		
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
