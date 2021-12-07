package br.com.bandtec.calculadoracomteste.agendamento;

import br.com.bandtec.calculadoracomteste.repositorio.ImpostoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/*
@Service -> Indica que a classe será uma Service do Spring
Um componente Service serve para programarmos regras de negócio e/ou agendamentos

Nela podemos, por exemplo, injetar uma repository.
Um Service tem apenas 1 instância na API
 */
@Service
public class AgendamentoService {

    // Aqui poderia estar injetada uma repository
    @Autowired
    private ImpostoRepository repository;

    // esta anotação transforma o método num método agendado
    @Scheduled(fixedRate = 3000) // fixedRate = 3000 -> será executado a cada 3000ms (3s)
    // initialDelay = 5000 -> isso retardaria o inicio da primeira execução
    public void filosofar() {
        System.out.println("Só colhe quem planta!");
        // aqui eu poderia usar a repository
    }

    /*
Quando usamos "cron", usamos as Cron Expressions (não é igual ao Crontab)

São 6 valores, todos obrigatórios:
<segundo> <minuto> <hora> <dia-do-mês> <mês> <dia-da-semana>

No exemplo abaixo, o método está agendado para executar:
* * * * * *
Todo segundo, de todo minuto, de toda hora, de todos os dias do mês e da semana

* - tudo
, - vários valores (ex: MON, WED, FRI)
- - intervalo (10-12, entre 10 e 12)

Exemplos:
0 5 * * * *
-> todo dia da semana, todos os meses, todos os dias do mês, toda hora, sempre aos 5m e 0s

0 30 21 * * *
-> todo dia da semana, todos os meses, todos os dias do mês, sempre as 21:30:00

0 0 5 1 * *
-> todo dia da semana, todos os meses, todo dia 1 do mês, sempre as 05:00:00

0 0 5 1 12 *
-> todo dia da semana, todos os meses, todo dia 1 de dezembro, sempre as 05:00:00

0 0 2 * * SAT-SUN
-> só aos sábados e domingos, todos os meses, todo dia do mês (sábado e domingo), as 02:00:00

0 0 5 * * MON-FRI
-> de 2ª a 6ª, todos os meses, todo dia do mês (de 2ª a 6ª), as 05:00:00

0 0 22 * * MON,WED,FRI
-> Toda 2ª, 4ª a 6ª, todos os meses, todo dia do mês (2ª, 4ª a 6ª), as 22:00:00
     */
    @Scheduled(cron = "* * * * * *")
    public void repetirMantra() {
        System.out.println("ahá uhú, a Bandtec é nossa!");
    }

}
