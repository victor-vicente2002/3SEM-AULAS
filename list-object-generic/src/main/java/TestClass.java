public class TestClass {

    public static void main(String[] args) {
        ListObj<String> nameList = new ListObj<>(5);

        nameList.add("Victor");
        nameList.add("Célia");
        nameList.add("Thomas");
        nameList.add("Vinicius");
        nameList.add("Bradley");

        nameList.getList();

        System.out.println(nameList.getValue("Victor"));

        nameList.removeByIndex(0);
        nameList.removeElement("Célia");
        nameList.getSize();
        nameList.getElement(90);

        nameList.getList();

        nameList.cleanList();

        nameList.getList();
    }
}
