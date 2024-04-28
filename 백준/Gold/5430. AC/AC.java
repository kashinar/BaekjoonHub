import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static ArrayList<Integer> intStr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        Deque<Integer> dq;

        //테스트 케이스의 개수
        int T = Integer.parseInt(br.readLine());

        //테스트 케이스 만큼 실행
        for(int i = 0; i < T; i++) {
            //수행할 함수 p
            String[] p = br.readLine().split("");
            //배열에 들어있는 수 n
            int n = Integer.parseInt(br.readLine());
            //배열에 들어있는 정수
            String data = br.readLine();
            String[] dataArr = data.substring(1, data.length()-1).replaceAll("," , " ").split(" ");

            //덱을 초기화
            dq = new LinkedList<>();
            //덱에 데이터 추가
            for(int j = 0; j < dataArr.length; j++) {
                try { dq.add(Integer.parseInt(dataArr[j]));
                } catch (Exception e) {

                }
            }

            int reverseCnt = 0;
            boolean isEmpty = false;

            for(int j = 0; j < p.length; j++) {
                if(p[j].equals("D") && dq.isEmpty()) {
                    System.out.println("error");
                    isEmpty = true;
                    break;
                }
                //반전횟수가 짝수(0포함)일 경우, 원래 순서
                if(p[j].equals("D") && reverseCnt % 2 == 0) {
                    dq.pollFirst();
                }

                //반전횟수가 홀수일 경우, 역순
                if(p[j].equals("D") && reverseCnt % 2 == 1) {
                    dq.pollLast();
                }

                if(p[j].equals("R")) {
                    reverseCnt++;
                }
            }

            //문자열을 격납할 StringBuilder초기화
            sb = new StringBuilder();

            //
            if(!isEmpty) {
                if(reverseCnt % 2 == 0) {
                    sb.append("[");
                    while(!dq.isEmpty()) {
                        sb.append(dq.pollFirst());
                        if(!dq.isEmpty()) {
                            sb.append(",");
                        }
                    }
                    sb.append("]");

                    System.out.println(sb.toString());
                } else {
                    sb.append("[");
                    while(!dq.isEmpty()) {
                        sb.append(dq.pollLast());
                        if(!dq.isEmpty()) {
                            sb.append(",");
                        }
                    }
                    sb.append("]");

                    System.out.println(sb.toString());
                }
            }
        }
    }
}
