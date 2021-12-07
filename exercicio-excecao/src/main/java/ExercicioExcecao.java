import javax.swing.*;
import java.util.Scanner;

public class ExercicioExcecao {
    public static void main(String[] args) {

        boolean end = false;

        while (!end){
            String salary = JOptionPane.showInputDialog ("Digite seu salário: ");
            if (salary == null)
                System.exit(0);

            String readjustment= JOptionPane.showInputDialog ("Digite o seu reajuste (0 a 100): ");
            if (readjustment == null)
                System.exit(0);

            try {
                int numSalary= Integer.parseInt(salary);
                if ((numSalary < 0)){
                    throw new Exception("Salário não pode ser menor que zero");
                }
                int numReadjustment= Integer.parseInt(readjustment);
                if ((numReadjustment < 0) || (numReadjustment > 100)) {
                    throw new Exception("Reajuste está maior que 100 ou menor que zero");
                }
                JOptionPane.showMessageDialog (null, "Seu salário com reajuste:"+
                        (numSalary+(numSalary * numReadjustment/100)) );
                end = true;

            }catch (NumberFormatException error){
                JOptionPane.showMessageDialog (null, "Digite apenas números inteiros!\n" +
                        error.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
            }catch (Exception error) {
                JOptionPane.showMessageDialog (null, error, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
}
