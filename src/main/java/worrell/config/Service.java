package worrell.config;

/**
 * Represents configuration of a service.
 */
public class Service {

    private String name;
    private String type;

    /**
     * Gets the name of the abstract service to be bound.
     * @return The name of the abstract service.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the abstract service to be bound.
     * @param name The fully qualified name of the abstract service.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the concrete type to bind.
     * @return The fully qualified name of the concrete type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the name of the concrete type to bind.
     * @param type The fully qualified name of the concrete type.
     */
    public void setType(String type) {
        this.type = type;
    }
}
