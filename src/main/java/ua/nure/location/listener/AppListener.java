package ua.nure.location.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import ua.nure.location.service.LocationClientServiceSingleton;
import ua.nure.location.service.ServiceType;

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event)  {
        LocationClientServiceSingleton.setServiceType(ServiceType.SOAP);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LocationClientServiceSingleton.disconnectFromServer();
    }
}