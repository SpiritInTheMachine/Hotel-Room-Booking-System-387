package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.TimeZoneConversion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeZoneConversionController {

    @GetMapping("api/timezones")
    public String getPresentTimes() {
        return TimeZoneConversion.convertTimeZones();
    }
}
