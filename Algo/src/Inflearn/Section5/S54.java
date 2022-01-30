package Inflearn.Section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S54 {// 후위식 연산
	public int solution(String s) {
		int answer = 0;

		Stack<Integer> sk = new Stack<>();
		for (int x : s.toCharArray()) {
			if (Character.isDigit(x)) {
				sk.push(x - 48);
				//문자를 숫자로 변환하려면 48을 빼주면 됨!(48은 '0'(문자 0)의 아스키코드))
			}else {
				int rt = sk.pop();
				int lt = sk.pop();
				if(x == '+') {
					sk.push(lt + rt);
				}else if(x == '-') {
					sk.push(lt - rt);
				}else if(x == '*') {
					sk.push(lt * rt);
				}else if(x == '/') {
					sk.push(lt/rt);
				}
			}
		}
		answer = sk.get(0); //수행하고나면 최종적으로 스택에는 하나의 값만 있으므로 0번 인덱스 get
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S54 S = new S54();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		System.out.println(S.solution(s));

	}

}
