import java.time.LocalDateTime;
import java.util.List;

public class Show {
    int id;
    Movie movie;
    Auditorium auditorium;
    LocalDateTime startTime;
    List<ShowSeat> showSeatList_;
    public Show(int id, Movie movie, Auditorium auditorium, LocalDateTime startTime, List<ShowSeat> showSeatList) {
        this.id = id;
        this.movie = movie;
        this.auditorium = auditorium;
        this.startTime = startTime;
        showSeatList_ = showSeatList;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public List<ShowSeat> getShowSeatList() {
        return showSeatList_;
    }

    public void setShowSeatList(List<ShowSeat> showSeatList) {
        showSeatList_ = showSeatList;
    }
}
