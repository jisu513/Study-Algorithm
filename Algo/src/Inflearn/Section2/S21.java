package Inflearn.Section2;

import java.io.*;
import java.util.*;

public class S21 {//ū �� ����ϱ� (�ڽ��� �ٷ� �� ���ں��� ū ���ڸ�)
	public ArrayList<Integer> solution(int n, int[] num) {
		ArrayList<Integer> answer = new ArrayList<>();
		
		answer.add(num[0]);
		
		for(int i = 1; i<n; i++) {
			if(num[i] > num[i-1]) {
				answer.add(num[i]);
			}
		}
		return answer;
		
	}

	public static void main(String[] args) throws IOException {
		S21 S = new S21();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] num = new int[n];
		for(int i = 0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int x : S.solution(n, num)) {
			System.out.print(x + " ");
		}
		

	}

}
