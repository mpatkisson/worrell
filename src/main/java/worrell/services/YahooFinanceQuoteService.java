package worrell.services;

import worrell.models.Quote;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

import java.io.IOException;
import java.util.logging.Level;

/**
 * Provides market data such as price, bid and ask for a security using Yahoo Finance via the YahooFinnance Java API.
 */
public class YahooFinanceQuoteService implements QuoteService {

    public YahooFinanceQuoteService() {
        YahooFinance.logger.setLevel(Level.SEVERE);
    }

    /**
     * Gets a quote from Yahoo Finance.
     * @param symbol The symbol used to reference the security.
     * @return
     */
    @Override
    public Quote getQuote(String symbol) {
        Quote quote = new Quote();
        try {
            Stock stock = YahooFinance.get(symbol);
            StockQuote yahooQuote = stock.getQuote();
            quote.setSymbol(symbol);
            quote.setAsk(yahooQuote.getAsk());
            quote.setAskSize(yahooQuote.getAskSize());
            quote.setBid(yahooQuote.getBid());
            quote.setBidSize(yahooQuote.getBidSize());
            quote.setPrice(yahooQuote.getPrice());
            quote.setLastTrade(yahooQuote.getLastTradeTime().getTime());
        } catch (IOException e) {
            throw new ServiceRuntimeException("Unable to lookup symbol with Yahoo Finance", e);
        }
        return quote;
    }

}
