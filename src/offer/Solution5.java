package offer;

/**
 * @Author WuHao
 * @Create 2020-08-09-23:50
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"
 */
public class Solution5 {
    public String replaceSpace(String s) {
        int count = 0;
        for(int i = 0;i < s.length();i++){
            if(' ' == s.charAt(i)) count++;
        }
        char[] cArray = new char[s.length() + count*2];
        int index = 0;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) != ' '){
                // 不是空格
                cArray[index++] = s.charAt(i);
            }else{
                cArray[index++] = '%';
                cArray[index++] = '2';
                cArray[index++] = '0';
            }
        }
        return new String(cArray);
    }
}
