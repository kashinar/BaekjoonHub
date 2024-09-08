import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] fee;
    static int[] car;
    static Map<Integer, Integer> charge;
    static int sales;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //주차 구역당 차량 무게를 받는 N
        int M = Integer.parseInt(st.nextToken()); //차량의 무게를 나타내는 M

        fee = new int[N + 1];
        car = new int[M + 1];

        //구역당 요금 설정
        for (int i = 1; i <= N; i++) {
            String input_fee = br.readLine();
            fee[i] = Integer.parseInt(input_fee);
        }

        //자동차 무게 값
        for (int i = 1; i <= M; i++) {
            String input_car = br.readLine();
            car[i] = Integer.parseInt(input_car);
        }

        charge = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>(); //자동차 대기열을 위한 큐
        sales = 0; //매출

        //자동차는 한번씩 들어오고 한번씩 나가므로, M의 2배만큼 반복
        for (int i = 0; i < 2 * M; i++) {
            int move = Integer.parseInt(br.readLine()); //자동차의 움직임

            //대기중인 차가 있는가 없는가
            if (!queue.isEmpty()) {
                //다음이 주차인가 출차인가
                if (move > 0) {
                    //대기중인 차가 있는데 주차하러 온거면 빈자리 없다는 뜻이므로 대기열에 등록
                    queue.add(move);
                } else {
                    //출차라면 출차처리하고, 대기열의 자동차를 거기로 다시 집어넣음
                    int key = out(move);
                    int next = queue.poll();
                    charge.put(key, next);
                }
            } else {
                //다음이 주차인가 출차인가
                if(move > 0) {
                    //주차공간이 꽉차있지 않은가?
                    if(charge.size() == N) {
                        //꽉차있으면 대기열로
                        queue.add(move);
                    } else {
                        //주차공간이 비어있을 경우는 주차 (주차 공간 N만큼 확인)
                        for (int j = 1; j <= N; j++) {
                            //빈자리 발견하면 자동차를 주차
                            if (!charge.containsKey(j)) {
                                charge.put(j, move);
                                break;
                            }
                        }
                    }
                } else {
                    //주차공간이 비어있으므로, 후속동작 필요 없음
                    out(move);
                }
            }
        }

        System.out.println(sales);
    }

    public static int out(int num) {
        int abs_move = Math.abs(num); //출차 처리를 위한 절댓값
        for (int key : charge.keySet()) {
            //차동차를 찾는 과정
            if (charge.get(key) == abs_move) {
                //해당 주차장에 출차하려는 자동차가 있으면..
                sales += car[abs_move] * fee[key];
                charge.remove(key); //출차처리
                return key; //빈 주차 공간의 정보값을 return
            }
        }

        return -1;
    }
}
