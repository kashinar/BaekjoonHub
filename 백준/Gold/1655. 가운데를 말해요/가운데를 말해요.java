import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> minpq = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxpq = new PriorityQueue<Integer>(Collections.reverseOrder());

		int N = Integer.parseInt(bf.readLine());
		int count = 0;
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		//min에 중간값보다 큰 수를
		//max에 중간값보다 작은 수를 집어넣는다.
		
		
		while(count != N) {
			int input = Integer.parseInt(bf.readLine());
			
			//일단 둘다 비어있으면, 먼저 maxpq에 값 추가.
			if(minpq.size() == 0 & minpq.size() == maxpq.size()) {
				maxpq.add(input);
				result.add(maxpq.peek()); // 첫 값을 result에 넣어준다.
			} else { 
				if(input >= maxpq.peek()) {
					minpq.add(input);
				} else {
					maxpq.add(input);
				}
				
				//큐의 사이즈 조정
				if(minpq.size()>maxpq.size()+1) {
					int bal = minpq.poll();
					maxpq.add(bal);	
				} else if(maxpq.size()>minpq.size()){
					int bal = maxpq.poll();
					minpq.add(bal);
				} 
				
				//홀수일때
				if(minpq.size() == maxpq.size()+1) {
					result.add(minpq.peek());
				} else if(minpq.size() == maxpq.size()) { //같다는건 짝수 일때
					result.add(maxpq.peek()); //maxpq에는 minpq보다 작은 수만 들어가니까..
				}
					
			}
			
			count++;
		}
		
	
		for(int a : result) {
			System.out.println(a);
		}
	}
}
