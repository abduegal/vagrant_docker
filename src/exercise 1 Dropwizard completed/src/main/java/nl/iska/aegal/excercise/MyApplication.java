package nl.iska.aegal.excercise;


import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nl.iska.aegal.excercise.resource.MyResource;

/**
 * Created by vagrant on 12/6/14.
 */
public class MyApplication extends Application<MyConfiguration> {

    public static void main(String[] args) throws Exception {
        new MyApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<MyConfiguration> bootstrap) {
    }

    @Override
    public void run(MyConfiguration myConfiguration, Environment environment) throws Exception {
        environment.jersey().register(MyResource.class);
    }
}
