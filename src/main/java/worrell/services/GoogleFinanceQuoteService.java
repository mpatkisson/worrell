package worrell.services;

import worrell.models.Security;

import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;

/**
 * Provides market data such as price, bid and ask for a security using Yahoo Finance via the YahooFinnance Java API.
 */
public class GoogleFinanceQuoteService implements QuoteService {

    /**
     * Gets a quote from Google Finance.
     * @param symbol The symbol used to reference the security.
     * @return A Security containing market information about the security.
     */
    @Override
    public Security getQuote(String symbol) {
        Security security = new Security();
        try {
        } catch (IOException e) {
            throw new ServiceRuntimeException("Unable to lookup symbol with Google Finance", e);
        }
        return security;
    }



}
