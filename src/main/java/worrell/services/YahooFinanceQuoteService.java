package worrell.services;

import worrell.models.Security;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;

/**
 * Provides market data such as price, bid and ask for a security using Yahoo Finance via the YahooFinnance Java API.
 */
public class YahooFinanceQuoteService implements QuoteService {

    public YahooFinanceQuoteService() {
        YahooFinance.logger.setLevel(Level.OFF);
    }

    /**
     * Gets a quote from Yahoo Finance.
     * @param symbol The symbol used to reference the security.
     * @return A Security containing market information about the security.
     */
    @Override
    public Security getQuote(String symbol) {
        Security security = new Security();
        try {
            Stock stock = YahooFinance.get(symbol);
            StockQuote yahooQuote = stock.getQuote();
            security.setSymbol(symbol);
            security.setAsk(yahooQuote.getAsk());
            security.setAskSize(yahooQuote.getAskSize());
            security.setBid(yahooQuote.getBid());
            security.setBidSize(yahooQuote.getBidSize());
            security.setPrice(yahooQuote.getPrice());
            Calendar lastTrade = yahooQuote.getLastTradeTime();
            if (lastTrade != null) {
                security.setLastTrade(lastTrade.getTime());
            }
        } catch (IOException e) {
            throw new ServiceRuntimeException("Unable to lookup symbol with Yahoo Finance", e);
        }
        return security;
    }

}
