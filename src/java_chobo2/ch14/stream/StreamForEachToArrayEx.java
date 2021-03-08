package java_chobo2.ch14.stream;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamForEachToArrayEx {

	public static void main(String[] args) {
		IntStream.range(1,  10).sequential().forEach(new IntConsumer() {
			@Override
			public void accept(int value) {
				System.out.print(value);
			}
		});
		System.out.println();
//		
//		IntStream.range(1, 10).parallel().forEach(System.out::print);
//		System.out.println();
		
		// 람다식으로 바꾸는 방법  19번 줄에서 22번줄처럼 변환
		IntStream.range(1, 10).parallel().forEach(e -> System.out.print(e));
		System.out.println();
		
		IntStream.range(1,10).parallel().forEachOrdered(System.out::print);
		System.out.println();
		
		Student[] stdArr = {new Student("김인환", 1, 280),
				new Student("이태훈", 1, 270),
				new Student("김상건", 2, 260),
				new Student("전수린", 2, 250),
		};
		
		Stream<Student> studentStream = Arrays.stream(stdArr);
		
		Student[] tempArr = studentStream.toArray(Student[]::new);
		System.out.println(Arrays.toString(tempArr));
		
		studentStream = Arrays.stream(stdArr);
		Object[] objArr = studentStream.toArray();
		System.out.println(Arrays.toString(objArr));

	}

}
