package nl.iska.aegal.excercise.resource;

import nl.iska.aegal.excercise.ConsumerListener;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by vagrant on 12/7/14.
 */
@Path("/")
public class ConsumerResource {

    @GET
    @Produces("application/json")
    public List<String> getMessages() {
        return ConsumerListener.getInstance().getMessages();
    }

}
