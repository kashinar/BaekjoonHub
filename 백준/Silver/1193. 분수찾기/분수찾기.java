import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int cnt = 0;
        int index = 1;
        int numerator = 0;
        int denominator = 0;
        while(cnt < x) {
            cnt = cnt + index;
            index++;
        }

        if((index-1) % 2 == 0) {
            denominator = 1 + (cnt - x);
            numerator = (index-1) - (cnt-x);
        } else {
            denominator = (index -1) - (cnt - x);
            numerator = 1 + (cnt - x);
        }

        System.out.println(numerator + "/" + denominator);
    }
}
