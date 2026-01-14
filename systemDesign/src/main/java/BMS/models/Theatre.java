package BMS.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class Theatre {
    int id;
    String name;
    List<Auditorium> auditoriums;
}

