package worrell.services;

import com.google.inject.AbstractModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import worrell.config.Configuration;
import worrell.config.Service;

/**
 * A Guice IOC Module.
 */
public class ServicesModule extends AbstractModule {

    private Configuration configuration;
    protected final Logger log = LoggerFactory.getLogger(getClass());

    public ServicesModule(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * Configures the Guice bindings.
     */
    @Override
    protected void configure() {
        try {
            for (Service service : configuration.getServices()) {
                Class abstractType = Class.forName(service.getName());
                Class concreteType = Class.forName(service.getType());
                bind(abstractType).to(concreteType);
            }
        } catch (ClassNotFoundException e) {
            throw new ServiceRuntimeException("Unable to bind types in ServicesModule", e);
        }
    }
}
