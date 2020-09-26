package basic.collection.map;

import java.util.regex.Pattern;

/*
 * @title MapKey 重写了hashCode，使得hashCode碰撞极高，可以看到链表转红黑树的过程
 * @date 16:37 2020/9/23
 */
public class MapKey {
    private static final String REG = "[0-9]+";

    private String key;

    public MapKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapKey mapKey = (MapKey) o;

        return !(key != null ? !key.equals(mapKey.key) : mapKey.key != null);

    }
    /*
    * 确保每次key的hashCode都相同
    */
    @Override
    public int hashCode() {
        if (key == null)
            return 0;
        Pattern pattern = Pattern.compile(REG);
        if (pattern.matcher(key).matches())
            return 1;
        else
            return 2;
    }

    @Override
    public String toString() {
        return key;
    }
}