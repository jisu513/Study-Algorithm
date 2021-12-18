package Inflearn.Section2;

import java.io.*;
import java.util.*;

public class S06 {
	public ArrayList<Integer> solution(int n, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S06 S = new S06();

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
