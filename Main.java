public class Main{

    public static void main(String[] args) {
        ListSEC l = new ListSEC();
        Cell c = new Cell(5);
        l.insertAtEnd(c);
        l.print();
        
        ListSEC li = new ListSEC();
        c = new Cell(10);
        li.insertAtEnd(c);
        c = new Cell(36);
        li.insertAtEnd(c);

        li.print();

        l.assemble(li);
    }

}