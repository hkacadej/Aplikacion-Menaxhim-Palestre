package kacadej.henri.sistemmenaxhimipalester;

import kacadej.henri.sistemmenaxhimipalester.entity.Abonent;
import kacadej.henri.sistemmenaxhimipalester.repository.AbonentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SistemMenaxhimiPalesterApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SistemMenaxhimiPalesterApplication.class, args);
	}


}
