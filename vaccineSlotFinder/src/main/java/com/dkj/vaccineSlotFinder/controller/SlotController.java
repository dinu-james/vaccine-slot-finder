package com.dkj.vaccineSlotFinder.controller;

import com.dkj.vaccineSlotFinder.DTO.Center;
import com.dkj.vaccineSlotFinder.service.EmailService;
import com.dkj.vaccineSlotFinder.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("vaccineSlotFinder")
public class SlotController {

    @Autowired
    SlotService slotService;

    @Autowired
    EmailService emailService;

    @RequestMapping(path = "/fetchDetails/{district}/{date}", method = RequestMethod.GET)
    public List<Center> fetchDetails(@PathVariable("district") int district, @PathVariable("date") String date) {
        return slotService.getSlots(district,date);
    }

    @RequestMapping(path = "/getAvailableSlots/{district}/{date}", method = RequestMethod.GET)
    public List<Center> getAvailableSlots(@PathVariable("district") int district, @PathVariable("date") String date) {
        return slotService.getAvailableSlots(district,date);
    }

    @RequestMapping(path = "/getAvailableSlots/mail/{district}/{date}", method = RequestMethod.GET)
    public String getAvailableSlotsViaMail(@PathVariable("district") int district, @PathVariable("date") String date) {
        List<Center> centers = slotService.getAvailableSlots(district,date);
        if (centers.size()>0)
            return emailService.sendEmail(centers);
        else
            return "No Slots available";
    }

}
