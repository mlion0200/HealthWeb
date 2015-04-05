package main.resources.com.web.dhealth;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.*;

@Path("/Resource")
public class FirstResources {
	/*
	@GET
	@Path("/{parameter}")
	public Response responseMsg( @PathParam("parameter") String parameter,
			@DefaultValue("Nothing to say") @QueryParam("value") String value) {

		String output = "Hello from: " + parameter + " : " + value;

		return Response.status(200).entity(output).build();
	}
	*/
	@GET
	@Path("redirect")
	public void redirectPage(@Context final HttpServletRequest request,
			@Context final HttpServletResponse response) throws IOException {
		response.sendRedirect("login.jsp");
	}
	
	@POST
	@Path("/send")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createReportinJson(String s) throws JSONException
	{
		JSONObject dataJson = new JSONObject(s);
		reportData rpt = new reportData(dataJson);
		int id = rpt.getReportId();
		String output = "Report id: " + id + rpt.getDataById(id);
		return Response.status(200).entity(output).build();
	}
}
