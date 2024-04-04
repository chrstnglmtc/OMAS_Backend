package com.omasystem.omas.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omasystem.omas.Dao.TimetableDao;
import com.omasystem.omas.Model.TimetableModel;

@RestController
@RequestMapping("/api/timetable")
public class TimetableController {

    private final TimetableDao timetableDao;

    public TimetableController(TimetableDao timetableDao) {
        this.timetableDao = timetableDao;
    }

    @GetMapping("/reservations")
    public List<TimetableModel> getAllReservationPerTimeslot(@RequestParam("start_date") String startDate, @RequestParam("end_date") String endDate) {
        
        Map<String, String> params = Map.of("start_date", startDate, "end_date", endDate);

        return timetableDao.getAllReservationPerTimeslot(params);
    }
}
