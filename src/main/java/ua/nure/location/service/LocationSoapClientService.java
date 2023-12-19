package ua.nure.location.service;

import jakarta.xml.bind.JAXBException;
import jakarta.xml.ws.Holder;
import jakarta.xml.ws.handler.Handler;
import jakarta.xml.ws.handler.HandlerResolver;
import jakarta.xml.ws.handler.PortInfo;
import ua.nure.location.entity.Place;
import ua.nure.location.rest.ExceptionMessage;
import ua.nure.location.server.handler.SecurityHandler;
import ua.nure.location.server.service.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class LocationSoapClientService implements LocationClientService {
    private static final String MENU_URL = "http://localhost:9090/places?wsdl";
    private PlaceService client;
    private static final String CLIENT_TOKEN = "admin";
    private SecurityHeader clientToken;

    public LocationSoapClientService() {
        client = getLocationServiceClient();
        clientToken = new SecurityHeader();
        clientToken.setToken(CLIENT_TOKEN);
    }

    private PlaceService getLocationServiceClient() {
        Places service = null;
        try {
            service = new Places(new URL(MENU_URL));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        service.setHandlerResolver(new LocationSoapClientService.ClientHandlerResolver());
        return service.getPlacePort();
    }

    @Override
    public Collection<Place> retrievePlaces() {
        var locationResponse = client.listPlaces(new ListPlaces(), clientToken, new Holder<>());
        return locationResponse.getPlaces();
    }

    @Override
    public Collection<Place> retrievePlacesByActivityType(String activityType) {
        var findPlacesByActivityRequest = new FindByActivityType();
        findPlacesByActivityRequest.setType(activityType);

        try {
            var placesByActivityResponse = client.findByActivityType(findPlacesByActivityRequest, clientToken, new Holder<>());
            return placesByActivityResponse.getReturn();
        } catch (ValidationException_Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Place retrievePlaceById(int id) {
        GetPlace getPlaceReq = new GetPlace();
        getPlaceReq.setId(id);
        try {
            var placeresponse = client.getPlace(getPlaceReq, clientToken, new Holder<>());
            return placeresponse.getPlace();
        } catch (DAOException_Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addPlace(Place place) {
        var addPlaceRequest = new AddPlace();
        addPlaceRequest.setPlace(place);
        try {
            client.addPlace(addPlaceRequest, clientToken, new Holder<>());
        } catch (DAOException_Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatePlaceInfoById(Integer id, Place place) {
        var deletePlaceRequest = new DeletePlace();
        deletePlaceRequest.setId(id);
        try {
            client.deletePlace(deletePlaceRequest, clientToken, new Holder<>());
        } catch (DAOException_Exception e) {
        }

        var addPlaceRequest = new AddPlace();
        addPlaceRequest.setPlace(place);
        try {
            client.addPlace(addPlaceRequest, clientToken, new Holder<>());
        } catch (DAOException_Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<ExceptionMessage> deletePlaceById(int placeId) {
        var deletePlaceRequest = new DeletePlace();
        deletePlaceRequest.setId(placeId);
        try {
            client.deletePlace(deletePlaceRequest, clientToken, new Holder<>());
        } catch (DAOException_Exception e) {
            return Optional.of(new ExceptionMessage(e.getMessage()));
        }
        return Optional.empty();
    }

    @Override
    public void disconnect() {
        // no code implementation
    }

    public class ClientHandlerResolver implements HandlerResolver {
        @SuppressWarnings("rawtypes")
        @Override
        public List<Handler> getHandlerChain(PortInfo portInfo) {
            List<Handler> list = new ArrayList<>();
            try {
                list.add(new SecurityHandler());
            } catch (JAXBException e) {
                System.err.println(e.getMessage());
            }
            return list;
        }
    }
}
