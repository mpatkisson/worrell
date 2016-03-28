package worrell.config;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Configures the application.
 */
public class Configuration {

    private int queryFrequency;
    private List<Service> services;
    private List<Quote> quotes;

    /**
     * Gets the frequency with which to refresh quotes.
     * @return The query frequency with a minimum value of 0;
     */
    public int getQueryFrequency() {
        return queryFrequency;
    }

    /**
     * Sets the frequency with which to refresh quotes.
     * @param queryFrequency A non-negative integer.  If 0 is argued then quotes will not be refreshed.
     */
    @JacksonXmlProperty(localName = "query-frequency")
    public void setQueryFrequency(int queryFrequency) {
        if (queryFrequency < 0) {
            queryFrequency = 0;
        }
        this.queryFrequency = queryFrequency;
    }

    /**
     * Gets a non-null list of services to be configured.
     */
    public List<Service> getServices() {
        return services;
    }

    /**
     * Sets a list of services to be configured.  If null is argued the list will be set to an empty list.
     */
    public void setServices(List<Service> services) {
        if (services == null) {
            services = new ArrayList<>();
        }
        this.services = services;
    }

    /**
     * Gets a non-null list of securities to be quoted.
     */
    public List<Quote> getQuotes() {
        return quotes;
    }

    /**
     * Sets a list of securities to be quoted.  If null is argued the list will be set to an empty list.
     */
    public void setQuotes(List<Quote> quotes) {
        if (quotes == null) {
            quotes = new ArrayList<>();
        }
        this.quotes = quotes;
    }

}
