package nl.iska.aegal.excercise;

import io.dropwizard.Configuration;

/**
 * Created by vagrant on 12/6/14.
 */
public class MyConfiguration extends Configuration {

    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
