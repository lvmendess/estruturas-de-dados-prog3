public class Main{

    public static void main(String[] args) {
        NewBinaryTree b = new NewBinaryTree();
        BalancedTree bt = new BalancedTree();

        int[] nodes = new int[]{4, 7, 5, 1};
        for(int i=0; i<nodes.length; i++){
            Node n = new Node(nodes[i]);
            b.insert(n);
            //bt.insert(n);
        }

        b.removeAllEven();
        //b.countNodes();
        b.printInOrder();

        //bt.stackInOrder(bt.getRoot());
        //bt.stackPreOrder(bt.getRoot());
        //bt.stackPostOrder(bt.getRoot());
    }

}