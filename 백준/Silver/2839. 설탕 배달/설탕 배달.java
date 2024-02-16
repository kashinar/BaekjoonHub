import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int suger = Integer.parseInt(br.readLine());
        int cnt = 0;

        while(true) {
            if(suger % 5 == 0 && suger > 0) {
                suger = suger - 5;
                cnt++;
                continue;
            }

            if(suger % 3 == 0 && suger > 0) {
                suger = suger - 3;
                cnt++;
                continue;
            }

            if(suger >= 5) {
                suger = suger - 5;
                cnt++;
                continue;
            }

            if (suger >= 3) {
                suger = suger - 3;
                cnt++;
                continue;
            }

            if(suger == 0) {
                System.out.println(cnt);
                return;
            } else {
                System.out.println(-1);
                return;
            }

        }

    }
}
