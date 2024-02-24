import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    //스택을 만들어야됨 어떻게?
    //리스트를 이용해서 스택구조를 만들 수 있지 않을까?
    public static ArrayList<Integer> stack = new ArrayList<>();
    
    //시간단축을 위한 버퍼드라이터 System.out.println으로는 시간초과가 발생했는데..
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int orderCnt = Integer.parseInt(br.readLine());

        for(int i = 0; i < orderCnt; i++) {
            String[] input = br.readLine().split(" ");

            int order = Integer.parseInt(input[0]);

            if(order == 1) {
                int data = Integer.parseInt(input[1]);
                insert(data);
                continue;
            }

            if(order == 2) {
                pop();
                continue;
            }

            if(order == 3) {
                stackSize();
                continue;
            }

            if(order == 4) {
                isEmpty();
                continue;
            }

            if(order == 5) {
                getData();
            }
        }

        bw.flush();
        bw.close();
    }

    // 1 x : 정수 x를 스택에 넣는다.
    public static void insert(int x) {
        stack.add(x);
    }

    // 2 : 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 출력한다.
    public static void pop() throws IOException {
        int index = stack.size() - 1;

        //index가 0보다 작다는 것은 아무것도 존재하지 않는다는 뜻이기 때문1
        if(index  < 0) {
            //-1을 출력
            bw.write(-1 + "\n");
        } else {
            int output = stack.get(index);  //출력할 값을 취득
            stack.remove(index);            //취득 후 삭제
            bw.write(output + "\n");     //값을 출력
        }
    }

    // 3 : 스택에 들어있는 정수의 개수를 출력한다.
    public static void stackSize() throws IOException {
        int size = stack.size();
        bw.write(size + "\n");
    }

    // 4 : 스택이 비어있으면 1, 아니면 0을 출력한다.
    public static void isEmpty() throws IOException {
        int isEmpty = stack.size();
        if(isEmpty == 0) {
            bw.write(1 + "\n");
        } else {
            bw.write(0 + "\n");
        }
    }

    // 5 : 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 출력한다.
    public static void getData() throws IOException {
        int index = stack.size() - 1;

        if(index < 0) {
            bw.write(-1 + "\n");
        } else {
            int output = stack.get(index);
            bw.write(output + "\n");
        }
    }

}


