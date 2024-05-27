import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Bus implements Comparable<Bus> {
    int bus;
    int cost;

    public Bus(int bus, int cost) {
        this.bus = bus;
        this.cost = cost;
    }

    @Override
    public int compareTo(Bus b) {
        return this.cost - b.cost;
    }
}

public class Main {
    static int[] dist;
    static List<ArrayList<Bus>> timetable;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); //도시의 개수
        int M = Integer.parseInt(br.readLine()); //버스의 개수

        //인접리스트를 작성 후, 공간을 할당
        //거리배열을 작성하고, 최대값으로 채움
        timetable = new ArrayList<>();
        dist = new int[N + 1];
        isVisited = new boolean[N + 1];

        for(int i = 0; i <= N; i++) {
            timetable.add(new ArrayList<>());
        }
        Arrays.fill(dist, Integer.MAX_VALUE);

        //입력을 받아서 넣기
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int fare = Integer.parseInt(st.nextToken());

            timetable.get(start).add(new Bus(end, fare));
        }

        st = new StringTokenizer(br.readLine());

        int startPoint = Integer.parseInt(st.nextToken());
        int endPoint = Integer.parseInt(st.nextToken());

        Calc(startPoint);

        System.out.println(dist[endPoint]);
    }

    static void Calc(int start) {
        //우선순위 큐를 정의
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        //현재 시작 지점을 0으로 지정
        dist[start] = 0;
        //시작 지점을 큐에 추가
        pq.add(new Bus(start, 0));

        while(!pq.isEmpty()) {
            //현재 위치
            Bus current = pq.poll();

            //현재 도시를 방문하지 않은 경우
            if(!isVisited[current.bus]) {
                //방문 처리
                isVisited[current.bus] = true;

                //현재 위치와 연결되있는 다음 도시로의 간선을 체크
                for (int i = 0; i < timetable.get(current.bus).size(); i++) {
                    Bus next = timetable.get(current.bus).get(i);

                    //1. 다음 도시를 방문하지 않았을 경우
                    //2. 여태까지의 다음 도시까지의 비용보다 지금까지 온 비용과 다음 도시 이동까지의 비용이 더 저렴할 경우
                    if (!isVisited[next.bus] && dist[next.bus] > dist[current.bus] + next.cost) {
                        dist[next.bus] = dist[current.bus] + next.cost; //비용을 갱신
                        pq.add(new Bus(next.bus, dist[next.bus])); //다음 도시까지의 비용을 큐에 추가
                    }
                }
            }
        }
    }
}
