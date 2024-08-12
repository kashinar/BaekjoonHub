import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long A,B,C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(calc(A, B));
    }

    public static long calc(long base, long exponent) {
        if(exponent == 1) {
            return base % C; //base^0 = 1
        }

        long temp = calc(base, exponent / 2);
        temp = (temp * temp) % C;

        if(exponent % 2 == 1) {
            temp = (temp * base) % C;
        }

        return temp;
    }
}
