package Inflearn.Section2;

import java.io.*;
import java.util.*;

public class S08 {
	public int[] solution(int n, int[] arr) {
		int[] answer = new int[n];
				
		for(int i = 1; i<n; i++) {
			if(arr[i] > arr[i-1]) {
				
			}
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

		System.out.println(S.solution(n, arr));

	}

}
