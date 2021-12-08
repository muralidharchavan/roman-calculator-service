package com.tdd.practice.pact.consumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.IOUtils;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.PactSpecVersion;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;

@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "converter",port = "1234",pactVersion = PactSpecVersion.V3)
public class ConverterConsumerPactTest {
	
	private Map<String, String> headers = MapUtils.putAll(new HashMap<>(), new String[] {
		    "Content-Type", "text/plain"
		  });

	@BeforeEach
	  public void setUp(MockServer mockServer) {
		System.out.println("Mock server " + mockServer);
	    assertThat(mockServer, is(notNullValue()));
	  }
	
    @Pact(consumer="calculator")
    public RequestResponsePact convertToNumber(PactDslWithProvider builder) {
        return builder
        	      .given("roman numeral")
        	      .uponReceiving("convert to number")
        	        .path("/to-number")
        	        .method("GET")
        	        .query("value=III")
        	      .willRespondWith()
        	        .headers(headers)
        	        .status(200)
        	        .body(
        	          "3"
        	        )
        	      .toPact();
    }
    
    @Test
    @PactTestFor(pactMethod = "convertToNumber")
    void test(MockServer mockServer) throws IOException {
      ClassicHttpResponse httpResponse =  (ClassicHttpResponse) Request.get(mockServer.getUrl() + "/to-number?value=III").execute().returnResponse();
      assertThat(httpResponse.getCode(), is(equalTo(200)));
      assertThat(IOUtils.toString(httpResponse.getEntity().getContent()),
        is(equalTo("3")));

    }
}
