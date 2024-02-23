import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int counter = Integer.parseInt(br.readLine());
        int sum = p(counter);

        System.out.println(sum);
    }

    public static int p(int cnt) {
        if(cnt == 0) {
            return 0;
        }

        if(cnt == 1) {
            return 1;
        }

        return p(cnt-1) + p(cnt-2);
    }
}
