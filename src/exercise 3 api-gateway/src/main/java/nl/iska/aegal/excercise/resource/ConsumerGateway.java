package nl.iska.aegal.excercise.resource;

import feign.Feign;
import feign.RequestLine;
import feign.gson.GsonDecoder;
import io.dropwizard.discovery.client.DiscoveryClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by vagrant on 12/8/14.
 */
@Path("/api/v1/consumer")
public class ConsumerGateway {

    private final DiscoveryClient client;

    interface ConsumerApi {
        @RequestLine("GET /")
        List<String> getConsumer();
    }

    public ConsumerGateway(final DiscoveryClient client) {
        this.client = client;
    }

    @GET
    @Produces("application/json")
    public List<String> getConsumer() throws Exception {
        ConsumerApi consumerApi = Feign.builder()
                .decoder(new GsonDecoder())
                .target(ConsumerApi.class, "http://" + client.getInstance().getAddress() + ":" + client.getInstance().getPort());
        return consumerApi.getConsumer();
    }


}
