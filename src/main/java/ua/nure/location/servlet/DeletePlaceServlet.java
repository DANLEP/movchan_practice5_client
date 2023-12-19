package ua.nure.location.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.nure.location.rest.ExceptionMessage;
import ua.nure.location.service.LocationClientService;
import ua.nure.location.service.LocationClientServiceSingleton;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/delete/*")
public class DeletePlaceServlet extends HttpServlet {
    private LocationClientService locationClientService;

    @Override
    public void init() {
        locationClientService = LocationClientServiceSingleton.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String placeValue = req.getPathInfo().substring(1);

        Optional<ExceptionMessage> exceptionMessage = locationClientService.deletePlaceById(Integer.parseInt(placeValue));

        if (exceptionMessage.isEmpty()) {
            req.getSession().setAttribute("successfulMessage", String.format("You delete place by id [%s] successfully.", placeValue));
            resp.sendRedirect(req.getContextPath() + "/places");
        } else {
            req.getSession().setAttribute("errorMessage", exceptionMessage.get().getMessage());
            resp.sendRedirect(req.getContextPath() + "/places");
        }


    }
}
