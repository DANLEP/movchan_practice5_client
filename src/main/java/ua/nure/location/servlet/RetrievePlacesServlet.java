package ua.nure.location.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.nure.location.entity.Place;
import ua.nure.location.service.LocationClientService;
import ua.nure.location.service.LocationClientServiceSingleton;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@WebServlet("/places")
public class RetrievePlacesServlet extends HttpServlet {
    private LocationClientService locationClientService;

    @Override
    public void init() {
        locationClientService = LocationClientServiceSingleton.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Place> places  = locationClientService.retrievePlaces();

        alertAttribute(req, "successfulMessage");
        alertAttribute(req, "errorMessage");

        req.setAttribute("places", places);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/places.jsp");
        dispatcher.forward(req, resp);
    }

    private void alertAttribute(HttpServletRequest request, String nameAttribute) {
        String message = (String) request.getSession().getAttribute(nameAttribute);
        request.setAttribute(nameAttribute, message);
        request.getSession().removeAttribute(nameAttribute);
    }
}
