package Inflearn.Section1;

import java.io.*;
import java.util.*;

public class S05 { //특정 문자 뒤집기!(문자가 알파벳이 경우만 뒤집기!)
	public String solution(String str) {
		String answer = "";

		char[] c = str.toCharArray();
		int lt = 0;
		int rt = str.length() - 1;

		while (lt < rt) {
			if (!Character.isAlphabetic(c[lt])) { //알파벳이 아닌경우 lt의 위치만 이동
				lt++;
			} else if (!Character.isAlphabetic(c[rt])) { //알파벳이 아닌경우 rt의 위치만 이동
				rt--;
			} else {
				char tmp = c[lt];
				c[lt] = c[rt];
				c[rt] = tmp;
				lt++;
				rt--;
			}
		}
		answer = String.valueOf(c);
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S05 S = new S05();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		System.out.println(S.solution(str));

	}

}
