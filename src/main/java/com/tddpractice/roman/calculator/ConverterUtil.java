package com.tddpractice.roman.calculator;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ConverterUtil implements IConverterUtil  {
	
	private static final String CONVERTER_URL = "https://roman-converter-svc-tdd-bk.eco-training-f2c6cdc6801be85fd188b09d006f13e3-0000.us-east.containers.appdomain.cloud/roman/converter/";

	@Override
	public int convertToNumber(String rom) throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String result = "0";
		try {

			HttpGet request = new HttpGet(CONVERTER_URL + "to-number?value="+rom);

			CloseableHttpResponse response = httpClient.execute(request);

			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					result = EntityUtils.toString(entity);
				}

			} finally {
				response.close();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Integer.valueOf(result);
	}
	
	@Override
	public String convertToRoman(int num) throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String result = "0";
		try {

			HttpGet request = new HttpGet(CONVERTER_URL + "to-roman?value="+num);

			CloseableHttpResponse response = httpClient.execute(request);

			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					result = EntityUtils.toString(entity);
				}

			} finally {
				response.close();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}



}
