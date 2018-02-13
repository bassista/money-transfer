package com.github.msabatini;

import com.github.msabatini.domain.usecase.MoneyTransfer;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

import static org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory.createHttpServer;

public class Application
{
  public static final String BASE_URI = "http://localhost:8080/api/";
  private static final String RESOURCE_PACKAGE = "com.github.msabatini.api";

  public static void main(String[] args)
  {
    startServer();
  }

  public static HttpServer startServer()
  {
    return createHttpServer(URI.create(BASE_URI),
                            new ResourceConfig()
                              .register(new Configuration())
                              .packages(RESOURCE_PACKAGE));
  }

  static class Configuration extends AbstractBinder
  {
    @Override protected void configure()
    {
      MoneyTransfer transferService = new MoneyTransfer();
      bind(transferService).to(MoneyTransfer.class);
    }
  }
}
