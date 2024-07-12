

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        String[] sizes = br.readLine().split(" ");

        for (String size : sizes) {
            list.add(Integer.parseInt(size));
        }

        String[] TP = br.readLine().split(" ");
        double T = Double.parseDouble(TP[0]);
        int P = Integer.parseInt(TP[1]);

        for (int i = 0; i < list.size(); i++) {
            list.set(i, Integer.valueOf((int) Math.ceil(Double.valueOf(list.get(i)) / T )));
        }

        int mok = N / P;
        int namuge = N - mok * P;

        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }

        System.out.println(sum);
        System.out.println(mok + " " + namuge);
    }
}
