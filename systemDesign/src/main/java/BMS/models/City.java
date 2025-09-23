package BMS.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;


@Data
@AllArgsConstructor
public class City {
    int id;
    String name;
    List<Theatre> theatres;
}
