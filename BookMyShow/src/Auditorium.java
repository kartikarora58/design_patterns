import java.util.List;


public class Auditorium {
    int id;
    String name;
    Theatre theatre_;
    List<Seat> seatList_;
    public Auditorium(int id, String name, List<Seat> seatList,Theatre threatre) {
        this.id = id;
        this.name = name;
        seatList_ = seatList;
        theatre_ = threatre;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Seat> getSeatList() {
        return seatList_;
    }

    public void setSeatList(List<Seat> seatList) {
        seatList_ = seatList;
    }



}
