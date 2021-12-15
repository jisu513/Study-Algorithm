package Inflearn.Section1;

import java.io.*;
import java.util.*;

public class S11 {//문자열 압축
	public String solution(String str){
		String answer = "";
		
		str = str+" ";
		//for문에서 i번째와 i+1번째를 비교 -> 마지막 문자 비교할 때 outOf~~ 예외를 방지하기 위해서 공백 추가!
		char[] c = str.toCharArray();
 		int cnt=1;
		for(int i=0; i<str.length()-1; i++) { //원래 문자는 str.length()-1까지임! 
			if(c[i] == c[i+1]) {
				cnt++;
			}else {
				answer += c[i];
				if(cnt>1) {//문자가 하나 있을 때는 숫자 표현할 필요X 
					answer += String.valueOf(cnt);
				}
				cnt=1;
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S11 S = new S11();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		System.out.println(S.solution(str));

	}

}
