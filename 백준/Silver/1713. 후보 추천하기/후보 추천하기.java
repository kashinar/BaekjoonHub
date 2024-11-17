import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //사진 틀의 수
        int C = Integer.parseInt(br.readLine()); //학생들의 총 추천 횟수

        StringTokenizer st = new StringTokenizer(br.readLine());

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for(int i = 0; i < C; i++) {
            int id = Integer.parseInt(st.nextToken());

            //지명된 학생인지 아닌지
            if(map.containsKey(id)) {
                //지명 됐으면 횟수 갱신해주기
                map.put(id, map.get(id) + 1);
            } else {
                //3칸 다 찼으면
                //가장 오래된 최소를 지워주고 새로운 친구를 추가
                if(map.size() == N) {
                    int min = map.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey();
                    map.remove(min);
                }
                //새 학생을 추가
                map.put(id, 1);
            }
        }

        map.keySet().stream().sorted().forEach(id -> System.out.print(id + " "));
    }
}