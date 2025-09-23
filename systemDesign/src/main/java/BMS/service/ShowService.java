package BMS.service;

import BMS.dto.CreateShowDto;
import BMS.enums.ShowSeatStatus;
import BMS.models.Show;
import BMS.models.ShowSeat;

import java.util.*;
import java.util.Map;

public class ShowService {

    Map<Integer, Show> show = new HashMap<>();


    public Show createShow(CreateShowDto createShowDto) {
        return null;
    }

    public List<ShowSeat> getAvailableSeats(Show show) {
        return show.getShowSeatList()
                .stream()
                .filter(showSeat -> showSeat.getShowSeatStatus() == ShowSeatStatus.AVAILABLE)
                .toList();

    }

}
