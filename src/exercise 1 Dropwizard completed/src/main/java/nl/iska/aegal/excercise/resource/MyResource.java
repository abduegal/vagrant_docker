package nl.iska.aegal.excercise.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by vagrant on 12/6/14.
 */
@Path("/")
public class MyResource {

    @GET
    public String helloWorld() {
        return "Hello world!";
    }

}
