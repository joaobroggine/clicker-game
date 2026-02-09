package br.com.git.clicker_game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import br.com.git.clicker_game.config.SpringContext;
import br.com.git.clicker_game.view.Interface;

@SpringBootApplication
public class ClickerGameApplication {

	public static void main(String[] args) {

		System.setProperty("java.awt.headless", "false");
		
		new Thread(() -> {
			ApplicationContext ctx = SpringApplication.run(ClickerGameApplication.class, args);
			SpringContext.setApplicationContext(ctx);
		}, "spring-boot").start();

		Interface.launch(Interface.class, args);
	}

}
