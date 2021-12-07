public class Exercise4 {
    public static void main(String[] args) {
        String phrase = "Today i fought with a bear";
        StackGeneric<Character> reversePhrase = new StackGeneric<>(phrase.length());
        for (int i=0; i<phrase.length();i++){
            reversePhrase.push(phrase.charAt(i));
        }
        while (!reversePhrase.isEmpty()){
            System.out.print(reversePhrase.pop());
        }
    }
}
