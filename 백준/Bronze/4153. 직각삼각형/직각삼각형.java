
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] s = br.readLine().split(" ");

            List<Integer> list = new ArrayList<>();

            for (String string : s) {
                list.add(Integer.parseInt(string));
            }

            Collections.sort(list);

            int operand1 = list.get(0);
            int operand2 = list.get(1);

            if (operand1 == 0 && operand2 == 0 && list.get(2) == 0) {
                break;
            }

            if (operand1 * operand1 + operand2 * operand2 == list.get(2) * list.get(2)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }

        }
    }
}
