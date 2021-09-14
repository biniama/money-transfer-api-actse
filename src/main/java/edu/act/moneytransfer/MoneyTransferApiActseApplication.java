package edu.act.moneytransfer;

import edu.act.moneytransfer.domains.Account;
import edu.act.moneytransfer.repositories.AccountRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MoneyTransferApiActseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneyTransferApiActseApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:3000", "https://money-transfer-web-app-actse.herokuapp.com");
						//.allowedOrigins("*");
			}
		};
	}

	// Class vs Interface
	//Account account = new Account(); // works

	//'AccountRepository' is abstract; cannot be instantiated
	//AccountRepository accountRepository = new AccountRepository(); // doesn't work

}
