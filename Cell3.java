public class Cell3 {
    Cell3 next = null;
    Node n;

    public Cell3(Node n) {
        this.n = n;
    }
    public Node getNode() {
        return n;
    }
    public void setNode(Node n) {
        this.n = n;
    }
    public Cell3 getNext() {
        return next;
    }
    public void setNext(Cell3 next) {
        this.next = next;
    }
    public void setNext(){
        this.next = null;
    }
}
