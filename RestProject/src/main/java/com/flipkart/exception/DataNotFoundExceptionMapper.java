package com.flipkart.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.bean.CustomerError;

@Provider
public class DataNotFoundExceptionMapper  implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {

		System.out.println("Exception Mapper");
		
		CustomerError error = new  CustomerError(ex.getMessage(), Status.NOT_FOUND.toString(), "http:datanotfound");
		
		return Response.status(Status.NOT_FOUND).entity(error).build();
	}

}
