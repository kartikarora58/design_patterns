package CarRentalSystem;

import java.time.LocalDateTime;

public class Slot {
    int id;
    LocalDateTime fromDate;
    LocalDateTime toDate;
    Slot(LocalDateTime fromDate,LocalDateTime toDate)
    {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

}
