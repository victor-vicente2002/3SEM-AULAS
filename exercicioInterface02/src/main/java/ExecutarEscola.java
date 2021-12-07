public class ExecutarEscola {
    public static void main(String[] args) {
        Professor professor1 = new Professor("Celia Taniwaki", 7, 30.00);
        Professor professor2 = new Professor("Diego", 2, 20.00);
        Coordenador coordenador1 = new Coordenador("Marise Miranda", 3, 30.00,
                4, 35.00);
        Coordenador coordenador2 = new Coordenador("Gerson", 4, 30.00,
                5, 35.00);

        ControleBonus controle = new ControleBonus();

        controle.addEducador(professor1);
        controle.addEducador(professor2);
        controle.addEducador(coordenador1);
        controle.addEducador(coordenador2);

        controle.exibirLista();
        controle.calcBonus();
    }
}
