package nl.iska.aegal.excercise.resource;

import feign.Feign;
import feign.RequestLine;
import io.dropwizard.discovery.client.DiscoveryClient;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by vagrant on 12/8/14.
 */
@Path("/api/v1/producer")
public class ProducerGateway {

    private final DiscoveryClient client;

    interface ProducerApi {
        @RequestLine("GET /send/{message}")
        String sendMessage(@Named("message") String message);
    }

    public ProducerGateway(final DiscoveryClient client) {
        this.client = client;
    }

    @GET
    @Path("{message}")
    @Produces("application/json")
    public String getProducer(@PathParam("message") String message) throws Exception {
        ProducerApi producerApi = Feign.builder()
                .target(ProducerApi.class, "http://" + client.getInstance().getAddress() + ":" + client.getInstance().getPort());

        return producerApi.sendMessage(message);
    }


}
