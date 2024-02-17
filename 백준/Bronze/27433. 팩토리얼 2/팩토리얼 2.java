import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long input = Long.parseLong(br.readLine());
        long sum = factorial(input);

        System.out.println(sum);

    }

    public static long factorial(long num) {
        if(num == 0) {
            return 1;
        } else {
            return num * factorial(num -1);
        }
    }
}
