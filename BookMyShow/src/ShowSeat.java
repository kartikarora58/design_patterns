public class ShowSeat {
    int id;
    Seat Seat;
    int price;
    ShowSeatStatus showSeatStatus_;
    public ShowSeat(int id, Seat Seat, int price, ShowSeatStatus showSeatStatus) {
        this.id = id;
        this.Seat = Seat;
        this.price = price;
        showSeatStatus_ = showSeatStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Seat getSeat() {
        return Seat;
    }

    public void setSeat(Seat Seat) {
        this.Seat = Seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ShowSeatStatus getShowSeatStatus() {
        return showSeatStatus_;
    }

    public void setShowSeatStatus(ShowSeatStatus showSeatStatus) {
        showSeatStatus_ = showSeatStatus;
    }


}
