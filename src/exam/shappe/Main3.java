package exam.shappe;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


/**
 * 如果出现下面两种情况，交易无效
 * 1. 交易金额大于1000
 * 2. 它与另一个城市中同名字的另一笔交易时间相差不超过60（<=60）
 * 每个交易字符串transaction[i]由一些用符号“，”分隔的值组成，这些值分别表示交易的：名字，时间，金额和城市
 * 给定一份交易清单transactions，返回无效的交易列表
 *
 * result: ac
 */
public class Main3 {

    @Test
    public void test() {
        String[] values = new String[]{"alice,20,800,sz", "alice,50,100,sg","wh,40,600,sz","yxh,70,100,wx"};
        String[] res = invalidTransaction(values);
        for (String str : res) {
            System.out.println(str);
        }
    }

    static class Transaction {
        String name;
        int time;
        int money;
        String city;
        public Transaction(String name, int time, int money, String city){
            this.name = name;
            this.time = time;
            this.money = money;
            this.city = city;
        }
    }

    public String[] invalidTransaction (String[] vTransaction) {
        Arrays.sort(vTransaction); // 以name排序
        ArrayList<Transaction> transactions = new ArrayList<>(vTransaction.length); // 存放所有交易
        for (String s : vTransaction) {
            String[] value = s.split(","); // 用，分开
            transactions.add(new Transaction(value[0], Integer.parseInt(value[1]),
                    Integer.parseInt(value[2]), value[3]));
        }
        transactions.sort(new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                return o1.name.equals(o2.name) ? o1.time - o2.time : 0;
            }
        });
        String[] res = new String[vTransaction.length];
        int index = 0;

        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).money > 1000) {
                res[index++] = transactions.get(i).name+","+transactions.get(i).time+","
                                +transactions.get(i).money+","+transactions.get(i).city;
                continue;
            }
            if (i < transactions.size()-1 && transactions.get(i).name.equals(transactions.get(i+1).name)
                    && !transactions.get(i).city.equals(transactions.get(i+1).city)
                    && transactions.get(i).time - transactions.get(i+1).time <= 60) {
                res[index++] = transactions.get(i).name+","+transactions.get(i).time+","
                        +transactions.get(i).money+","+transactions.get(i).city;
                res[index++] = transactions.get(i+1).name+","+transactions.get(i+1).time+","
                        +transactions.get(i+1).money+","+transactions.get(i+1).city;
                i++;
            }
        }
        String[] update = new String[index];
        for (int i = 0; i < index; i++){
            update[i] = res[i];
        }
        return update;
    }
}
