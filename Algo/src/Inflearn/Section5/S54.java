package Inflearn.Section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S54 {// ������ ����
	public int solution(String s) {
		int answer = 0;

		Stack<Integer> sk = new Stack<>();
		
		for(char x : s.toCharArray()) {
			if(Character.isDigit(x)) {
				sk.push(x - 48);
				//���� Ÿ���� ����(char)�� ���� Ÿ��(int)���� �ٲٷ��� 48�� �����! ('0'(���� 0)�� �ƽ�Ű�ڵ尡 48!)
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
					sk.push(lt / rt);
				}
			}
		}
		
		answer = sk.get(0); //for���� �����ϰ��� ���������� ���ÿ��� �ϳ��� ���� �����Ƿ� 0�� �ε��� get
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S54 S = new S54();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		System.out.println(S.solution(s));

	}

}
