package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class AttributesForAsserting {
    private final Logger LOGGER = (Logger) LogManager.getLogger(this.getClass());
    private BaseFunctions baseFunctions;

    public AttributesForAsserting(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public String title = "Car Rental – Search, Compare, and Save up to 70%!";
    public String titleInEnForLv = "Car Rental in Latvia";
    public String titleInLvForLv = "Auto noma Latvijā";
    public String numberOfCountries = "45";
    public String unableToFindLocation = "Unable to find any location";
    public String warningMsg = "Select a pick-up location";


}
