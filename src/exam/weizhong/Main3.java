package exam.weizhong;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 抽卡是一类类似于博弈的游戏。现在有一种抽卡方式，描述如下：
 * 初始你只有一次抽卡机会。每次抽卡浪费一次抽卡机会，获得一张卡片。这张卡片上有两个数字，
 * 第一个数字代表你能获得的钱，第二个数字代表你能获得的额外抽卡次数。额外的抽卡次数是可以累计的。
 * 现在，你知道了卡片的数量，所有的卡片上的数字，以及所有卡片的顺序。你只需要安排一种抽卡顺序，使得你能获得钱数最多。
 *
 * 第一个行一个数n,代表卡片的数量。 接下来n行，每行用两个数ai,bi描述一张卡片。
 * ai表示抽这张卡能获得的钱数，bi表示抽这张卡能获得的额外抽卡次数
 * @author WuHao ac
 * @create 2020-04-21-17:31
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            Card[] cards = new Card[n];
            for (int i = 0; i < n; i++){
                int money = sc.nextInt();
                int chance = sc.nextInt();
                Card card = new Card();
                card.money = money;
                card.chance = chance;
                cards[i] = card;
            }

            Arrays.sort(cards , new Comparator<Card>() { // 排序
                @Override
                public int compare(Card o1, Card o2) {
                    return o2.money - o1.money;
                }

                @Override
                public boolean equals(Object obj) {
                    return false;
                }
            });

            int res = 0;
            int count = 1; // 记录翻牌次数
            for (int i = 0 ; i < n ; i++){
                if (cards[i].chance != 0){
                    res += cards[i].money;
                    count += cards[i].chance - 1;
                    cards[i].money = -1; // 该元素不可用
                }
            }
            for (int i = 0; i < n; i++){
                if (count > 0 && cards[i].money != -1){
                    res += cards[i].money;
                    count--;
                }
            }
            System.out.println(res);
        }
    }
}

class Card{
    public int money;
    public int chance;
}
