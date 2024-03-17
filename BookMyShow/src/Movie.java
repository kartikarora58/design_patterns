public class Movie {
    int id;
    String name;
    int runTime;

    public Movie(int id, String name, int runTime) {
        this.id = id;
        this.name = name;
        this.runTime = runTime;
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

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }
}
