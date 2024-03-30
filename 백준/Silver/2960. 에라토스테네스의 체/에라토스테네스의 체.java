import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int num = Integer.parseInt(input[0]);
        int count = Integer.parseInt(input[1]);
        Sieve(num, count);
    }

    //에라토스테네스의 채
    public static void Sieve(int N, int K) {
        //1. 2부터 N까지의 모든 정수를 적는다.
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 2; i <= N; i++) {
            list.add(i);
        }

        //현재의 카운트를 셈
        int cnt = 1;

        //4. 아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
        while(!list.isEmpty()){
            //2. 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이를 P라고 하고 이 수는 소수이다.
            int P = Collections.min(list);

            //3. P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
            int multi = 2;
            int current = P;

            while(true) {
                //현재 값이 비교값보다 커지면 while문을 빠져나옴
                if(current > N) {
                    break;
                }

                //현재 값이 리스트에 없으면 다음을 찾으러 감
                if(!list.contains(Integer.valueOf(current))) {
                    //배수를 대입
                    current = P * multi;
                    //배수 크기의 증가
                    multi++;
                } else {
                    //리스트에서 현재 값을 제거
                    list.remove(Integer.valueOf(current));

                    //카운트가 입력번째와 같아졌을때의 제거된 값을 출력
                    if(cnt == K) {
                        System.out.println(current);
                        return;
                    }

                    //배수를 대입
                    current = P * multi;
                    //배수 크기의 증가
                    multi++;
                    //카운트 증가
                    cnt++;
                }
            }
        }
    }
}
