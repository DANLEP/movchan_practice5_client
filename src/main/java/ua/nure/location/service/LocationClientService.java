package ua.nure.location.service;

import jakarta.ws.rs.client.Client;
import ua.nure.location.entity.Place;
import ua.nure.location.rest.ExceptionMessage;

import java.util.Collection;
import java.util.Optional;

public interface LocationClientService {
    Collection<Place> retrievePlaces();
    Collection<Place> retrievePlacesByActivityType(String activityType);
    Place retrievePlaceById(int id);
    void addPlace(Place place);
    void updatePlaceInfoById(Integer id, Place place);
    Optional<ExceptionMessage> deletePlaceById(int placeId);

    void disconnect();
}
