package BMS.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Show {
    int id;
    Movie movie;
    Auditorium auditorium;
    Theatre theatre;
    List<ShowSeat> showSeatList;
}
