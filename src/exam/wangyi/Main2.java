package exam.wangyi;


import java.util.*;

/**
 * @author WuHao
 * @create 2020-04-07-19:46
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int D = sc.nextInt();
            List<Man> lists = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                Man man = new Man();
                man.setAbility(sc.nextInt());
                lists.add(man);
            }
            for (Man list : lists) {
                list.setHurt(sc.nextInt());
            }
            Collections.sort(lists, new Comparator<Man>() {
                @Override
                public int compare(Man o1, Man o2) {
                    return o1.getAbility() - o2.getAbility();
                }
            });
            int res = 0;
            for (Man list : lists) {
                if(list.getAbility() > D){
                    res += list.getHurt();
                }
                D = D + 1;
            }
            System.out.println(res);
        }
    }
}

class Man{
    private int ability;
    private int hurt;

    public int getAbility() {
        return ability;
    }

    public void setAbility(int ability) {
        this.ability = ability;
    }

    public int getHurt() {
        return hurt;
    }

    public void setHurt(int hurt) {
        this.hurt = hurt;
    }
}
