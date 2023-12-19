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

@WebServlet("/activity/*")
public class RetrievePlacesByActivityServlet extends HttpServlet {
    private LocationClientService locationClientService;

    @Override
    public void init() {
        locationClientService = LocationClientServiceSingleton.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String activityValue = req.getParameter("activity");

        Collection<Place> places = locationClientService.retrievePlacesByActivityType(activityValue);

        req.setAttribute("user", req.getSession().getAttribute("user"));
        req.setAttribute("places", places);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/places.jsp");
        dispatcher.forward(req, resp);
    }
}
