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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        fee = new int[N + 1];
        car = new int[M + 1];
        charge = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        sales = 0;

        // 요금 및 자동차 무게 설정
        for (int i = 1; i <= N; i++) fee[i] = Integer.parseInt(br.readLine());
        for (int i = 1; i <= M; i++) car[i] = Integer.parseInt(br.readLine());

        for (int i = 0; i < 2 * M; i++) {
            int move = Integer.parseInt(br.readLine());

            if (move > 0) { // 주차
                if (charge.size() < N) {
                    for (int j = 1; j <= N; j++) {
                        if (!charge.containsKey(j)) {
                            charge.put(j, move);
                            break;
                        }
                    }
                } else {
                    queue.add(move);
                }
            } else { // 출차
                int key = out(Math.abs(move));
                if (key != -1 && !queue.isEmpty()) {
                    charge.put(key, queue.poll());
                }
            }
        }

        System.out.println(sales);
    }

    public static int out(int carNum) {
        for (Map.Entry<Integer, Integer> entry : charge.entrySet()) {
            if (entry.getValue() == carNum) {
                sales += car[carNum] * fee[entry.getKey()];
                charge.remove(entry.getKey());
                return entry.getKey();
            }
        }
        return -1;
    }
}