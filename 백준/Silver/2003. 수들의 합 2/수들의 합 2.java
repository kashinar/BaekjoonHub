import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] num =  new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int left = 0;
        int right = 0;
        int cnt = 0;

        while(right <= n) {
            if(sum >= m) {
                //더한 값이 구하고자 하는 값보다 클 경우
                //왼쪽으로 한칸씩 움직여서 앞선 값을 빼줌
                sum -= num[left++];
            } else if (sum < m) {
                //더한 값이 구하고자 하는 값보다 작을 경우
                //오른쪽으로 움직여서 값을 더 추가해줌
                sum += num[right++];
            }

            if(sum == m) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
