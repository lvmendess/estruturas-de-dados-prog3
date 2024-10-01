import java.util.Stack;

public class BalancedTree {
    private Node root;
    
    public BalancedTree(){
        this.root = root;
    }

    public Node getRoot(){
        return root;
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

    /**
     * Escreva uma função não-recursiva para realizar os 3 tipos de caminhamento pela ABB
     * a)em ordem
     */
    public void stackInOrder(Node n){
        Stack<Node> s = new Stack<>();
        Node p = root;

        while(p!=null || !s.isEmpty()){
            if(p!=null){
                s.push(p);
                p = p.getLeft();
            }else{
                p = s.pop();
                System.out.println(p.getValue());
                p = p.getRight();
            }
        }
    }

    /*b)pós ordem */
    public void stackPostOrder(Node root) {
        Stack<Node> s = new Stack<>();
        Node p = root;
        Node lastSeen = null;
        while (p != null || !s.isEmpty()) {
            if (p != null) {
                s.push(p);
                p = p.getLeft();
            } else {
                Node peek = s.getLast();
                if (peek.getRight() != null && lastSeen != peek.getRight()) {
                    p = peek.getRight();
                } else {
                    System.out.println(peek.getValue());
                    lastSeen = s.pop();
                }
            }
        }
    }

    /*c)pré ordem */
    public void stackPreOrder(Node n){}
}
