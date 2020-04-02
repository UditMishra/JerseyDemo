package com.udit.JerseyDemo.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.udit.JerseyDemo.models.Message;
import com.udit.JerseyDemo.services.MessageService;

@Path("messages")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class MessageResource {

	private MessageService service = new MessageService();

	@GET
	public List<Message> getMessages() {
		return service.getMessages();
	}

	@GET
	@Path("/{id}")
	public Message getMessage(@PathParam("id") int id) {
		return service.getMessage(id);
	}

	@POST
	public Response createMessage(Message message, @Context UriInfo uriInfo) {
		Message newMessage = service.createMessage(message);
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId())).build();
		return Response.created(uri).entity(newMessage).build();
	}

	@PUT
	@Path("/{id}")
	public Message updateMessage(@PathParam("id") int id, Message message) {
		return service.updateMessage(id, message);
	}

	@DELETE
	@Path("/{id}")
	public void removeMessage(@PathParam("id") int id) {
		service.removeMessage(id);
	}
}
