package ua.nure.location;

import com.fasterxml.jackson.core.util.JacksonFeature;
import jakarta.ws.rs.client.*;
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

public class RestClientDemo {

    private static final URI BASE_URI = getBaseURI(Constants.BASE_URI, Constants.PORT);

    public static Collection<Place> retrievePlaces(Client client) {
        WebTarget target = client.target(BASE_URI).path(Constants.PLACES_SERVICE_PATH);
        return target.request(MediaType.APPLICATION_JSON)
                .get(Collection.class);
    }

    public static Collection<Place> retrievePlacesByActivityType(Client client, String activityType) {
        WebTarget target = client.target(BASE_URI)
                .path(Constants.PLACES_SERVICE_PATH)
                .queryParam("activity_type", String.valueOf(activityType));
        return target.request(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .get(Collection.class);
    }

    public static Place retrievePlacesById(Client client, long id) {
        WebTarget target = client.target(BASE_URI)
                .path(Constants.PLACES_SERVICE_PATH)
                .path(String.valueOf(id));
        return target.request(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .get(Place.class);
    }

    public static void addPlace(Client client, Place place) {
        WebTarget target = client.target(BASE_URI).path(Constants.PLACES_SERVICE_PATH);
        Response response = target.request().post(Entity.entity(place, MediaType.APPLICATION_JSON));

        handleErrorResponseStatus(response);
    }

    public static void updatePlaceInfoById(Client client, Place place) {
        WebTarget target = client.target(BASE_URI).path(Constants.PLACES_SERVICE_PATH);
        Response response = target.request().put(Entity.entity(place, MediaType.APPLICATION_JSON));

        handleErrorResponseStatus(response);
    }

    public static void deletePlaceById(Client client, long placeId) {
        WebTarget target = client.target(BASE_URI).path(Constants.PLACES_SERVICE_PATH).path(String.valueOf(placeId));
        Response response = target.request().delete();

        handleErrorResponseStatus(response);
    }

    private static void handleErrorResponseStatus(Response response) {
        if (response.getStatus() >= Response.Status.BAD_REQUEST.getStatusCode()) {
            if (response.hasEntity()) {
                ExceptionMessage exceptionMessage = response.readEntity(ExceptionMessage.class);
                System.out.println("Error (" + response.getStatus() + "): " + exceptionMessage.getMessage());
            } else {
                System.out.println("Error (" + response.getStatus() + "): No additional error message");
            }
        }
        response.close();
    }

    public static void main(String[] args) {
        try (Client client = ClientBuilder.newClient()) {
            client.register(JacksonFeature.class)
                    .register(CommonJsonProvider.class)
                    .register(PlaceJsonProvider.class)
                    .register(PlaceXmlProvider.class)
                    .register(CommonExceptionMapper.class)
                    .register(ValidationExceptionMapper.class);

            // Base CRUD operations
            Collection<Place> places = retrievePlaces(client);
            System.out.println("Read places");
            printPlaces(places);

            places = retrievePlacesByActivityType(client, "Beach");
            System.out.println("Read places by activity type");
            printPlaces(places);

            Place place = retrievePlacesById(client, 2);
            System.out.println("Read place by id");


            // Add a new place
            Place newPlace = place;
            // Set place properties
            addPlace(client, newPlace);
            System.out.println("Added new place");
            places = retrievePlaces(client);
            System.out.println("Read places");
            printPlaces(places);

            // Update dish information
            Place updatedPlace = retrievePlacesById(client, 1);
            // Set updated dish properties
            int lastId = places.size();
            updatedPlace.setId(lastId);
            updatePlaceInfoById(client, updatedPlace);
            System.out.println("Update place");
            places = retrievePlaces(client);
            System.out.println("Read places");
            printPlaces(places);

            // Delete a dish
            deletePlaceById(client, lastId);
            System.out.println("Delete place");
            places = retrievePlaces(client);
            System.out.println("Read places");
            printPlaces(places);

            // Retrieve wrong information
            place = retrievePlacesById(client, 11);
        }
    }

    static void printPlaces(Collection places) {
        places.forEach(System.out::println);
        System.out.println();
    }

    public static URI getBaseURI(String basePath, int port) {
        UriBuilder builder = UriBuilder.fromUri(basePath).port(port);

        return builder.build();
    }
}