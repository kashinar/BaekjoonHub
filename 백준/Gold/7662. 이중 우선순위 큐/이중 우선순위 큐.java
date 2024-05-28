import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); //테스트 케이스

        for(int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tm = new TreeMap<>(); //테스트 케이스마다 tm을 초기화

            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int data = Integer.parseInt(st.nextToken());

                if(command.equals("I")) {
                    //키가 존재하면 그 값에 1, 없으면 디폴트값 0에 1을 더한 값을
                    tm.put(data, tm.getOrDefault(data, 0) + 1);
                } else if(command.equals("D")) {
                    //TreeMap이 비어있으면 다음으로
                    if(tm.isEmpty()) continue;

                    if(data == 1) {
                        //최대값을 빼야됨
                        int last = tm.lastKey();
                        if(tm.get(last) == 1) {
                            //값이 하나밖에 없을 경우는 해당 키 값 자체를 삭제해버린다.
                            tm.remove(last);
                        } else if(tm.get(last) > 1) {
                            //중복된 값이 있을 경우, 갯수를 한개 차감한다.
                            tm.put(last, tm.get(last) - 1);
                        }
                    } else if (data == -1) {
                        //최소값을 빼야됨
                        int first = tm.firstKey();
                        if(tm.get(first) == 1) {
                            //값이 하나밖에 없을 경우는 해당 키 값 자체를 삭제해버린다.
                            tm.remove(first);
                        } else if(tm.get(first) > 1) {
                            //중복된 값이 있을 경우, 갯수를 한개 차감한다.
                            tm.put(first, tm.get(first) - 1);
                        }
                    }
                }
            }

            if(tm.size() == 0) {
                System.out.println("EMPTY");
            } else {
                int max = tm.lastKey();
                int min = tm.firstKey();
                System.out.println(max + " " + min);
            }
        }
    }
}
