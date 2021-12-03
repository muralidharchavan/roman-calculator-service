package com.tddpractice.roman.calculator.rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.tddpractice.roman.calculator.RomanCalculator;


@Path("/calculator")
@RequestScoped
public class CalculatorEndpoint {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/add")
	public Response add(@QueryParam("operands") String operands) {
		String result = "";
		ResponseBuilder responseBuilder = Response.noContent();
		RomanCalculator calculator = new RomanCalculator();
		try {
			result = calculator.add(operands);
		} catch (Exception iae) {
			return responseBuilder.status(400).entity(iae.getMessage()).build();
		}

		return responseBuilder.status(200).entity(result).build();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/subtract")
	public Response subtract(@QueryParam("operands") String operands) {
		String result = "";
		ResponseBuilder responseBuilder = Response.noContent();
		RomanCalculator calculator = new RomanCalculator();
		try {
			result = calculator.subtract(operands);
		} catch (Exception iae) {
			return responseBuilder.status(400).entity(iae.getMessage()).build();
		}

		return responseBuilder.status(200).entity(result).build();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/multiply")
	public Response multiply(@QueryParam("operands") String operands) {
		String result = "";
		ResponseBuilder responseBuilder = Response.noContent();
		RomanCalculator calculator = new RomanCalculator();
		try {
			result = calculator.multiply(operands);
		} catch (Exception iae) {
			return responseBuilder.status(400).entity(iae.getMessage()).build();
		}

		return responseBuilder.status(200).entity(result).build();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/divide")
	public Response divide(@QueryParam("operands") String operands) {
		String result = "";
		ResponseBuilder responseBuilder = Response.noContent();
		RomanCalculator calculator = new RomanCalculator();
		try {
			result = calculator.divide(operands);
		} catch (Exception iae) {
			return responseBuilder.status(400).entity(iae.getMessage()).build();
		}

		return responseBuilder.status(200).entity(result).build();
	}

}
