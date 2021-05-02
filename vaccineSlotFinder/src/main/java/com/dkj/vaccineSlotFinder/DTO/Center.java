package com.dkj.vaccineSlotFinder.DTO;

import java.util.List;

public class Center {

    String center_id;
    String name;
    String state_name;
    String district_name;
    String pincode;

    List<Session> sessions;

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public String getCenter_id() {
        return center_id;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public String getName() {
        return name;
    }

    public String getState_name() {
        return state_name;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public String getPincode() {
        return pincode;
    }
}
