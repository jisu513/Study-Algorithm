package Inflearn.Section2;

import java.io.*;
import java.util.*;


public class S02 {// 보이는 학생
	public int solution(int n, int[] arr) {
		int answer = 1; // 맨 앞에 학생은 무조건 보이므로 1부터 시작!
		
		int max = arr[0];
		
		for(int i = 1; i<n; i++) {
			if(arr[i] > max ) {
				answer++;
				max = arr[i];
			}		
		}		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S02 S = new S02();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(S.solution(n, arr));

	}

}
