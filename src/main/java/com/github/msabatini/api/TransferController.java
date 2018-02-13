package com.github.msabatini.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.accepted;

@Path("v1/customers")
public class TransferController
{
  @POST
  @Path("/{customerId}/transfers")
  @Consumes(APPLICATION_JSON)
  public Response transfer(@PathParam("customerId") String customerId, TransferRequestDTO dto)
  {
    return accepted().build();
  }
}
