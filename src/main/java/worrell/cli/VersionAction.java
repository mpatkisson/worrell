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
<<<<<<< HEAD
        System.out.println("0.1.0-SNAPSHOT");
=======
<<<<<<< HEAD
        System.out.println("0.2.0-SNAPSHOT");
=======
        System.out.println("0.1.0");
>>>>>>> ac752f5... Resolves #5 - Corrects bad version print in CLI
>>>>>>> e1b221d... Resolves #5 - Corrects bad version print in CLI
    }

}
