import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num_str = sc.nextLine();
        String[] num_lst = num_str.split(" ");
        int[] num_arr = Arrays.stream(num_lst).mapToInt(Integer::parseInt).toArray();
        Arrays.parallelSetAll(num_arr, i -> num_arr[i]*num_arr[i]);
        int sum = Arrays.stream(num_arr).sum();
        int result = (sum % 10);
        System.out.println(result);
    }
}