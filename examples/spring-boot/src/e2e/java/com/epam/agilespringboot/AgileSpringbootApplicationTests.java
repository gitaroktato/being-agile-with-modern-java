package com.epam.agilespringboot;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class AgileSpringbootApplicationTests {

	private static final HttpResponse.BodyHandler<String> AS_STRING = HttpResponse.BodyHandlers.ofString();
	private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder()
			.version(HttpClient.Version.HTTP_2)
			.followRedirects(HttpClient.Redirect.NORMAL)
			.build();


	@Test
	public void testGetPerson() throws IOException, InterruptedException {

		var getPersonRequest = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8080/person/1"))
				.timeout(Duration.ofSeconds(10))
				.header("Content-Type", "application/json")
				.build();

		var getPersonResponse = HTTP_CLIENT.send(getPersonRequest, AS_STRING);

		Assert.assertEquals(200, getPersonResponse.statusCode());
		Assert.assertTrue(getPersonResponse.body().contains("firstName"));
		Assert.assertTrue(getPersonResponse.body().contains("lastName"));
	}

	@Test
	public void testGetLegacyPerson() throws IOException, InterruptedException {

		var getPersonRequest = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8080/v1/person/1"))
				.timeout(Duration.ofSeconds(10))
				.header("Content-Type", "application/json")
				.build();

		var getPersonResponse = HTTP_CLIENT.send(getPersonRequest, AS_STRING);

		Assert.assertEquals(200, getPersonResponse.statusCode());
		Assert.assertTrue(getPersonResponse.body().contains("fullName"));
	}

}
