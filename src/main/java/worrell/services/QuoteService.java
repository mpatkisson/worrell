package worrell.services;

import java.math.BigDecimal;

/**
 * Provides market data such as price, bid and ask for a security.
 */
public interface QuoteService {

    void setSymbol(String symbol);
    BigDecimal getPrice();
    BigDecimal getBid();
    BigDecimal getAsk();

}
