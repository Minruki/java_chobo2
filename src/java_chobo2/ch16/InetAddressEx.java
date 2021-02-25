package java_chobo2.ch16;

import java.net.InetAddress;
import java.rmi.UnknownHostException;
import java.util.Arrays;

public class InetAddressEx {

	public static void main(String[] args) throws java.net.UnknownHostException, UnknownHostException {
		InetAddress ip = null;
		InetAddress[] ipArr = null;

		ip = InetAddress.getByName("www.naver.com");
		System.out.println("GetHostName() :" + ip.getHostName());
		System.out.println("GetHostAddress() :" + ip.getHostAddress());
		System.out.println("toString() :" + ip.toString());

		byte[] ipAddr = ip.getAddress();
		System.out.println("getAddress() :" + Arrays.toString(ipAddr));

		String result = " ";
		for (int i = 0; i < ipAddr.length; i++)
			result += (ipAddr[i] < 0 ? ipAddr[i] + 256 : ipAddr[i]) + ".";
		System.out.println("getAddress()+256 :" + result);
		System.out.println();

		try {
			ip = InetAddress.getLocalHost();
			System.out.println("GetHostName() :" + ip.getHostName());
			System.out.println("GetHostAddress() :" + ip.getHostAddress());
			System.out.println();

		} catch (java.net.UnknownHostException e) {
			e.printStackTrace();
		}

		try {
			ipArr = InetAddress.getAllByName("www.naver.com");

			for (int i = 0; i < ipArr.length; i++)
				System.out.println("ipArr[+i+] :" + ipArr[i]);

		} catch (java.net.UnknownHostException e) {
			e.printStackTrace();
		}

	}
}
