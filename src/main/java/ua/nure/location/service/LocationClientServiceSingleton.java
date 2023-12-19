package ua.nure.location.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocationClientServiceSingleton {
    private static LocationClientService instance;
    private static ServiceType serviceType;

    public static LocationClientService getInstance() {
        if (instance == null) {
            if (serviceType.equals(ServiceType.SOAP)) {
                System.out.println("Connect to SOAP service");
                instance = new LocationSoapClientService();
            } else {
                System.out.println("Connect to REST service");
                instance = new LocationRestClientService();
            }
        }
        return instance;
    }

    public static void setServiceType(ServiceType type) {
        serviceType = type;
    }

    public static void disconnectFromServer() {
        instance.disconnect();
        System.out.println("Disconnect from " + serviceType.name() + " service");
    }
}
