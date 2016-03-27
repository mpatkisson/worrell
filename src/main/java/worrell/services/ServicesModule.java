package worrell.services;

import com.google.inject.AbstractModule;

/**
 * A Guice IOC Module.
 */
public class ServicesModule extends AbstractModule {

    /**
     * Configures the Guice bindings.
     */
    @Override
    protected void configure() {
        bind(QuoteService.class).to(YahooFinanceQuoteService.class);
    }
}
