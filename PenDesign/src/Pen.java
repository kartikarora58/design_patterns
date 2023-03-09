import writestrategies.WriteBehaviour;

abstract public class Pen {
    private String name;
    private String company;
    private Integer price;
    private WriteBehaviour writeBehaviour;
    public Pen(WriteBehaviour writeBehaviour) {
        this.writeBehaviour = writeBehaviour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    abstract public void write();
}
