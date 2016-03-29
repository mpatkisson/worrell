package worrell.config;

/**
 * Represents configuration of a Security.
 */
public class Quote {

    private String symbol;

    /**
     * Gets the symbol associated with the quote.
     * @return The ticker symbol of the quoted security.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Sets the symbol associated with the quote.
     * @param symbol The ticker symbol of the quoted security.
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
