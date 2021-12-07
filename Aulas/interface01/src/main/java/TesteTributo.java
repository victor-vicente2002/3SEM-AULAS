public class TesteTributo {

    public static void main(String[] args) {
        Alimento maca = new Alimento(123,
                "1 kg Maçã Fuji", 6.99, 3);
        Perfume puruvoodoo = new Perfume(456,
                "Perfume da Rochelle", 200.0,
                "amadeirado");
        Servico dev = new Servico("Desenvolvedor Freelancer",
                1000.00);

        //Exibição dos objetos

        System.out.println(maca);
        System.out.println(puruvoodoo);
        System.out.println(dev);

        //Criação do objeto Tributo

        Tributo trib = new Tributo();

        //Adiciona os obejots criados à lista
        trib.adicionaTributavel(maca);
        trib.adicionaTributavel(puruvoodoo);
        trib.adicionaTributavel(dev);

        //Exibir todos os tributáveis

        trib.exibirTodos();

        //Exibe o total de tributos

        System.out.println("Total de tributos: " + trib.calculaTotalTributo());
    }
}
