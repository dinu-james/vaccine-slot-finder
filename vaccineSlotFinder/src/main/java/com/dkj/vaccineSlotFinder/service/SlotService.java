package com.dkj.vaccineSlotFinder.service;

import com.dkj.vaccineSlotFinder.DTO.Center;
import com.dkj.vaccineSlotFinder.DTO.CenterList;
import com.dkj.vaccineSlotFinder.component.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SlotService {
    @Value("${cowin.base.url}")
    private String baseUrl;

    @Value("${cowin.path.url}")
    private String path;

    @Autowired
    Utils utils;

    public List<Center> getSlots(int district, String date) {
        RestTemplate restTemplate = new RestTemplate();
        CenterList result = restTemplate.getForObject(getUri(district,date), CenterList.class);
        return result.getCenters().stream().collect(Collectors.toList());
    }

    public List<Center> getAvailableSlots(int district, String date) {
        RestTemplate restTemplate = new RestTemplate();
        CenterList result = restTemplate.getForObject(getUri(district,date), CenterList.class);
        return utils.getAvailableSlots(result);
    }

    private URI getUri(int district, String date ) {
        return UriComponentsBuilder.fromUriString(baseUrl)
                .path(path)
                .queryParam("district_id",district)
                .queryParam("date",date)
                .queryParam("vaccine","COVISHIELD")
                .build()
                .encode().toUri();
    }
}
