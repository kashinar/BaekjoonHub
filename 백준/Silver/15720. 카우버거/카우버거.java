import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Collections; //우선 순위 큐를 큰 순서부터 받기 위한 Collections 선언

public class Main {
    public static int total;
    public static int discount;
    public static PriorityQueue<Integer> burger = new PriorityQueue<>(Collections.reverseOrder());
    public static PriorityQueue<Integer> side = new PriorityQueue<>(Collections.reverseOrder());
    public static PriorityQueue<Integer> drink = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sNum = br.readLine().split(" ");

        for(int i = 0; i < sNum.length; i++) {
            String[] getMenu = br.readLine().split(" ");
            AddMenu(i, getMenu);
        }

        Calc();

        System.out.println(total);
        System.out.println(discount);
    }

    public static void AddMenu(int i, String[] menu) {
        for(int j = 0; j < menu.length; j++) {
            int data = Integer.parseInt(menu[j]);
            total += data;

            if(i == 0) {
                burger.add(data);
            } else if(i == 1) {
                side.add(data);
            } else if(i == 2) {
                drink.add(data);
            }
        }
    }

    public static void Calc() {
        //큐가 전부 다 빌때까지 반복실행
        while(!burger.isEmpty() || !side.isEmpty() || !drink.isEmpty()) {
            //가격 초기화
            int burger_price = 0;
            int drink_price = 0;
            int side_price = 0;

            //안비었으면 하나씩 꺼내기
            if(!burger.isEmpty()) {
                burger_price = burger.poll();
            }

            if(!side.isEmpty()){
                side_price = side.poll();
            }

            if(!drink.isEmpty()){
                drink_price = drink.poll();
            }

            //제대로 된 세트일 경우 할인, 그렇지 않을 경우 그냥 더하기
            if(burger_price != 0 && side_price != 0 && drink_price != 0) {
                discount += (burger_price + side_price + drink_price) * 0.9;
            } else {
                discount += (burger_price + side_price + drink_price);
            }
        }
    }
}
