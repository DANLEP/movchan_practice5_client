package ua.nure.location.server;

import jakarta.xml.bind.JAXBException;
import jakarta.xml.ws.handler.Handler;
import jakarta.xml.ws.handler.HandlerResolver;
import jakarta.xml.ws.handler.PortInfo;
import ua.nure.location.entity.Place;
import ua.nure.location.server.handler.SecurityHandler;
import ua.nure.location.server.service.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PlaceClient {
    // this string must be equal to the server url
    static final String URL = "http://localhost:9000/places?wsdl";
    private static final String CLIENT_TOKEN = "I_am_client";

    static class ClientHandlerResolver implements HandlerResolver {
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


    public static void main(String[] args) throws MalformedURLException, DAOException_Exception, ValidationException_Exception {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");

        Places service = new Places(new URL(URL));

        service.setHandlerResolver(new ClientHandlerResolver());
        SecurityHeader clientToken = Util.createSecurityHeader(CLIENT_TOKEN);

        PlaceService client = service.getPlacePort();

        List<Place> places =
                client.listPlaces(new ListPlaces(), clientToken, null)
                        .getPlaces();

        Place place =
                client.getPlace(new GetPlace().setId(1), clientToken, null)
                        .getPlace();


        List<Place> places2 =
                client.findByActivityType(
                                new FindByActivityType().setType("Beach"),
                                clientToken, null)
                        .getReturn();

        client.addPlace(new AddPlace().setPlace(place), clientToken, null);

        List<Place> places3 =
                client.listPlaces(new ListPlaces(), clientToken, null)
                        .getPlaces();

        client.deletePlace(
                new DeletePlace().setId(places3.get(places3.size() - 1).getId()),
                clientToken, null);

        List<Place> places4 =
                client.listPlaces(new ListPlaces(), clientToken, null)
                        .getPlaces();

        try {
            client.listPlaces(new ListPlaces(), null, null)
                            .getPlaces();
        } catch (Exception e){
            e.printStackTrace();
        }

        try{client.findByActivityType(
                        new FindByActivityType().setType(""),
                        clientToken, null)
                .getReturn();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
