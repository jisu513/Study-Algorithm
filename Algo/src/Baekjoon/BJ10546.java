package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ10546 {

	public static void main(String[] args) throws IOException {

		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, Integer> hm = new HashMap<>(); 
		//String answer = "";
		
		int n = Integer.parseInt(br.readLine());
		
		String s;
		for(int i = 0; i< 2*n -1; i++) {
			s = br.readLine();
			hm.put(s, hm.getOrDefault(s, 0)+1);
		}
		
		//***동명이인이 존재 할 수 있음 --> A1은 완주 다른 A2는 완주 못하는 경우 존재
		for(String x : hm.keySet()) {
			if(hm.get(x) % 2 == 1) { // 2로 나눴을 때 나머지가 1이면 완주 X 
				//answer = x;
				System.out.println(x);
			}
		}
		

	}

}
