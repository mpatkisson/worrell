package worrell.services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import worrell.config.Quote;
import worrell.models.Security;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
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
            HttpResponse<JsonNode> json = Unirest.get("http://google.com/finance?q=jcp").asJson();
            JSONObject map = json.getBody().getObject();
            security.setSymbol(map.getString("t"));
            security.setPrice(new BigDecimal(map.getString("l")));
            security.setBid(null);
            security.setBidSize(0);
            security.setAsk(null);
            security.setAskSize(0);
            // Mar 31, 6:49PM EDT
            DateFormat format = new SimpleDateFormat("M dd, h:mm", Locale.ENGLISH);
            Date date = format.parse(string);
            security.setLastTrade(new Date(map.getString("elt")));
        } catch (UnirestException e) {
            throw new ServiceRuntimeException("Unable to lookup symbol with Google Finance", e);
        }
        return security;
    }



}
