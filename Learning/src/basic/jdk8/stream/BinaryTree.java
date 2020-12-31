package basic.jdk8.stream;

// 构架一个二叉树
// 给一个节点返回是第几层
public class BinaryTree<E> {

    private int size;
    private Node<Integer> root;

    class Node<E> {
        Integer value;
        private Node<E> left;
        private Node<E> right;

        public Node(Integer e, Node<E> left, Node<E> right) {
            this.value = e;
            this.left = left;
            this.right = right;
        }
    }

    void add(Integer e){
        if(root == null)
            root = new Node<>(e,null,null);
        boolean leftFlag = false;
        Node<Integer> node;
        node = root;
        Node<Integer> prev = root;
        while(node != null){
            if (e < root.value) {
                prev = node;
                node = node.left;
                leftFlag = true;
            } else {
                prev = node;
                node = node.right;
            }
        }
        if (leftFlag)
            prev.left = new Node<>(e,null,null);
        else
            prev.right = new Node<>(e,null,null);
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "size=" + size +
                ", root=" + root +
                '}';
    }
}
