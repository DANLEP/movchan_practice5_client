package ua.nure.location.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.nure.location.entity.AddressType;
import ua.nure.location.entity.CoordinateType;
import ua.nure.location.entity.Place;
import ua.nure.location.entity.SeasonalityType;
import ua.nure.location.service.LocationClientService;
import ua.nure.location.service.LocationClientServiceSingleton;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/add")
public class AddPlace extends HttpServlet {
    private LocationClientService locationClientService;

    @Override
    public void init() {
        locationClientService = LocationClientServiceSingleton.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<String > seasons = SeasonalityType.getStringValues();
        req.setAttribute("seasons", seasons);
        req.setAttribute("title", new String("Add"));
        req.setAttribute("action", "add");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/form.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String activity = req.getParameter("activity");
        String description = req.getParameter("description");
        String street = req.getParameter("street");
        String houseNumber = req.getParameter("houseNumber");
        String city = req.getParameter("city");
        String postalCode = req.getParameter("postalCode");
        String latitude = req.getParameter("latitude");
        String longitude = req.getParameter("longitude");
        String openingTime = req.getParameter("openingTime");
        String closingTime = req.getParameter("closingTime");
        String season = req.getParameter("season");
        String isRecommended = req.getParameter("isRecommended");

        AddressType address = new AddressType();
        address.setStreet(street);
        AddressType.HouseNumber number = new AddressType.HouseNumber();
        number.setNumberWithLetter(houseNumber);
        address.setHouseNumber(number);
        address.setCity(city);
        address.setPostalCode(postalCode);

        CoordinateType coordinates = new CoordinateType();
        coordinates.setLatitude(new BigDecimal(latitude));
        coordinates.setLongitude(new BigDecimal(longitude));

        Place place = new Place();
        place.setTitle(title);
        place.setType(activity);
        place.setDescription(description);
        place.setAddress(address);
        place.setCoordinate(coordinates);
        place.setVisitTime(openingTime + "-" + closingTime);
        place.setSeasonality(season);
        if (isRecommended != null && isRecommended.matches("on")){
            place.setIsRecommended(true);
        }

        locationClientService.addPlace(place);
        req.getSession().setAttribute("successfulMessage", "You created place successfully.");
        resp.sendRedirect(req.getContextPath() + "/places");
    }
}
