package marius.tset.com.data;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum PriceComponents {
    BASE("base price", 5),
    ALLOY("alloy surcharge", 2.15),
    SCRAP("scrap surcharge", 3.14),
    INTERNAL("internal surcharge", 0.7658),
    EXTERNAL("external surcharge", 1),
    STORAGE("storage surcharge", 0.3);

    private String component;
    private double value;

    PriceComponents(String component, double value) {
        this.component = component;
        this.value = value;
    }

    public String getComponent() {
        return component;
    }

    public double getValue() {
        return value;
    }

}
