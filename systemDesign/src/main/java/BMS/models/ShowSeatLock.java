package BMS.models;

import java.time.LocalDateTime;



public class ShowSeatLock {

    public int id;
    public ShowSeat showSeat;
    public User lockedBy;
    public LocalDateTime lockedAt;
    public LocalDateTime lockedUntil;

}
