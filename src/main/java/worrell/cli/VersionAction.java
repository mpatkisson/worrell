package worrell.cli;

/**
 * Displays simple help information.
 */
public class VersionAction extends Action {

    @Override
    public String getName() {
        return "version";
    }

    @Override
    public void run(String[] args) {
        String version = getClass().getPackage().getImplementationVersion();
        System.out.println(version);
    }

}
