package java_chobo2.ch14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx {
	
	public static void main(String[] args) {
		
		System.out.println(strList);
		
		String[] StrArr2 = {"aaa", "ddd", "ccc"};
		List<String> strList2 = Arrays.asList(strArr);
		
		Stream<String> strStream1 = Arrays.stream(strArr2);
		Stream<String> strStream2 = strList2.stream();
		
		strStream1.sorted().forEach(System.out::println);
		strStream2.sorted().forEach(System.out::println);
		
		//스트림 특징
		//1. 스트림은 데이터소스로부터 데이터를 읽기만할뿐 변경하지 않는다.
		List<String> list = strList2.stream().sorted().collect(Collectors.toList());
		System.out.println(list);
		
		//2. 스트림은 Iterator처럼 일회용이다.(필요하면 다시 스트림을 생성해야 함)
		// 위 코드에서 strStream1.sorted().forEach(System.out::println);
		
//		long cnt = strStream1.count();
//		System.out.println(cnt);
		
		// 스트림을 다시 생성한 후 적용
		long cnt = Arrays.stream(strArr2).count();
		System.out.println(cnt);
		
		// 지연된 연산(최종 연산 전까지는 중간 연산이 수행되지 않음)
		// 첫번째
		IntStream intStream = new Random().ints(1, 46);
		intStream.distinct().limit(6).sorted()
		.forEach(i->System.out.println(i + ","));
		// 두번째
		System.out.println();
		intStream intStream = new Random().ints(1, 46);
		intStream
		.distinct()
		.limit(6)
		.sorted()
		.forEach(i->System.out.println(i + ","));
		
		Stream<String> strStream = Stream.of("dd,"aaa","CC","cc","b);
		int sum = strStream.parallel()
				   .mapToInt(s -> s.length()).sum();
		System.out.println("sum"+sum);
		
		
	}
	

}
