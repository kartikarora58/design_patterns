import java.util.List;

public class City {
    int id;
    String name;
    List<Theatre> theatreList_;

    public City(int id, String name, List<Theatre> theatreList) {
        this.id = id;
        this.name = name;
        theatreList_ = theatreList;
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

    public List<Theatre> getTheatreList() {
        return theatreList_;
    }

    public void setTheatreList(List<Theatre> theatreList) {
        theatreList_ = theatreList;
    }



}
