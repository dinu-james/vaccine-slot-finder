package com.dkj.vaccineSlotFinder.component;

import com.dkj.vaccineSlotFinder.DTO.Center;
import com.dkj.vaccineSlotFinder.DTO.CenterList;
import com.dkj.vaccineSlotFinder.DTO.Session;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Utils {

    public List<Center> getAvailableSlots(CenterList result){
        return  result.getCenters().stream().filter(centre->check(centre).size()>0).collect(Collectors.toList());
    }

    private List<Session>  check(Center centre) {
        List<Session> availablesession = centre.getSessions().stream().filter(session -> session.getAvailable_capacity() > 0).collect(Collectors.toList());
        return availablesession;
    }
}
