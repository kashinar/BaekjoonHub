import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //수의 개수 N, 합을 구해야하는 횟수 M
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        //N개의 수
        int[] numArr = new int[N + 1];
        String[] strArr = br.readLine().split(" ");
        for(int i = 1; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i-1]);
        }

        //누적합 배열
        int[] sum = new int[N + 1];
        for(int i = 1; i < numArr.length; i++) {
            if(i == 1) {
                sum[i] = numArr[i];
            } else {
                sum[i] = sum[i-1] + numArr[i];
            }
        }
        
        //계산
        for(int i = 0; i < M; i++) {
            String[] calArr = br.readLine().split(" ");
            int start = Integer.parseInt(calArr[0]);
            int end = Integer.parseInt(calArr[1]);

            if(start != end) {
                System.out.println(sum[end] - sum[start-1]);
            } else if(start == end) {
                //시작과 끝이 같으면 그냥 index값을 출력
                System.out.println(numArr[start]);
            }
        }
    }
}
