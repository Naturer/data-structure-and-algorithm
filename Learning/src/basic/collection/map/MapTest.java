package basic.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @title 测试HashMap的链表转换红黑树
 * @date 16:37 2020/9/23
 */
public class MapTest {

    public static void main(String[] args){
        HashMap<MapKey,String> map = new HashMap<MapKey, String>();
        //第一阶段  
        for (int i = 0; i < 6; i++) {
            map.put(new MapKey(String.valueOf(i)), "A");
        }

        //第二阶段
        for (int i = 0; i < 10; i++) {
            map.put(new MapKey(String.valueOf(i)), "A");
        }

        //第三阶段
        for (int i = 0; i < 50; i++) {
            if (i == 20)
                System.out.println(1);
            map.put(new MapKey(String.valueOf(i)), "A");
        }

        //第四阶段
        map.put(new MapKey("Z"), "B");
        map.put(new MapKey("J"), "B");
        map.put(new MapKey("F"), "B");
        System.out.println(map);
    }

}