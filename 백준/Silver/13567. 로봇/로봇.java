import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); //정사각형의 변의 길이
        int n = Integer.parseInt(st.nextToken()); //오더의 갯수

        //초기 위치
        int currentX = 0;
        int currentY = 0;
        int currenthead = 0;

        Deque<Integer> dq = new LinkedList<>();
        dq.add(0);
        dq.add(1);
        dq.add(2);
        dq.add(3);

        //방향
        String[] head = {"right", "up", "left", "down"};

        for(int i = 0; i < n; i++) {
            //명령어를 읽음
            st = new StringTokenizer(br.readLine());

            String direction = st.nextToken();
            int length = Integer.parseInt(st.nextToken());

            switch(direction) {
                case "MOVE":
                    if(head[currenthead].equals("right")) {
                        //오른쪽일 경우
                        if(currentX + length <= M) {
                            currentX = currentX + length;
                        } else {
                            System.out.println(-1);
                            return;
                        }
                    } else if(head[currenthead].equals("up")) {
                        //위쪽일 경우
                        if(currentY + length <= M) {
                            currentY = currentY + length;
                        } else {
                            System.out.println(-1);
                            return;
                        }
                    } else if(head[currenthead].equals("left")) {
                        if(currentX - length >= 0) {
                            currentX = currentX - length;
                        } else {
                            System.out.println(-1);
                            return;
                        }
                    } else if(head[currenthead].equals("down")) {
                        if(currentY - length >= 0) {
                            currentY = currentY - length;
                        } else {
                            System.out.println(-1);
                            return;
                        }
                    }
                break;
                case "TURN":
                    //0이면 왼쪽으로 90도 회전
                    int temp;
                    if(length == 0) {
                        //왼쪽으로 회전
                        temp = dq.pollFirst();
                        dq.addLast(temp);
                    } else {
                        //오른쪽으로 회전
                        temp = dq.pollLast();
                        dq.addFirst(temp);
                    }
                    currenthead = dq.peekFirst();
                    break;
            }
        }

        System.out.println(currentX + " " + currentY);
    }
}
