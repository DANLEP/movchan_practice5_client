
package ua.nure.location.server.service;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ua.nure.location.server.service package. 
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

    private final static QName _DAOException_QNAME = new QName("http://location.nure.ua/server/service", "DAOException");
    private final static QName _ValidationFault_QNAME = new QName("http://location.nure.ua/server/service", "ValidationFault");
    private final static QName _AddPlace_QNAME = new QName("http://location.nure.ua/server/service", "addPlace");
    private final static QName _AddPlaceResponse_QNAME = new QName("http://location.nure.ua/server/service", "addPlaceResponse");
    private final static QName _ClientToken_QNAME = new QName("http://location.nure.ua/server/service", "clientToken");
    private final static QName _DeletePlace_QNAME = new QName("http://location.nure.ua/server/service", "deletePlace");
    private final static QName _DeletePlaceResponse_QNAME = new QName("http://location.nure.ua/server/service", "deletePlaceResponse");
    private final static QName _FindByActivityType_QNAME = new QName("http://location.nure.ua/server/service", "findByActivityType");
    private final static QName _FindByActivityTypeResponse_QNAME = new QName("http://location.nure.ua/server/service", "findByActivityTypeResponse");
    private final static QName _GetPlace_QNAME = new QName("http://location.nure.ua/server/service", "getPlace");
    private final static QName _GetPlaceResponse_QNAME = new QName("http://location.nure.ua/server/service", "getPlaceResponse");
    private final static QName _ListPlaces_QNAME = new QName("http://location.nure.ua/server/service", "listPlaces");
    private final static QName _ListPlacesResponse_QNAME = new QName("http://location.nure.ua/server/service", "listPlacesResponse");
    private final static QName _ServerToken_QNAME = new QName("http://location.nure.ua/server/service", "serverToken");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ua.nure.location.server.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DAOException }
     * 
     */
    public DAOException createDAOException() {
        return new DAOException();
    }

    /**
     * Create an instance of {@link ValidationException }
     * 
     */
    public ValidationException createValidationException() {
        return new ValidationException();
    }

    /**
     * Create an instance of {@link AddPlace }
     * 
     */
    public AddPlace createAddPlace() {
        return new AddPlace();
    }

    /**
     * Create an instance of {@link AddPlaceResponse }
     * 
     */
    public AddPlaceResponse createAddPlaceResponse() {
        return new AddPlaceResponse();
    }

    /**
     * Create an instance of {@link SecurityHeader }
     * 
     */
    public SecurityHeader createSecurityHeader() {
        return new SecurityHeader();
    }

    /**
     * Create an instance of {@link DeletePlace }
     * 
     */
    public DeletePlace createDeletePlace() {
        return new DeletePlace();
    }

    /**
     * Create an instance of {@link DeletePlaceResponse }
     * 
     */
    public DeletePlaceResponse createDeletePlaceResponse() {
        return new DeletePlaceResponse();
    }

    /**
     * Create an instance of {@link FindByActivityType }
     * 
     */
    public FindByActivityType createFindByActivityType() {
        return new FindByActivityType();
    }

    /**
     * Create an instance of {@link FindByActivityTypeResponse }
     * 
     */
    public FindByActivityTypeResponse createFindByActivityTypeResponse() {
        return new FindByActivityTypeResponse();
    }

    /**
     * Create an instance of {@link GetPlace }
     * 
     */
    public GetPlace createGetPlace() {
        return new GetPlace();
    }

    /**
     * Create an instance of {@link GetPlaceResponse }
     * 
     */
    public GetPlaceResponse createGetPlaceResponse() {
        return new GetPlaceResponse();
    }

    /**
     * Create an instance of {@link ListPlaces }
     * 
     */
    public ListPlaces createListPlaces() {
        return new ListPlaces();
    }

    /**
     * Create an instance of {@link ListPlacesResponse }
     * 
     */
    public ListPlacesResponse createListPlacesResponse() {
        return new ListPlacesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DAOException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DAOException }{@code >}
     */
    @XmlElementDecl(namespace = "http://location.nure.ua/server/service", name = "DAOException")
    public JAXBElement<DAOException> createDAOException(DAOException value) {
        return new JAXBElement<DAOException>(_DAOException_QNAME, DAOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidationException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ValidationException }{@code >}
     */
    @XmlElementDecl(namespace = "http://location.nure.ua/server/service", name = "ValidationFault")
    public JAXBElement<ValidationException> createValidationFault(ValidationException value) {
        return new JAXBElement<ValidationException>(_ValidationFault_QNAME, ValidationException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPlace }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddPlace }{@code >}
     */
    @XmlElementDecl(namespace = "http://location.nure.ua/server/service", name = "addPlace")
    public JAXBElement<AddPlace> createAddPlace(AddPlace value) {
        return new JAXBElement<AddPlace>(_AddPlace_QNAME, AddPlace.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPlaceResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddPlaceResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://location.nure.ua/server/service", name = "addPlaceResponse")
    public JAXBElement<AddPlaceResponse> createAddPlaceResponse(AddPlaceResponse value) {
        return new JAXBElement<AddPlaceResponse>(_AddPlaceResponse_QNAME, AddPlaceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecurityHeader }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SecurityHeader }{@code >}
     */
    @XmlElementDecl(namespace = "http://location.nure.ua/server/service", name = "clientToken")
    public JAXBElement<SecurityHeader> createClientToken(SecurityHeader value) {
        return new JAXBElement<SecurityHeader>(_ClientToken_QNAME, SecurityHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePlace }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeletePlace }{@code >}
     */
    @XmlElementDecl(namespace = "http://location.nure.ua/server/service", name = "deletePlace")
    public JAXBElement<DeletePlace> createDeletePlace(DeletePlace value) {
        return new JAXBElement<DeletePlace>(_DeletePlace_QNAME, DeletePlace.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePlaceResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeletePlaceResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://location.nure.ua/server/service", name = "deletePlaceResponse")
    public JAXBElement<DeletePlaceResponse> createDeletePlaceResponse(DeletePlaceResponse value) {
        return new JAXBElement<DeletePlaceResponse>(_DeletePlaceResponse_QNAME, DeletePlaceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByActivityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByActivityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://location.nure.ua/server/service", name = "findByActivityType")
    public JAXBElement<FindByActivityType> createFindByActivityType(FindByActivityType value) {
        return new JAXBElement<FindByActivityType>(_FindByActivityType_QNAME, FindByActivityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByActivityTypeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByActivityTypeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://location.nure.ua/server/service", name = "findByActivityTypeResponse")
    public JAXBElement<FindByActivityTypeResponse> createFindByActivityTypeResponse(FindByActivityTypeResponse value) {
        return new JAXBElement<FindByActivityTypeResponse>(_FindByActivityTypeResponse_QNAME, FindByActivityTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPlace }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPlace }{@code >}
     */
    @XmlElementDecl(namespace = "http://location.nure.ua/server/service", name = "getPlace")
    public JAXBElement<GetPlace> createGetPlace(GetPlace value) {
        return new JAXBElement<GetPlace>(_GetPlace_QNAME, GetPlace.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPlaceResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPlaceResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://location.nure.ua/server/service", name = "getPlaceResponse")
    public JAXBElement<GetPlaceResponse> createGetPlaceResponse(GetPlaceResponse value) {
        return new JAXBElement<GetPlaceResponse>(_GetPlaceResponse_QNAME, GetPlaceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPlaces }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListPlaces }{@code >}
     */
    @XmlElementDecl(namespace = "http://location.nure.ua/server/service", name = "listPlaces")
    public JAXBElement<ListPlaces> createListPlaces(ListPlaces value) {
        return new JAXBElement<ListPlaces>(_ListPlaces_QNAME, ListPlaces.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPlacesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListPlacesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://location.nure.ua/server/service", name = "listPlacesResponse")
    public JAXBElement<ListPlacesResponse> createListPlacesResponse(ListPlacesResponse value) {
        return new JAXBElement<ListPlacesResponse>(_ListPlacesResponse_QNAME, ListPlacesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecurityHeader }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SecurityHeader }{@code >}
     */
    @XmlElementDecl(namespace = "http://location.nure.ua/server/service", name = "serverToken")
    public JAXBElement<SecurityHeader> createServerToken(SecurityHeader value) {
        return new JAXBElement<SecurityHeader>(_ServerToken_QNAME, SecurityHeader.class, null, value);
    }

}
