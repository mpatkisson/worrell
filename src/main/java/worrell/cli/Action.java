package worrell.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An action to be performed by the application.
 */
public abstract class Action {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * Gets the name of the action.
     * @return The name of the action.
     */
    public abstract String getName();

    /**
     * Performs the application action.
     * @param args Command line arguments.
     */
    public abstract void run(String[] args) throws Exception;

    /**
     * Gets the first command line argument.
     * @param args Command line arguments passed when the app is run.
     * @return The first argument or null if no argument was supplied.
     */
    protected String getFirstCommandArgument(String[] args) {
        String symbol = null;
        if (args.length > 1) {
            symbol = args[1];
        }
        return symbol;
    }

}
