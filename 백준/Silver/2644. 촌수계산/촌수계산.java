import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<ArrayList<Integer>> list;
    static boolean isVisited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        list = new ArrayList<>();

        //전체 사람의 수
        int n = Integer.parseInt(br.readLine());

        //두 사람의 촌수
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        //부모 자식들간의 관계의 개수
        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i <= n; i++) {
            //인접 리스트 초기화
            list.add(new ArrayList<>());
        }
        //방문 배열 초기화
        isVisited = new boolean[n+1];

        for(int i = 0; i < m; i++) {
            //인접 리스트에 간선 정보 추가
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int answer = DFS(start,end, 0);

        System.out.println(answer);
    }

    public static int DFS(int start, int end, int cnt) {
        isVisited[start] = true;

        if(start == end) {
            return cnt;
        }

        for(int i = 0; i < list.get(start).size(); i++) {
            int next = list.get(start).get(i);
            if(isVisited[next] == false) {
                int result = DFS(next, end, cnt + 1);
                if(result != -1) {
                    return result;
                }
            }
        }
        return -1;
    }
}
