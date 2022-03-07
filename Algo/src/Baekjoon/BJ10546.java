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
		
		//***���������� ���� �� �� ���� --> A1�� ���� �ٸ� A2�� ���� ���ϴ� ��� ����
		for(String x : hm.keySet()) {
			if(hm.get(x) % 2 == 1) { // 2�� ������ �� �������� 1�̸� ���� X 
				//answer = x;
				System.out.println(x);
			}
		}
		

	}

}
