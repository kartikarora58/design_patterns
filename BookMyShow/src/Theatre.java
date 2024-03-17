import java.util.List;

public class Theatre {
    int id;
    String name;
    List<Auditorium> auditoriumList_;
    List<Show> showList_;

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

    public List<Auditorium> getAuditoriumList() {
        return auditoriumList_;
    }

    public void setAuditoriumList(List<Auditorium> auditoriumList) {
        auditoriumList_ = auditoriumList;
    }

    public List<Show> getShowList() {
        return showList_;
    }

    public void setShowList(List<Show> showList) {
        showList_ = showList;
    }

}
