import java.util.ArrayList;
import java.util.List;

public class ControleBonus {

    //Atributos
    List<Educador> list;

    //Métodos
    public void addEducador(Educador e){
        list.add(e);
    }

    public void exibirLista(){
        for (Educador e : list){
            System.out.println(e);
        }
    }

    public void calcBonus(){
        Double bonus = 0.0;
        for (Educador e : list){
            bonus += e.getValorBonus();
        }
        System.out.println("Bônus total: R$ " + bonus);
    }

    //Construtor

    public ControleBonus() {
        this.list = new ArrayList<Educador>();
    }
}
