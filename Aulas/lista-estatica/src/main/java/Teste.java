public class Teste {
    public static void main(String[] args) {

        ListaEstatica staticList = new ListaEstatica(8);

        staticList.add(23);
        staticList.add(2);
        staticList.add(2);
        staticList.add(34);
        staticList.add(12);
        staticList.add(65);
        staticList.add(8);

        staticList.getVector();

        System.out.println(staticList.search(78));

        System.out.println(staticList.numberElemt);
        System.out.println(staticList.deleteByIndex(3));
        System.out.println(staticList.deleteByElemt(8));

        staticList.getVector();

        staticList.replaces(304, 35);
        staticList.getVector();
        System.out.println(staticList.countOccurrences(120));

        staticList.addInFirstIndex(9);
        staticList.getVector();
    }
}
