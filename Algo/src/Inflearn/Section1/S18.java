package Inflearn.Section1;

import java.io.*;

public class S18 {// �Ӹ���� : �տ��� ���� ���� �ڿ��� ���� ���� ���ڿ��� ���� ���� �ǹ�!
	public String solution(String str) {
		String answer = "NO";

		str = str.toLowerCase().replaceAll("[^a-z]", "");
		/* replace(), replaceAll(): Ư�� ���ڿ��� ���ϴ� ���ڿ��� ġȯ�ϴ� �޼ҵ�!
		    1) replace(): ���ڿ��� ��ȯ ����
		    2) replaceAll(): ���Խ� ��� ����
		         ���Խ� ->���ڿ����� Ư�� ������ ã�ų� ��ü, �����ϴ� �� ���ڿ��� ���ϴ� ���·� �����ϴ� ��� ����!
		  */	 
		String tmp = new StringBuilder(str).reverse().toString();
		/* StringBuilder(): String�� �޸� ������ �߰�,������ ����! 
		                   ~> �ν��Ͻ��� ������ �ּ��� �����ν� ���� ��� 
		                   (String�� ���� �߰�,���� �� ���ο� ��ü ���� -> ���� ���� �� ������ �߻�)
		   toString(): ����� ���ڿ��� ������ ���� String �ν��Ͻ��� ���� �� ��ȯ */
		
		if(str.equals(tmp)) {
			answer = "YES";
		}
			
			
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S18 S = new S18();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		System.out.println(S.solution(str));

	}

}
