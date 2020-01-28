package pl.robertburek.nameday.model;


import lombok.Data;

@Data
public class NameDay {

    private String name;
    private String nameDay;

    public NameDay(String name, String nameDay) {
        this.name = name;
        this.nameDay = nameDay;
    }

//    public String getName() {
//        return name;
//    }
}
