public class Exercise1 {

    public static boolean isPalindromeMyMethod(int[] vector) {
        StackInt stack = new StackInt(vector.length);
        StackInt reverseStack = new StackInt(vector.length);
        StackInt temp = new StackInt(vector.length);
        for (int integer : vector){
            stack.push(integer);
            temp.push(integer);
        }
        while (!temp.isEmpty()){
            reverseStack.push(temp.pop());
        }

        for (int i = 0;i< vector.length;i++){
            if (!(stack.pop() == reverseStack.pop())){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeOtherMethod(int[] vector){
        StackInt stackInt = new StackInt(vector.length);
        for (int integer : vector){
            stackInt.push(integer);
        }

        for (int i=0;i<vector.length;i++){
            if (!(vector[i] == stackInt.pop())){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] vector = {1,2,3,2,1};
        if (isPalindromeMyMethod(vector)){
            System.out.println("é palindromo!");
        }else{
            System.out.println("Não é palindromo!");
        }
        int[] vector2 = {1,2,3,24,1};
        if (isPalindromeOtherMethod(vector2)){
            System.out.println("é palindromo!");
        }else{
            System.out.println("Não é palindromo!");
        }
    }
}
