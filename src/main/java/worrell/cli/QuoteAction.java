package worrell.cli;

import com.google.common.base.Strings;
import worrell.models.Security;
import worrell.services.QuoteService;

import javax.inject.Inject;
import java.io.IOException;

/**
 * Displays a single quote given a ticker symbol.
 */
public class QuoteAction extends Action {

    private QuoteService service;

    @Inject
    public QuoteAction(QuoteService service) {
        this.service = service;
    }

    @Override
    public String getName() {
        return "quote";
    }

    @Override
    public void run(String[] args) throws IOException {
        String symbol = getFirstCommandArgument(args);
        if (Strings.isNullOrEmpty(symbol)) {
            String message = "You must supply the ticker symbol ID of security you wish to quote.\n\n" +
                    "usage: java -jar rcwm.jar quote [SYMBOL]";
            log.info(message);
        } else {
            if (symbol.contains(",")) {
                String[] symbols = symbol.split(",");
                for (String sym : symbols) {
                    logSecurityInfo(sym);
                }
            } else {
                logSecurityInfo(symbol);
            }
        }
    }

    private void logSecurityInfo(String symbol) {
        Security security = service.getQuote(symbol);
        log.info(security.toString());
    }

}
