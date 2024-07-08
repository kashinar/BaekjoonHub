import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int cnt = 0;

        while(target > 0) {
            cnt += target & 1;
            target >>= 1;
        }

        System.out.println(cnt);
    }
}
