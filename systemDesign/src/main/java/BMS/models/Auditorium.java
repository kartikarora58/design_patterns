package BMS.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;


@Data
@AllArgsConstructor
public class Auditorium {
    int id;
    String name;
    List<Seat> seats;
}
