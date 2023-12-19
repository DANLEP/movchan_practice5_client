
package ua.nure.location.entity;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * <p>Java class for SeasonalityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="SeasonalityType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Summer"/&gt;
 *     &lt;enumeration value="Winter"/&gt;
 *     &lt;enumeration value="All Season"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SeasonalityType")
@XmlEnum
public enum SeasonalityType {

    @XmlEnumValue("Summer")
    SUMMER("Summer"),
    @XmlEnumValue("Winter")
    WINTER("Winter"),
    @XmlEnumValue("All Season")
    ALL_SEASON("All Season");
    private final String value;

    SeasonalityType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SeasonalityType fromValue(String v) {
        for (SeasonalityType c: SeasonalityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

    public String getValue() {
        return value;
    }

    public static List<String> getStringValues() {
        return Arrays.stream(SeasonalityType.values())
                .map(SeasonalityType::getValue)
                .collect(Collectors.toList());
    }

}
