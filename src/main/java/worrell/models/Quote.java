package worrell.models;

import com.google.common.base.Strings;

import java.math.BigDecimal;
import java.util.Date;

/**
 * A market quote for a security.
 */
public class Quote {

    private int bidSize = 0;
    private int askSize = 0;
    private String symbol = "";
    private Date lastTrade = new Date(0L);
    private BigDecimal price = BigDecimal.ZERO;
    private BigDecimal bid = BigDecimal.ZERO;
    private BigDecimal ask = BigDecimal.ZERO;

    /**
     * Gets the symbol of the security being quoted.
     * @return The symbol of the security being quoted or an empty string if not found.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Sets (and upper cases) the symbol of the security being quoted.  Will accept a null value, but will set the
     * symbol to an empty String if null is argued.
     * @param symbol The symbol of the security being quoted.
     */
    public void setSymbol(String symbol) {
        if (Strings.isNullOrEmpty(symbol)) {
            this.symbol = "";
        } else {
            this.symbol = symbol.toUpperCase();
        }
    }

    /**
     * Gets the market price of the quote.
     * @return The price or 0 if the security could not be found.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the price of the quote.
     * @param price The market price of the quote.
     */
    public void setPrice(BigDecimal price) {
        this.price = getAmount(price);
    }

    /**
     * Gets the market bidding price at the lastTrade of the quote.
     * @return The bid or 0 if the security could not be found.
     */
    public BigDecimal getBid() {
        return bid;
    }

    /**
     * Sets the market bidding price of the quote.
     * @param bid The market bidding price.
     */
    public void setBid(BigDecimal bid) {
        this.bid = getAmount(bid);
    }

    /**
     * Gets the size of the market bidding price at the lastTrade of the quote.
     * @return The size of the bid or 0 if the security could not be found.
     */
    public int getBidSize() {
        return bidSize;
    }

    /**
     * Sets the size of the bidding price at the lastTrade of the quote.
     * @param bidSize The market size of the bid.
     */
    public void setBidSize(int bidSize) {
        this.bidSize = bidSize;
    }

    /**
     * Gets the market asking price at the lastTrade of the quote.
     * @return The asking price or 0 if the security could not be found.
     */
    public BigDecimal getAsk() {
        return ask;
    }

    /**
     * Sets the market asking price at the lastTrade of the quote.
     * @param ask The market asking price.
     */
    public void setAsk(BigDecimal ask) {
        this.ask = getAmount(ask);
    }

    /**
     * Gets the size of the market asking price at the lastTrade of the quote.
     * @return The size of the market asking price or 0 if the security could not be found.
     */
    public int getAskSize() {
        return askSize;
    }

    /**
     * Sets the size of the market asking price.
     * @param askSize The size of the market asking price.
     */
    public void setAskSize(int askSize) {
        this.askSize = askSize;
    }

    /**
     * Gets the date and lastTrade of the quote as registered on the exchange.
     * @return The date and lastTrade the quote was registered on the exchange.
     */
    public Date getLastTrade() {
        return lastTrade;
    }

    /**
     * Sets the date and lastTrade of the quote as registered on the exchange.
     * @param lastTrade The date and lastTrade the quote was registered on the exchange or "Jan 01 01:00:00 GMT 1970" if the
     *             security was not found.
     */
    public void setLastTrade(Date lastTrade) {
        this.lastTrade = lastTrade;
    }

    /**
     * The String representation of the quote which looks similar to the following.
     *
     *   ABC: 1.00, bid: 1, ask: 1
     *
     * @return A String which looks similar to this
     */
    @Override
    public String toString() {
        return getSymbol().toUpperCase() + ": " +
               getPrice() + ", " +
               "bid: " + getBid() + ", " +
               "ask: " + getAsk();
    }

    /**
     * Gets the amount of a BigDecimal value ensuring the value is set to BigDecimal.ZERO rather than null or a
     * negative value.
     * @param amount
     */
    protected BigDecimal getAmount(BigDecimal amount) {
        BigDecimal value = BigDecimal.ZERO;
        if (amount != null && amount.compareTo(BigDecimal.ZERO) > -1) {
            value = amount;
        }
        return value;
    }

}
