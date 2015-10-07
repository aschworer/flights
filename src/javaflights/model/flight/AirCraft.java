package javaflights.model.flight;

/**
 * The instance of <code>AirCraft</code> class represents some particular air air craft
 * AirCompany has model, firm, maximum baggage weight per person, number of seats
 * of business, first and econom class availible.
 *
 * @author Aigul Zainullina
 * @see javaflights.flight
 */
public class AirCraft {
    private String model;
    private String firm;
    private int baggageMaxKG;
    private int numberOfSeatsFirstClass;
    private int numberOfSeatsBusinessClass;
    private int numberOfSeatsEconomClass;

    /**
     * Constructor assumes only proper values according to required types
     *
     * @param model
     * @param firm
     * @param baggageMaxKG
     * @param numberOfSeatsFirstClass
     * @param numberOfSeatsBusinessClass
     * @param numberOfSeatsEconomClass
     */
    public AirCraft(String model, String firm, int baggageMaxKG, int numberOfSeatsFirstClass,
                    int numberOfSeatsBusinessClass, int numberOfSeatsEconomClass) {
        this.model = model;
        this.firm = firm;
        this.baggageMaxKG = baggageMaxKG;
        this.numberOfSeatsFirstClass = numberOfSeatsFirstClass;
        this.numberOfSeatsBusinessClass = numberOfSeatsBusinessClass;
        this.numberOfSeatsEconomClass = numberOfSeatsEconomClass;
    }

    public int getBaggageMaxKG() {
        return baggageMaxKG;
    }

    public String getModel() {
        return model;
    }

    public String getFirm() {
        return firm;
    }

    public int getNumberOfSeatsFirstClass() {
        return numberOfSeatsFirstClass;
    }

    public int getNumberOfSeatsBusinessClass() {
        return numberOfSeatsBusinessClass;
    }

    public int getNumberOfSeatsEconomClass() {
        return numberOfSeatsEconomClass;
    }
}
