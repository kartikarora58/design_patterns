package BMS.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    String id;
    Show show;
    User user;
    List<ShowSeat> showSeatsList;
    int amount;
}
