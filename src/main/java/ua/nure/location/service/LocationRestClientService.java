package ua.nure.location.service;

import com.fasterxml.jackson.core.util.JacksonFeature;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import ua.nure.location.entity.Place;
import ua.nure.location.rest.Constants;
import ua.nure.location.rest.ExceptionMessage;
import ua.nure.location.rest.providers.CommonJsonProvider;
import ua.nure.location.rest.providers.PlaceJsonProvider;
import ua.nure.location.rest.providers.PlaceXmlProvider;
import ua.nure.location.rest.providers.exception.CommonExceptionMapper;
import ua.nure.location.rest.providers.exception.ValidationExceptionMapper;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

public class LocationRestClientService implements LocationClientService {
    private static final URI BASE_URI = getBaseURI(Constants.BASE_URI, Constants.PORT);
    private Client client;

    public LocationRestClientService() {
        client = ClientBuilder.newClient();
        client.register(JacksonFeature.class)
                .register(CommonJsonProvider.class)
                .register(PlaceJsonProvider.class)
                .register(PlaceXmlProvider.class)
                .register(CommonExceptionMapper.class)
                .register(ValidationExceptionMapper.class);
    }

    @Override
    public Collection<Place> retrievePlaces() {
        WebTarget target = client.target(BASE_URI).path(Constants.PLACES_SERVICE_PATH);
        return target.request(MediaType.APPLICATION_JSON)
                .get(Collection.class);
    }

    @Override
    public Collection<Place> retrievePlacesByActivityType(String activityType) {
        WebTarget target = client.target(BASE_URI)
                .path(Constants.PLACES_SERVICE_PATH)
                .queryParam("activity_type", String.valueOf(activityType));
        return target.request(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .get(Collection.class);
    }

    @Override
    public Place retrievePlaceById(int id) {
        WebTarget target = client.target(BASE_URI)
                .path(Constants.PLACES_SERVICE_PATH)
                .path(String.valueOf(id));
        return target.request(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .get(Place.class);
    }

    @Override
    public void addPlace(Place place) {
        WebTarget target = client.target(BASE_URI).path(Constants.PLACES_SERVICE_PATH);
        Response response = target.request().post(Entity.entity(place, MediaType.APPLICATION_JSON));

        handleErrorResponseStatus(response);
    }

    @Override
    public void updatePlaceInfoById(Integer id, Place place) {
        place.setId(id);
        WebTarget target = client.target(BASE_URI).path(Constants.PLACES_SERVICE_PATH);
        Response response = target.request().put(Entity.entity(place, MediaType.APPLICATION_JSON));

        handleErrorResponseStatus(response);
    }

    @Override
    public Optional<ExceptionMessage> deletePlaceById(int placeId) {
        WebTarget target = client.target(BASE_URI).path(Constants.PLACES_SERVICE_PATH).path(String.valueOf(placeId));
        Response response = target.request().delete();

        return handleErrorResponseStatus(response);
    }

    @Override
    public void disconnect() {
        client.close();
    }

    public static URI getBaseURI(String basePath, int port) {
        UriBuilder builder = UriBuilder.fromUri(basePath).port(port);

        return builder.build();
    }

    private Optional<ExceptionMessage> handleErrorResponseStatus(Response response) {
        Optional<ExceptionMessage> optionalExceptionMessage = Optional.empty();
        if (response.getStatus() >= Response.Status.BAD_REQUEST.getStatusCode()) {
            if (response.hasEntity()) {
                ExceptionMessage exceptionMessage = response.readEntity(ExceptionMessage.class);
                optionalExceptionMessage = Optional.of(exceptionMessage);
                System.out.println("Error (" + response.getStatus() + "): " + exceptionMessage.getMessage());
            } else {
                System.out.println("Error (" + response.getStatus() + "): No additional error message");
            }
        }
        response.close();
        return optionalExceptionMessage;
    }
}
