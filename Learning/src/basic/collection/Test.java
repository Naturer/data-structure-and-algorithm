package basic.collection;

public class Test {

    public static void main(String[] args) throws Throwable {
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        
    }
}
