import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int cnt = 0;
        int length = 1;
        int div = 10;

        if(num < 10) {
            System.out.println(num);
            return;
        }

        for(int i = 1; i <= num; i++) {
            //자릿수가 바뀌는 순간
            if(i % div == 0) {
                length++;
                div *= 10;
            }
            cnt += length;
        }

        System.out.println(cnt);
    }
}
