package service_access;


import constant.UrlConstant;
import data_transfer.CityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class CityApplicationServiceAccessImpl implements CityApplicationServiceAccess {

    @Value("${show.me.hostname.url}")
    protected String baseUrl;

    @Value("${show.me.protocol}")
    protected String protocol;

    @Autowired
    protected RestTemplate restTemplate;

    @Override
    public CityDTO getCityInfo(String cityName){

        UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme(protocol).host(baseUrl)
                .path(UrlConstant.V1_CITY_CITYNAME).buildAndExpand(cityName);
        HttpEntity<CityDTO> responseEntity = restTemplate.getForEntity(uriComponents.toString(),CityDTO.class);
        return responseEntity.getBody();



    }


}
