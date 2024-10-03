public class Main{

    public static void main(String[] args) {
        NewBinaryTree b = new NewBinaryTree();

        int[] nodes = new int[]{4, 8, 2, 7, 5, 1, 3, 6};
        for(int i=0; i<nodes.length; i++){
            Node n = new Node(nodes[i]);
            b.insert(n);
        }

        /*b.removeAllEven();
        //b.countNodes();
        b.printInOrder();*/
        //b.stackInOrder(b.getRoot());
        //b.stackPostOrder(b.getRoot());
        b.stackPreOrder(b.getRoot());
    }

}