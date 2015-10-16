/**
 * Created by alhanger on 10/15/15.
 */
public class Country {
    String name;
    String abbrev;

    public Country(String name, String abbrev) {
        this.name = name;
        this.abbrev = abbrev;
    }

    public String getName() {
        return name;
    }

    public String getAbbrev() {
        return abbrev;
    }
}
