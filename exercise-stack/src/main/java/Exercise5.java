import java.text.Normalizer;

public class Exercise5 {
    public static boolean isPalindromeString(String phrase){
        String refactorPhrase = Normalizer.normalize(phrase, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .replaceAll("-","")
                .replaceAll(",","")
                .replaceAll(" ", "")
                .replaceAll("\\s", "")
                .trim()
                .toLowerCase();

        StackGeneric<Character> stack = new StackGeneric<>(refactorPhrase.length());

        System.out.println(refactorPhrase);
        for (int i = 0; i<refactorPhrase.length(); i++){
            stack.push(refactorPhrase.toLowerCase().charAt(i));
        }

        for (int i=0;i<refactorPhrase.length();i++){
            if (!(refactorPhrase.charAt(i) == stack.pop())){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        if(isPalindromeString("Socorram-me, subi no ônibus em marrocos")){
            System.out.printf("É palindromo");
        }else {
            System.out.printf("Não é palindromo!");
        }
    }
}
