import java.util.ArrayList;
import java.util.List;

public class ControleBonus {

    List<Bonificaveis> listaFuncBonus;

    //métodos

    public void addFuncionarios(Bonificaveis funcionario){

        listaFuncBonus.add(funcionario);
    }

    public void getFuncionarios(){
        for (Bonificaveis b : listaFuncBonus){
            System.out.println(b.toString());
        }
    }

    public void calcBonus(){
        Double bonus = 0.0;
        for (Bonificaveis b : listaFuncBonus){
            bonus += b.getValorBonus();
        }
        System.out.println("R$ " + bonus);
    }

    public ControleBonus() {
        this.listaFuncBonus = new ArrayList<Bonificaveis>();
    }
}
