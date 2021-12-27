package Inflearn.Section1;

import java.io.*;

public class S112 {// 암호
	public String solution(int n, String str) {
		String answer = "";
		
		str = str.replace("#", "1").replace("*", "0");
		//str을 2진수의 모양으로 바꿔줌!
		
		for(int i=0; i<n; i++) {
			String tmp = str.substring(0,7);
			/* subString(begin index, end index): 문자열 자르기! (end index -1 까지 자름!)
			  ()안에 숫자 하나 있으면 그 index부터 마지막 까지 자름! 
			   ex) String s = "abcedf"
			      a = a.subString(0,3) --> 결과 abc
			      a = a.subString(3) --> 결과 def
			*/
			int num = Integer.parseInt(tmp,2);
			//2진수를 10진수로 변환!
			answer += (char)num;
			
			str = str.substring(7);
		}
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S112 S = new S112();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());		
		String str = br.readLine();
		
		System.out.println(S.solution(n, str));

	}

}
