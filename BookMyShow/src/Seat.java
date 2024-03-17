import java.util.ArrayList;
import java.util.List;

public class Seat {
    int id;
    SeatType seatType_;

    public Seat()
    {

    }
    public Seat(int id, SeatType seatType) {
        this.id = id;
        seatType_ = seatType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SeatType getSeatType() {
        return seatType_;
    }

    public void setSeatType(SeatType seatType) {
        seatType_ = seatType;
    }

    public List<Seat> createSeat()
    {
        List<Seat> seatList = new ArrayList<>();
        for(int i=0;i<100;i++)
        {
            SeatType seatType = SeatType.SILVER;
            if (i>=30 && i<=70)
                seatType = SeatType.GOLD;
            else
                seatType = SeatType.PLATINUM;
            seatList.add(new Seat(i,seatType));

        }
        return seatList;
    }
}
