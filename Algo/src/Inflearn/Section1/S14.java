package Inflearn.Section1;

import java.io.*;
import java.util.*;

public class S14 {//�Է� ���� �ܾ�� ����� ����ϱ�
	public ArrayList<String> solution(int n, String[] str){
		ArrayList<String> answer = new ArrayList<>();
		
		// ���1)��� ���ڸ� �ѹ��� ������!
		for(String x : str) {
			String tmp = new StringBuilder(x).reverse().toString();
			//toString() : ����� ���ڿ��� ������ ���� String �ν��Ͻ� ���� �� ��ȯ!
			answer.add(tmp);
		}
		
		// ���2) Ư�����ڸ� ������!
		for(String x : str) {
			char[] c = x.toCharArray();
			//toCharArray() : ���ڿ��� char�� �迭�� ��ȯ!(����/���� ���ڵ� ���ҿ� ����)
			int lt=0;
			int rt = x.length()-1;
			
			while(lt < rt) {
				char tmp = c[lt];
				c[lt] = c[rt];
				c[rt] = tmp;
				lt++;
				rt--;
			}
			String tmp = String.valueOf(c);
			// valueOf() : boolean/ double/ float/ int/ char ... ��ü�� String ��ü�� ��ȯ!
			answer.add(tmp);
		}
		return answer;
		
	}

	public static void main(String[] args) throws IOException {
		S14 S = new S14();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str = new String[n];
		
		for(int i = 0; i<n; i++) {
			str[i] = br.readLine();
		}
		
		for(String x : S.solution(n, str)) {
			System.out.println(x);
		}

	}

}
