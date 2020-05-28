package com.ngatdo.restws;

import com.ngatdo.restws.dto.SumRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class RestwsApplicationTests {

	@LocalServerPort
	private int port;

	@Test
	void testSum() {
		String url = "http://localhost:" + port + "/calculator/sum";
		RestTemplate template = new RestTemplate();
		SumRequestDTO request = new SumRequestDTO();
		request.setFirstNumber(10);
		request.setSecondNumber(20);
		ResponseEntity<Integer> result = template.exchange(url, HttpMethod.POST, new HttpEntity<>(request), Integer.class);
		System.out.println(result.getBody());
		assertThat(result.getBody() == 30);
	}

}
