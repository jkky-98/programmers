
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            int item = Integer.parseInt(s);
            list.add(item);
        }

        Integer max = Collections.max(list);
        int index = list.indexOf(max);
        System.out.println(max);
        System.out.println(index + 1);
    }
}
