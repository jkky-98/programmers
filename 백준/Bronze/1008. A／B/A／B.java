import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        double A, B, C;
        A = sc.nextDouble();
        B = sc.nextDouble();
        sc.close();
        C = A / B;
        System.out.println(C);
	}
}