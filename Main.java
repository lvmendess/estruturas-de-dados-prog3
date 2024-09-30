public class Main{

    public static void main(String[] args) {
        NewBinaryTree b = new NewBinaryTree();

        int[] nodes = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        for(int i=0; i<nodes.length; i++){
            Node n = new Node(nodes[i]);
            b.insert(n);
        }

        b.printInOrder();

        System.out.println(b.findNode(10).getValue());

       /*b.printPreOrder();
        System.out.println();

        b.printPostOrder();
        System.out.println();*/ 

        /*b.countNodes();
        System.out.println();

        b.countNonLeafNodes();*/
    }

}