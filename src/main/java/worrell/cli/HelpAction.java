package worrell.cli;

/**
 * Displays simple help information.
 */
public class HelpAction extends Action {

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public void run(String[] args) {
        System.out.println("usage: java -jar worrell.jar [COMMAND]");
        System.out.println();
        System.out.println("    quote          - Displays a quote for a security.");
        System.out.println("    version        - Displays the version number.");
        System.out.println("    help           - Displays this help message.");
        System.out.println();
    }

}
