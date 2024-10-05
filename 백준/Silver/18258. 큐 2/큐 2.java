import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            if(str.length == 2) {
                int num = Integer.parseInt(str[1]);
                q.add(num);
            } else {
                String command = str[0];
                switch (command) {
                    case "pop":
                        if(!q.isEmpty()) {
                            sb.append(q.pollFirst()).append("\n");
                        } else {
                            sb.append(-1).append("\n");
                        }
                    break;
                    case "size":
                        sb.append(q.size()).append("\n");
                    break;
                    case "empty":
                        if(!q.isEmpty()) {
                           sb.append(0).append("\n");
                        } else {
                            sb.append(1).append("\n");
                        }
                    break;
                    case "front":
                        if(!q.isEmpty()) {
                            sb.append(q.peekFirst()).append("\n");
                        } else {
                            sb.append(-1).append("\n");
                        }
                    break;
                    case "back":
                        if(!q.isEmpty()) {
                            sb.append(q.peekLast()).append("\n");
                        } else {
                            sb.append(-1).append("\n");
                        }
                    break;
                }
            }
        }

        System.out.println(sb.toString());
    }
}
