import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Long, Integer> freqency = new HashMap<>();
        ArrayList<Long> freqList = new ArrayList<>();

        int cardCnt = Integer.parseInt(br.readLine());

        for(int i = 0; i < cardCnt; i++) {
            long cardNum = Long.parseLong(br.readLine());

            if(freqency.containsKey(cardNum)) {
                int temp = freqency.get(cardNum);
                freqency.put(cardNum, temp + 1);
            } else {
                freqency.put(cardNum, 1);
            }
        }

        int max = Collections.max(freqency.values()); //맵에 있는 value의 최댓값

        for(Map.Entry<Long, Integer> entry : freqency.entrySet()) {
            long entryKey = entry.getKey();
            int entryValue = entry.getValue();

            if(max == entryValue) {
                freqList.add(entryKey);
            }
        }

        freqList.sort(Comparator.naturalOrder());

        System.out.println(freqList.get(0));
    }
}
