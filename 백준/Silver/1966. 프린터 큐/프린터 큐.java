import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static int position;
    public static Map<Integer, Integer> print; //순서, 중요도
    public static LinkedList<Map<Integer, Integer>> queue;
    public static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //테스트케이스 받음
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++) {
            //queue 초기화
            queue = new LinkedList<>();

            max = Integer.MIN_VALUE;

            //문서의 갯수 printNum과 찾고자 하는 위치 position를 받음
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int printNum = Integer.parseInt(st.nextToken());
            position = Integer.parseInt(st.nextToken());

            //문서를 받고 맵에 순서와 중요도를 넣음
            String[] printPriority = br.readLine().split(" ");

            for(int j = 0; j < printPriority.length; j++) {
                //Map 초기화
                print = new HashMap<>();

                int printData = Integer.parseInt(printPriority[j]);

                //프린트 데이터의 중요도가 현재 중요도보다 크면 그거로 갱신함
                if(printData >= max) {
                    max = printData;
                }
                //맵에 프린터 대입
                print.put(j, printData);
                queue.add(print);
            }

            //문서의 갯수가 하나면 뭐가 오든 1이므로 1출력하고 종료
            if(printNum == 1) {
                System.out.println(1);
                continue;
            }

            Search();
        }
    }

    public static void Search() {
        int cnt = 0;

        while(true) {
            //가장 첫번째의 키 값을 찾음
            int firstkey = 0;
            for(int key : queue.getFirst().keySet()) {
                firstkey = key;
                break;
            }

            int priority = queue.getFirst().get(firstkey);

            if(priority < max) {
                //맨뒤로 보내고 삭제
                Map<Integer, Integer> change = queue.pollFirst();
                queue.add(change);
            } else {
                //출력
                Map<Integer, Integer> printOut = queue.poll();

                //출력했으니 카운트+1
                cnt++;

                //출력한 값의 키 값을 확인
                int printKey = 0;
                for(int key : printOut.keySet()) {
                    printKey = key;
                    break;
                }

                //출력한 값의 위치(키 값)이 내가 찾고자 하는 위치인지 확인
                if(printKey == position) {
                    //맞으면 몇번째인지 출력
                    System.out.println(cnt);
                    break;
                }

            }

            //리스트의 최대값을 갱신
            max = Integer.MIN_VALUE;
            for(Map<Integer, Integer> map : queue) {
                for(int value : map.values()) {
                    if(value > max) {
                        max = value;
                    }
                }
            }
        }
    }
}
