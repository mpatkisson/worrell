package worrell.services;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Level;

/**
 * Provides market data such as price, bid and ask for a security using Yahoo Finance via the YahooFinnance Java API.
 */
public class YahooFinanceQuoteService implements QuoteService {

    private Stock stock = null;

    public YahooFinanceQuoteService() {
        // This line turns logging off for the Yahoo Fiannce API.  There may be a better way to configure this.
        YahooFinance.logger.setLevel(Level.OFF);
    }

    @Override
    public void setSymbol(String symbol) {
        try {
            stock = YahooFinance.get(symbol);
        } catch (IOException e) {
            throw new ServiceRuntimeException("Unable to lookup symbol with Yahoo Finance", e);
        }
    }

    @Override
    public BigDecimal getPrice() {
        return stock.getQuote().getPrice();
    }

    @Override
    public BigDecimal getBid() {
        return stock.getQuote().getBid();
    }

    @Override
    public BigDecimal getAsk() {
        return stock.getQuote().getAsk();
    }
}
