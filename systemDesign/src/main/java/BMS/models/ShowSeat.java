package BMS.models;

import BMS.enums.ShowSeatStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShowSeat {
    int id;
    Show show;
    Seat seat;
    ShowSeatStatus showSeatStatus;
    int price;
}
