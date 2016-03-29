package worrell.services;

import worrell.models.Security;

/**
 * Provides market data such as price, bid and ask for a security.
 */
public interface QuoteService {

    /**
     * Gets a market quote for a security.
     * @param symbol The symbol used to reference the security.
     * @return A market quote for the security.
     */
    Security getQuote(String symbol);

}
