package logTraffic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeSet;

public class LogTrafficMain {

	public static void main(String[] args) {
		
		// log.txt파일을 읽어서 트래픽의 합계 출력해보기 
		// 1. log.txt파일의 내용을 줄 단위로 읽을 수 있는 객체를 생성 
		// 파일의 경로가 맞으면 아무런 메세지가 출력되지 않고 
		// 파일의 경로가 틀리면 FileNotFoundException발생 
		
	    try(BufferedReader br = 
	    		new BufferedReader(new FileReader("/Users/a503-22/Downloads/log.txt"))){   
			//합계를 저장할 변수 
	    	   int sum =0;
	    	   TreeSet<String> set = new TreeSet<>();
	    	// 문자열을 전부 읽어서 출력 
				while(true) {
					// 한 줄을 읽기 
					String line = br. readLine();
					// 더 이상 읽은 것이 없으면 종료  
					if( line == null) {
						break;
					}
					// System.out.printf("%s\n", line);
					// 읽어온 줄을 공백을 기준으로 분할해서
					// 마지막 데이터 출력 
					String[] data = line.split(" ");
				/*
					System.out.printf("%s\n",
							data[data.length-1]);
			   */
					// 마지막 데이터를 정수로 변환해서 출력 
					int traffic = Integer.parseInt(data[data.length-1]);
		//			System.out.printf("%d\n", traffic);
					sum = sum + traffic;
					//셋에 아이피를 삽입 - 중복된 데이터는 삽입하지 않음 
					set.add(data[0]);
				}
				System.out.printf("트래픽 합계:%d\n", sum);	
				System.out.printf("IP 개수:%d\n", set.size());	
				for(String ip : set) { 
				    System.out.printf("%s\n", ip);
				}
				
			} catch(Exception e1) {
				System.out.printf("%s\n", e1.getMessage());
			}
	   

	}

}
