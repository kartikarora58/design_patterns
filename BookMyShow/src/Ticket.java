import java.util.List;

public class Ticket {
    int id;
    User user;
    Show show_;
    List<ShowSeat> showSeatList_;
    TicketStatus ticketStatus_;
    int totalAmount;
    public Ticket(
            int id, User user, Show show, List<ShowSeat> showSeatList, TicketStatus ticketStatus, int totalAmount) {
        this.id = id;
        this.user = user;
        show_ = show;
        showSeatList_ = showSeatList;
        ticketStatus_ = ticketStatus;
        this.totalAmount = totalAmount;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Show getShow() {
        return show_;
    }

    public void setShow(Show show) {
        show_ = show;
    }

    public List<ShowSeat> getShowSeatList() {
        return showSeatList_;
    }

    public void setShowSeatList(List<ShowSeat> showSeatList) {
        showSeatList_ = showSeatList;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus_;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        ticketStatus_ = ticketStatus;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
