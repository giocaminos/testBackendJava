package com.app.model.service;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.app.model.entity.Data;
import com.app.model.entity.Timezone;
import com.app.util.Constantes;
import com.google.gson.Gson;

public class ConexionAPIService {

	private String date;
	private String country;

	public ConexionAPIService(String date, String country) {
		super();
		this.date = date;
		this.country = country;
	}

	public String getCountries() {
		return "";
	}

	public String conexionAPI_TIMEZONE() {
		try {
			HttpClient client = HttpClients.createDefault();

			String stubsApiBaseUri = Constantes.URL_BASE_TIMEZONE + country + "&date=" + date + "&token="
					+ Constantes.TOKEN_API_TIMEZONE;
System.out.println(stubsApiBaseUri);
			URIBuilder builder = new URIBuilder(stubsApiBaseUri);

			String listStubsUri = builder.build().toString();
			HttpGet getStubMethod = new HttpGet(listStubsUri);
			HttpResponse getStubResponse = client.execute(getStubMethod);

			String responseBody = EntityUtils.toString(getStubResponse.getEntity());
			
			return responseBody;

		} catch (URISyntaxException | IOException e) {
			return "Error al Conectarse a la API";
		}

	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
