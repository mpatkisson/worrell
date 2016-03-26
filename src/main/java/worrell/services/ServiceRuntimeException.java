package worrell.services;

/**
 * A package specific Runtime exception.
 */
public class ServiceRuntimeException extends RuntimeException {

    public ServiceRuntimeException() {
        super();
    }

    public ServiceRuntimeException(String s) {
        super(s);
    }

    public ServiceRuntimeException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ServiceRuntimeException(Throwable throwable) {
        super(throwable);
    }

}
