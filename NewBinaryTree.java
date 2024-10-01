public class NewBinaryTree {
    private Node root;

    public NewBinaryTree() {
        this.root = null;
    }

    private Node insertNew(Node n, Node current){
        if(current==null){return n;}
        else{
            if(current.getValue()>n.getValue()){
                current.setLeft(insertNew(n, current.getLeft()));
            }else{
                current.setRight(insertNew(n, current.getRight()));
            }
            return current;
        }
    }

    void insert(Node n){
        if(!nodeExists(n)){
            root = insertNew(n, root);
        }else{
            System.out.println("node already exists");
        }
    }

    private boolean exists(Node n, Node m){
        if(m==null){return false;}
        else if(m.getValue()==n.getValue()){return true;}
        else{
            if(m.getValue()>n.getValue()){
                return exists(n, m.getLeft());
            }else{
                return exists(n, m.getRight());
            }
        }
    }

    boolean nodeExists(Node n){
        return exists(n, root);
    }

    private Node find(Node current, int v){
        if(current==null){return null;}
        else if(current.getValue()==v){return current;}
        else{
            if(current.getValue()>v){
                return find(current.getLeft(), v);
            }else{
                return find(current.getRight(), v);
            }
        }
    }

    Node findNode(int v){
        return find(root, v);
    }

    private Node remove(Node root, int v) {
        if (root == null || findNode(v) == null) {
            return root;
        }
        if (root.getValue() > v) {
            root.setLeft(remove(root.getLeft(), v));
        } else if (root.getValue() < v) {
            root.setRight(remove(root.getRight(), v));
        } else {
            if (root.getRight() == null) {
                return root.getRight();
            }
            if (root.getLeft() == null) {
                return root.getLeft();
            }
            Node sucessor = getSucessor(root);
            root.setValue(sucessor.getValue());
            root.setRight(remove(root.getRight(), sucessor.getValue()));
        }
        return root;
    }

    public void removeNode(int v) {
        remove(root, v);
    }
    
    /**
     * 1. Escreva um método que conta o número de nós de uma árvore binária
     */
    private int count(Node n){
        if(n == null){return 0;}
        else{
            return 1 + count(n.getLeft()) + count(n.getRight());
        }
    }
    void countNodes(){
        System.out.println(count(root));
    }

    /*
     * 2. Escreva um método que conta o número de nós não-folha de uma árvore binária.
     */
    private int countNonLeafs(Node n){
        if(n == null){
            return 0;
        }
        if(n.getLeft()==null && n.getRight()==null){
            return 0;
        }
        return 1 + countNonLeafs(n.getLeft()) + countNonLeafs(n.getRight());
    }
    public int countNonLeafNodes(){
        return countNonLeafs(root);
    }

    /**
     * 3.Escreva um método que conta o número de nós folhas de uma árvore binária.
     */
    private int countLeafs(Node n){
        if(n == null){
            return 0;
        }
        if(n.getLeft()==null && n.getRight()==null){
            return 1;
        }
        return 0 + countLeafs(n.getLeft()) + countLeafs(n.getRight());
    }
    public int countLeafNodes(){
        return countLeafs(root);
    }

    /**
     * 4.Escreva um método que calcula a altura de uma árvore binária
     */
    public int height(Node root){
        int r = 0, l = 0;
        if(root==null){
            return 0;
        }else{
            if(root.getRight()!=null){
                r = height(root.getRight());
            }
            if(root.getLeft()!=null){
                l = height(root.getLeft());
            }
            if(l>r){
                return l + 1;
            }else{
                return r + 1;
            }
        }
    }

    private Node getSucessor(Node current) {
        current = current.getRight();
        while (current != null && current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    /**
     * 5.Escreva um método que remove todos os elementos pares da árvore.
     */
    private void removeEven(Node n){
        if(n!=null){
            if(n.getValue()%2==0){
                removeNode(n.getValue());
            }
            if(n.getLeft()!=null){
                removeEven(n.getLeft());
            }
            if(n.getRight()!=null){
                removeEven(n.getRight());
            }
        }
    }
    public void removeAllEven(){
        removeEven(root);
    }

    /**
     * 6. Escreva um método que faz um espelhamento da árvore.
     */
    public void mirroring(Node e){
        if (e != null) {
            Node t = e.getLeft();
            e.setLeft(e.getRight());
            e.setRight(t);
            mirroring(e.getLeft());
            mirroring(e.getRight());
        }
    }

    void preOrder(Node n){
        if(n!=null){
            System.out.println(n.getValue()+"\n");
            preOrder(n.getLeft());
            preOrder(n.getRight());
        }
    }

    void inOrder(Node n){
        if(n!=null){
            inOrder(n.getLeft());
            System.out.println(n.getValue()+"\n");
            inOrder(n.getRight());
        }
    }

    void postOrder(Node n){
        if(n!=null){
            postOrder(n.getLeft());
            postOrder(n.getRight());
            System.out.println(n.getValue()+"\n");
        }
    }

    public void printPreOrder(){
        preOrder(root);
    }

    public void printInOrder(){
        inOrder(root);
    }

    public void printPostOrder(){
        postOrder(root);
    }

    public Node getRoot() {
        return root;
    }
}
