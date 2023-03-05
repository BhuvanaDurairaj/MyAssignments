package week1.day1;

public class IsPrime {

	public static void main(String[] args) {
		int n = 15;
		
		for (int i = 2; i <n-1; i++) {
			if (n%i == 0) {
				System.out.println("The given number" + n + "is a prime number" );			
				}
		else {
			System.out.println("The given number" + n + "is a non prime number");

	}
		}
}}
