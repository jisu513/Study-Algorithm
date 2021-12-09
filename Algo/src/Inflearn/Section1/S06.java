package Inflearn.Section1;

import java.io.*;
import java.util.*;

public class S06 {//중복된 문자 제거 후 출력
	public String solution(String str) {
		String answer = "";
		
		for(int i = 0; i<str.length(); i++) {
			if(str.indexOf(str.charAt(i)) == i) {
				//indexOf() : char 경우 현재 문자열 객체에서 해당 문자(char c)가 처음 발견된 위치의 index 반환!
				//            String 경우 현재 문자열 객체에서 해당 문자열(String s)을 찾아서 존재하면 문자열의 첫문자의 해당 index 반환!(없으면 -1 반환!) 
				answer += str.charAt(i);
			}
		// i와 str.indexOf()의 번호가 같지 않은 것은 중복된 문자임!
		}
		
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S06 S = new S06();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		System.out.println(S.solution(str));

	}

}
