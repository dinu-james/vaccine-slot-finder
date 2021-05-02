package com.dkj.vaccineSlotFinder.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CenterList {
    @JsonProperty(value="centers")
    List<Center> centers;

    public List<Center> getCenters() {
        return centers;
    }
}
