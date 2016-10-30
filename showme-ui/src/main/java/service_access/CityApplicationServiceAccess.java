package service_access;

import data_transfer.CityDTO;

public interface CityApplicationServiceAccess {
    String ACCEPT = "accept";
    String USER_AGENT = "user-agent";
    String CONTENT_TYPE = "Content-Type";

    CityDTO getCityInfo(String cityName);
}
