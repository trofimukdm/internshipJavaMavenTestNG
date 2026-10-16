package data;


public class BirthInfoData {
    private final String placeOfBirth;
    private final String mother;
    private final String father;
    private final String grandmother;
    private final String grandfather;


    public BirthInfoData(String placeOfBirth, String mother, String father, String grandmother, String grandfather) {
        this.placeOfBirth = placeOfBirth;
        this.mother = mother;
        this.father = father;
        this.grandmother = grandmother;
        this.grandfather = grandfather;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public String getMother() {
        return mother;
    }

    public String getFather() {
        return father;
    }

    public String getGrandmother() {
        return grandmother;
    }

    public String getGrandfather() {
        return grandfather;
    }
}
