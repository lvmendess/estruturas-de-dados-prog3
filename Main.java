public class Main{

    public static void main(String[] args) {
        ListaSE list1 = new ListaSE();


        /*questao 1
        int[] a = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for(int i=0; i<a.length; i++){
            Cell b = new Cell(a[i]);
            list1.insertAtStart(b);
        }

        list1.print();

        int c = 0;
        while(c<2){
            list1.removeAtEnd();
            c++;
        }

        list1.print();*/

        int[] a = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for(int i=0; i<a.length; i++){
            Cell b = new Cell(a[i]);
            list1.insertAtStart(b);
        }

        ListaSE list2 = new ListaSE();

        int[] d = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for(int i=0; i<d.length; i++){
            Cell e = new Cell(d[i]);
            list2.insertAtStart(e);
        }

        //list1.assemble(list2);

        //list1.assembleOrdered(list2); //não esta ordenado naosei pq

        list1.intersection(list2).print();

        //list1.print();

    }

}