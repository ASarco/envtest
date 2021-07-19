package com.imgarena.envtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EnvtestApplicationTests {

	@Value("${DOG_NAME:}")
	private String dogName;

	@Test
	void contextLoads() {

		assertThat(dogName)
				.as("The dog name is Cocolulu")
				.isNotBlank()
				.hasSize(8)
				.isEqualTo("Cocolulu");

		String catName = System.getenv("CAT_NAME");
		assertThat(catName)
				.as("The cat name is Chocha")
				.isNotBlank()
				.hasSize(6)
				.isEqualTo("Chocha");
	}
}
