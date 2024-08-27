import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //메뉴의 개수
        int menu = Integer.parseInt(br.readLine());
        String[] menu_string = br.readLine().split(" ");

        int[] menu_data = new int[menu + 1];

        int temp;
        int sticker = 0;
        int max_sticker = 0;

        for(String s : menu_string) {
            temp = Integer.parseInt(s);

            if(menu_data[temp] == 0) {
                menu_data[temp] = 1;
                sticker++;
            } else if(menu_data[temp] == 1) {
                menu_data[temp] = 2;
                sticker--;
            }

            max_sticker = Math.max(max_sticker, sticker);
        }

        System.out.println(max_sticker);
    }
}
