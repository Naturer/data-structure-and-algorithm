import java.util.LinkedList;
import java.util.List;

public class Solution {
	
	private static List<Integer> sSorted = new LinkedList<Integer>();
	
	public static void addElement(int e) {
		boolean flag = false;
        for (int i = 0; i < sSorted.size(); i++) {
            if (e < sSorted.get(i)) {
                sSorted.add(i, e);
                flag = true;
                break;
            }
        }
        if (!flag) {
            sSorted.add(e);
        }
	}

	public static void main(String[] args) {
		 Solution.addElement(3);
		 Solution.addElement(2);
		 Solution.addElement(1);
		 Solution.addElement(2);
		 System.out.println(sSorted);
	}
}
