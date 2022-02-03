package Inflearn.Section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S58 {
	public int solution(int n, int m, int[] arr) {
		int answer = 0;
		
		Queue<Integer> q = new LinkedList<>();
		for(int x : arr) {
			q.offer(x);
		}
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S58 S = new S58();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(S.solution(n, k, arr));

	}

}
