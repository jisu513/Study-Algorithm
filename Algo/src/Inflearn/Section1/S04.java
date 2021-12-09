package Inflearn.Section1;

import java.io.*;
import java.util.*;

public class S04 {//입력 받은 단어들 뒤집어서 출력하기
	public ArrayList<String> solution(int n, String[] str){
		ArrayList<String> answer = new ArrayList<>();
		
		// 방법1)모든 문자를 한번에 뒤집음!
		for(String x : str) {
			String tmp = new StringBuilder(x).reverse().toString();
			//toString() : 저장된 문자열의 내용을 담은 String 인스턴스 생성 및 반환!
			answer.add(tmp);
		}
		
		// 방법2) 특정문자만 뒤집음!
		for(String x : str) {
			char[] c = x.toCharArray();
			//toCharArray() : 문자열을 char형 배열로 변환!(공백/개행 문자도 원소에 포함)
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
			// valueOf() : boolean/ double/ float/ int/ char ... 객체를 String 객체러 변환!
			answer.add(tmp);
		}
		return answer;
		
	}

	public static void main(String[] args) throws IOException {
		S04 S = new S04();
		
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
