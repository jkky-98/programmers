import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        
        for (int i=1; i < num+1; i++) {
            String star = "*".repeat(i);
            String blank = " ".repeat(num - i);
            System.out.println(blank + star);
        }
    }
}