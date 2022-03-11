package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ10816_1 {// 숫자 카드2 (이진탐색 or 해시맵 사용)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		// 해시맵 사용해서 풀기
		HashMap<Integer, Integer> hm = new HashMap<>();

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			hm.put(num, hm.getOrDefault(num, 0) + 1);
		}

		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int check = Integer.parseInt(st.nextToken());
			
			sb.append(hm.getOrDefault(check, 0)).append(" ");

		}
		
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();

	}

}
