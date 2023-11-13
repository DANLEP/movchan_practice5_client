
package ua.nure.location.entity;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ua.nure.location.entity package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Place_QNAME = new QName("http://location.nure.ua/entity", "place");
    private final static QName _Places_QNAME = new QName("http://location.nure.ua/entity", "places");
    private final static QName _Return_QNAME = new QName("http://location.nure.ua/entity", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ua.nure.location.entity
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Location }
     * 
     */
    public Location createLocation() {
        return new Location();
    }

    /**
     * Create an instance of {@link AddressType }
     * 
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link Place }
     * 
     */
    public Place createPlace() {
        return new Place();
    }

    /**
     * Create an instance of {@link Entity }
     * 
     */
    public Entity createEntity() {
        return new Entity();
    }

    /**
     * Create an instance of {@link CoordinateType }
     * 
     */
    public CoordinateType createCoordinateType() {
        return new CoordinateType();
    }

    /**
     * Create an instance of {@link PriceDetail }
     * 
     */
    public PriceDetail createPriceDetail() {
        return new PriceDetail();
    }

    /**
     * Create an instance of {@link Location.Area }
     * 
     */
    public Location.Area createLocationArea() {
        return new Location.Area();
    }

    /**
     * Create an instance of {@link Location.Places }
     * 
     */
    public Location.Places createLocationPlaces() {
        return new Location.Places();
    }

    /**
     * Create an instance of {@link AddressType.HouseNumber }
     * 
     */
    public AddressType.HouseNumber createAddressTypeHouseNumber() {
        return new AddressType.HouseNumber();
    }

    /**
     * Create an instance of {@link Place.Photos }
     * 
     */
    public Place.Photos createPlacePhotos() {
        return new Place.Photos();
    }

    /**
     * Create an instance of {@link Place.Tags }
     * 
     */
    public Place.Tags createPlaceTags() {
        return new Place.Tags();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Place }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Place }{@code >}
     */
    @XmlElementDecl(namespace = "http://location.nure.ua/entity", name = "place")
    public JAXBElement<Place> createPlace(Place value) {
        return new JAXBElement<Place>(_Place_QNAME, Place.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Place }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Place }{@code >}
     */
    @XmlElementDecl(namespace = "http://location.nure.ua/entity", name = "places")
    public JAXBElement<Place> createPlaces(Place value) {
        return new JAXBElement<Place>(_Places_QNAME, Place.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Place }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Place }{@code >}
     */
    @XmlElementDecl(namespace = "http://location.nure.ua/entity", name = "return")
    public JAXBElement<Place> createReturn(Place value) {
        return new JAXBElement<Place>(_Return_QNAME, Place.class, null, value);
    }

}
