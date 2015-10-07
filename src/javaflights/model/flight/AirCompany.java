package javaflights.model.flight;

/**
 * The instance of <code>AirCompany</code> class represents some particular air company
 * AirCompany has name (flied <code>name</code>)
 *
 * @author Aigul Zainullina
 * @see javaflights.flight
 */
public class AirCompany {
    String name;

    public AirCompany(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
