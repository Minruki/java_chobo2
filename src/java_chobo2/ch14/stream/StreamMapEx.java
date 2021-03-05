package java_chobo2.ch14.stream;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamMapEx {

	public static void main(String[] args) {
//		extracted();
		
		IntStream intStream = new Random()ints(1,46);
		Stream<Integer> integerStream = intStream.boxed();
		integerStream.limit(6).forEach(System.out::println);
		
		Stream<String> lottoStream = new Random().ints(1,46)
				.distinct().limit(6).sorted()
				.mapToObj(i -> i + " , ");
		lottoStream.forEach(System.out::print);
		
		
		
		List<Student> list = new ArrayList<>();
		list.add(new Student("이자바", 3, 300));
		list.add(new Student("김자바", 1, 200));
		list.add(new Student("안자바", 2, 100));
		list.add(new Student("박자바", 2, 150));
		list.add(new Student("이자바", 3, 300));
		list.add(new Student("이자바", 3, 300));
		
		Stream<Student>stdStream = list.stream();
		
		Stream<Integer>stdScoreStream = stdStream.flatMap(Student::getTotalScore);
		int total = stdScoreStream.reduce(0,(a,b) -> a+b);
		
		
	} //end of main

	private static void extracted() {
		List<File> list = new ArrayList<File>();
		list.add(new File("Ex1.java"));
		list.add(new File("Ex1.bak"));
		list.add(new File("Ex2.java"));
		list.add(new File("Ex1"));
		list.add(new File("Ex1.txt"));
		
		// map()으로 Stream<File>을 Stream<String>으로 변환

		Stream<File> fileStream = list.stream();
		Stream<String> fileNameStream = fileStream.map(File::getName);
		fileNameStream.forEach(System.out::println);
		
		System.out.println();
		list.stream().map(File::getName) // 파일 이름 추출? -> :: 
		.filter(s -> s.indexOf('.') != -1)
		.map(s->s.substring(s.indexOf('.')+1))
		.peek(s->System.out.printf("extends %s%n", s))
		.map(String::toUpperCase)
		.peek(s->System.out.printf("upper %s%n", s))
		.distinct()
		.forEach(System.out::print);
		
		System.out.println();
		
		//set은 중복을 허용하지 않음
		Set<String> s = new HashSet<>();
		for(File f : list) {
			String ext = f.getName();
			if(ext.indexOf('.') !=  -1) { // -1이 아니라면
			s.add( ext.substring(ext.indexOf('.')+1).toUpperCase() );
			}
				
			
		}
		System.out.println(s);
		File file = new File("test.java");
		String fileName = file.getName(); // "test.java"
		int idx = fileName.indexOf("."); // 4
		System.out.println(fileName + " : " + idx);
		System.out.println(fileName.substring(idx+1));
	}

}
