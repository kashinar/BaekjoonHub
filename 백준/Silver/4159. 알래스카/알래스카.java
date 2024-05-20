import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            //주유소의 갯수
            int n = Integer.parseInt(br.readLine());
            String isPossible = "POSSIBLE";

            //0이면 종료
            if(n == 0) {
                break;
            }

            int[] station = new int[n];
            for(int i = 0; i < station.length; i++) {
                station[i] = Integer.parseInt(br.readLine());
            }

            //거리순으로 정렬
            Arrays.sort(station);
            //최대 크기에서 -1 만큼 함
            for(int i = 0; i < station.length-1; i++) {
                if(station[i+1] - station[i] > 200) {
                    isPossible = "IMPOSSIBLE";
                    break;
                }
            }

            //맨 끝점을 찍고 다시 돌아오기 때문에 마지막 주유소까지의 거리가 절반인 100보다 차이가 나면 안된다.
            if(1422 - station[station.length-1] > 100) {
                isPossible = "IMPOSSIBLE";
            }

            System.out.println(isPossible);
        }
    }
}
