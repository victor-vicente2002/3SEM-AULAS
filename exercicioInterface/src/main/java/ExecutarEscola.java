public class ExecutarEscola {

    public static void main(String[] args) {
        ControleBonus controle = new ControleBonus();

        Professor professor1 = new Professor("Célia Taniwaki", 5, 20.5);
        Professor professor2 = new Professor("José Yoshiro", 4, 20.5);

        Coordenador coordenador1 = new Coordenador("Marise Miranda", 5, 25.00);
        Coordenador coordenador2 = new Coordenador("Gerson", 6, 25.00);

        controle.addFuncionarios(professor1);
        controle.addFuncionarios(professor2);
        controle.addFuncionarios(coordenador1);
        controle.addFuncionarios(coordenador2);

        controle.getFuncionarios();
        controle.calcBonus();

        /*
        Resposta 3: Sim, existe polimorfismo no programa pois fazemos uma sobrescrita de métodos
        (getValorBonus()) e sobrescrita pode ser considerada um tipo de polimorfismo
         */

    }
}
