package Inflearn.Section1;

import java.io.*;

public class S13 {//문장 속에서 제일 긴 단어 찾기 (같은 길이의 단어 있는 경우 먼저 나온 단어 출력!)
	public String solution(String str) {
		String answer = ""; 
		
		// 방법1
		String[] s = str.split(" ");
		int max = 0;
		
		for(int i = 0; i<s.length; i++) {
			if(s[i].length() > max) {// >= 사용하면 같은 길이의 단어 있는 경우 뒤에 나온 단어 출력!
				max = s[i].length();
				answer = s[i];
			}
		}
		
		// 방법2
		/*for(String x : s) {
			if(x.length() > answer.length()) {
				answer = x;
			}
		}*/
		return answer;
	}
	

	public static void main(String[] args) throws IOException {
		S13 S = new S13();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		System.out.print(S.solution(str));
		

	}

}
