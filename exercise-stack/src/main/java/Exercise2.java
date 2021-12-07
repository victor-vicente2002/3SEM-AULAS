public class Exercise2 {
    public static void convertToBinary(int decimal) {
        StackInt stack = new StackInt(
                (int) (Math.log(decimal)/Math.log(2)+1));
        int tempInt = decimal;
        while (tempInt != 0) {
            stack.push((int) Math.round(tempInt%2));
            tempInt/=2;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        convertToBinary(1024);
        convertToBinary(15);
        convertToBinary(24);
    }
}
