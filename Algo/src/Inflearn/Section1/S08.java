package Inflearn.Section1;

import java.io.*;

public class S08 {// 팰린드롬 : 앞에서 읽을 때와 뒤에서 읽을 때의 문자열이 같은 것을 의미!
	public String solution(String str) {
		String answer = "NO";

		str = str.toLowerCase().replaceAll("[^a-z]", "");
		/* replace(), replaceAll(): 특정 문자열을 원하는 문자열로 치환하는 메소드!
		    1) replace(): 문자열만 변환 가능
		    2) replaceAll(): 정규식 사용 가능
		         정규식 ->문자열에서 특정 패턴을 찾거나 교체, 삭제하는 등 문자열을 원하는 형태로 편집하는 기능 제공!
		  */	 
		String tmp = new StringBuilder(str).reverse().toString();
		/* StringBuilder(): String과 달리 문자의 추가,삭제가 가능! 
		                   ~> 인스턴스의 생성을 최소함 함으로써 성능 향상 
		                   (String은 문자 추가,수정 시 새로운 객체 생성 -> 성능 저하 및 과부하 발생)
		   toString(): 저장된 문자열의 내용을 담은 String 인스턴스의 생성 및 반환 */
		
		if(str.equals(tmp)) {
			answer = "YES";
		}
			
			
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S08 S = new S08();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		System.out.println(S.solution(str));

	}

}
