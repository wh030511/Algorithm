package exam.huawei;

import java.util.List;

/**
 * 面试手撕代码
 * @author WuHao
 * @create 2020-04-30-18:19
 */
public class Main {
    public int[] solver(int[] arr){
        List[] list = new List[9];
        for (int i : arr) {
            list[arr[i]].add(i);
        }
        int[] res = new int[9];
        int index = 0;
        for (int i = list.length  - 1; i >= 0; i-- ){
            if (list[i].size() == 0) continue;

            for (int k = 0; k < list[i].size(); k++){
                res[index++] = (Integer)list[i].get(k);
            }
        }
        return res;
    }
}
