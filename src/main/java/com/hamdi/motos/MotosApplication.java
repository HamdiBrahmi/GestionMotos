package com.hamdi.motos;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hamdi.motos.entities.Moto;
import com.hamdi.motos.service.MotoService;

@SpringBootApplication
public class MotosApplication implements CommandLineRunner {
	@Autowired
	MotoService motoService;
	public static void main(String[] args) {
		SpringApplication.run(MotosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		motoService.saveMoto(new Moto("Ducati Panigale V2", 3600.0, new Date()));
		motoService.saveMoto(new Moto("Harley-Davidson", 5600.0, new Date()));
		motoService.saveMoto(new Moto("Zero SR/S", 2900.0, new Date()));		
	}

}
