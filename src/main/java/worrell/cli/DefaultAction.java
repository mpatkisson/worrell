package worrell.cli;

import worrell.config.Quote;
import worrell.models.Security;
import worrell.services.QuoteService;

import javax.inject.Inject;
import java.io.IOException;

/**
 * Displays a single quote given a ticker symbol.
 */
public class DefaultAction extends Action {

    private QuoteService service;

    @Inject
    public DefaultAction(QuoteService service) {
        this.service = service;
    }

    @Override
    public String getName() {
        return "default";
    }

    @Override
    public void run(String[] args) throws IOException {
        for (Quote quote : App.getConfiguration().getQuotes()) {
            Security security = service.getQuote(quote.getSymbol());
            log.info(security.toString());
        }
    }

}
