import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
    static int[][] house_location;
    static Deque<int[]> queue;
    static boolean[][] isVisited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        house_location = new int[N][N];
        queue = new LinkedList<>();
        isVisited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < input.length; j++) {
                house_location[i][j] = Integer.parseInt(input[j]);
            }
        }

        int numbering = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(house_location[i][j] == 1 && !isVisited[i][j]) {
                    int[] target = {i, j};
                    queue.add(target);
                    pq.add(scan(numbering));
                    numbering += 1;
                }
            }
        }
        
        System.out.println(pq.size());
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

    }

    private static int scan(int numbering) {
        int[][] direction = {{1,0},{-1,0},{0,-1},{0,1}};
        int count = 1;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
        
            house_location[currentX][currentY] = numbering;
            if(!isVisited[currentX][currentY]) isVisited[currentX][currentY] = true;
        
            for(int i = 0; i < direction.length; i++) {
                int nextX = currentX + direction[i][0];
                int nextY = currentY + direction[i][1];

                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N 
                && !isVisited[nextX][nextY] && house_location[nextX][nextY] == 1) 
                {
                    house_location[nextX][nextY] = numbering;
                    isVisited[nextX][nextY] = true;
                    
                    int[] next = {nextX, nextY};
                    queue.addFirst(next);
                    count++;
                }
            }
        }

        return count;
    }
}
