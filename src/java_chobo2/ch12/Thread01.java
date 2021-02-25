package java_chobo2.ch12;

public class Thread01 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(getName());

		}
	}
}