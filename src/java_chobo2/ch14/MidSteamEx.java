package java_chobo2.ch14;

import java.util.Comparator;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MidSteamEx {

	public static void main(String[] args) {
		// 중간연산
		// 1. skip(), limit()
//		extracted01();

		
		Stream<Student> stdStream = Stream.of(
				new Student("이자바, 3, 200"),
				new Student("김자바, 1, 150"),
				new Student("안자바, 2, 300"),
				new Student("박자바, 2, 120"),
				new Student("소자바, 1, 300"),
				new Student("나자바, 3, 290"),
				new Student("감자바, 3, 180")
			);
		
		stdStream.sorted(Comparator.comparing(Student ::getBan)
				.thenComparing(Comparator.naturalOrder()))
		_
				
		//sorted
		Stream<String> strStream = Stream.of("dd", "aaa"," CC", "cc", "Studnet::getBan");
		
		strStream.sorted().forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		Stream.of("dd", "aaa"," CC", "cc", "b");
		.sorted(String::compareTo);
		.forEach(s->System.out.print(s+" "));
		System.out.println();
	}
		
		Stream.of("dd", "aaa"," CC", "cc", "b")
		.sorted(Comparator.naturalOrder())
		.forEach(s->System.out.print(s+" "));
		System.out.println();
		
		Stream.of("dd", "aaa"," CC", "cc", "b")
		.sorted(String.CASE_INSENSITIVE_ORDER)
		.forEach(s->System.out.print(s+" "));
		System.out.println();
		
		
		
		IntStream.rangeClosed(1, 20)
		.filter(i -> i % 2 == 0)
		.filter(i -> i % 3 == 0)
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		
		
		IntPredicate test = new IntPredicate() {

			@Override
			public boolean test(int value) {
				
				return value % 2 == 0;
			}
			
		};
		
		IntPredicate p = t -> t%2 == 0;
		IntStream.rangeClosed(1, 20)
		.filter(p)
		.forEach(s->System.out.print(s+ " "));
		System.out.println();
		
		}

	private static void extracted01() {
		System.out.println("중간 연산 - skip), distinct()");
		IntStream.rangeClosed(1, 10)
		.skip(3)
		.limit(5)
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		//2. filter, distinct()
		System.out.println("중간 연산 - filter(), distinct()");
		IntStream.of(1, 2, 2, 3, 3, 3, 4, 5, 5, 5)
		.distinct()
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
	}

	}


