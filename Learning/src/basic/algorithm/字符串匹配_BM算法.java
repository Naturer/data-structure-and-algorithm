package basic.algorithm;

public class 字符串匹配_BM算法 {

    public static void main(String[] args) {
        String n = "abcacabdc";
//        String n = "aaaaaaa";
        String m = "abd";
//        String m = "baaa";
        System.out.println(test1(n, m));;
    }

    //使用坏字符规则，实现字符串匹配(单纯使用坏字符规则，在这种情况下效果最差：n为 aaaaaaa，m为 baaa)
    private static int test1(String a, String b) {
        char[] n = a.toCharArray();
        char[] m = b.toCharArray();
        int nLen = n.length;
        int mLen = m.length;
        int nIndex;
        int mIndex;
        char badChar;
        int si;
        for (int i = 0; i < nLen - mLen + 1; ) { // i代表模式串的第一个字符坐标
            int xi = -1;
            boolean found = true;
            int move = 1;
            mIndex = mLen - 1;
            nIndex = i + mIndex;
            for (; mIndex >= 0; ) {
                if (n[nIndex] != m[mIndex]) {
                    badChar = n[nIndex];
                    si = mIndex;
                    //遍历模式串bIndex左边的，看坏字符是否存在
                    for (; mIndex >= 0; mIndex--) {
                        if (m[mIndex] == badChar) {
                            xi = mIndex;
                        }
                    }
                    //此时模式串应该向后移动 si-xi 位
                    move = si - xi;
                    found = false;
                    break;
                }
                mIndex--;
                nIndex--;
            }
            if (found)
                return i;
            i += move; //向后移动
        }
        return -1;
    }
}
