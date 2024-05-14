import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] burger = br.readLine().split("");
        boolean[] status = new boolean[N];

        for(int i = 0; i < status.length; i++) {
            if(burger[i].equals("H")) {
                status[i] = true;
            }
        }

        int cnt = 0;

        for(int i = 0; i < burger.length; i++) {
            if(burger[i].equals("P")) {
                int start;
                int end;

                //시작점이 배열을 넘어가는 상황 방지
                if(i - K >= 0) {
                    start = i - K;
                } else {
                    start = 0;
                }

                //끝점이 배열을 넘어가는 상황 방지
                if(i + K <= burger.length - 1) {
                    end = i + K;
                } else {
                    end = burger.length - 1;
                }

                while(true) {
                    //시작 지점에 햄버거가 있다면, 먹고 카운트업 후 탐색 종료
                    if(status[start]) {
                        status[start] = false;
                        cnt++;
                        break;
                    } else {
                        //햄버거가 없는 위치(사람이거나 이미 먹었거나)일 경우
                        //시작점과 끝점이 같지 않을 경우 한칸 이동해서 재탐색
                        if(start != end) {
                            start++;
                        } else {
                            //시작과 끝이 같은 지점까지 왔으면 햄버거가 없는 구간이므로 종료
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
