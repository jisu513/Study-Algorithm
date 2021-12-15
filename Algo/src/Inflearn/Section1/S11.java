package Inflearn.Section1;

import java.io.*;
import java.util.*;

public class S11 {//���ڿ� ����
	public String solution(String str){
		String answer = "";
		
		str = str+" ";
		//for������ i��°�� i+1��°�� �� -> ������ ���� ���� �� outOf~~ ���ܸ� �����ϱ� ���ؼ� ���� �߰�!
		char[] c = str.toCharArray();
 		int cnt=1;
		for(int i=0; i<str.length()-1; i++) { //���� ���ڴ� str.length()-1������! 
			if(c[i] == c[i+1]) {
				cnt++;
			}else {
				answer += c[i];
				if(cnt>1) {//���ڰ� �ϳ� ���� ���� ���� ǥ���� �ʿ�X 
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
