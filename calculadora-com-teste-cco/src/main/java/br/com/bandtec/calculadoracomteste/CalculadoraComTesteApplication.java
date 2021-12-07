package br.com.bandtec.calculadoracomteste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling // esta anotação habilita a criação de agendamentos no projeto
@SpringBootApplication
public class CalculadoraComTesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculadoraComTesteApplication.class, args);
	}

}
