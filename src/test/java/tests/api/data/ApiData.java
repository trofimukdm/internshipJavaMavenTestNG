package tests.api.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiData {

    @JsonProperty("mode")
    private String mode;
    @JsonProperty("personalLastName")
    private String personalLastName;
    @JsonProperty("personalFirstName")
    private String personalFirstName;
    @JsonProperty("personalMiddleName")
    private String personalMiddleName;
    @JsonProperty("personalPhoneNumber")
    private String personalPhoneNumber;
    @JsonProperty("personalNumberOfPassport")
    private String personalNumberOfPassport;
    @JsonProperty("personalAddress")
    private String personalAddress;

    @JsonProperty("citizenLastName")
    private String citizenLastName;
    @JsonProperty("citizenFirstName")
    private String citizenFirstName;
    @JsonProperty("citizenMiddleName")
    private String citizenMiddleName;
    @JsonProperty("citizenBirthDate")
    private String citizenBirthDate;
    @JsonProperty("citizenNumberOfPassport")
    private String citizenNumberOfPassport;
    @JsonProperty("citizenGender")
    private String citizenGender;
    @JsonProperty("citizenAddress")
    private String citizenAddress;

    @JsonProperty("dateOfMarriage")
    private String dateOfMarriage;
    @JsonProperty("newLastName")
    private String newLastName;
    @JsonProperty("anotherPersonLastName")
    private String anotherPersonLastName;
    @JsonProperty("anotherPersonFirstName")
    private String anotherPersonFirstName;
    @JsonProperty("anotherPersonMiddleName")
    private String anotherPersonMiddleName;
    @JsonProperty("birth_of_anotoherPerson")
    private String birth_of_anotoherPerson;
    @JsonProperty("anotherPersonPassport")
    private String anotherPersonPassport;

    @JsonProperty("birth_place")
    private String birth_place;
    @JsonProperty("birth_mother")
    private String birth_mother;
    @JsonProperty("birth_father")
    private String birth_father;

    @JsonProperty("birth_grandpa")
    private String birth_grandpa;
    @JsonProperty("birth_grandma")
    private String birth_grandma;

    @JsonProperty("death_dateOfDeath")
    private String death_dateOfDeath;
    @JsonProperty("death_placeOfDeath")
    private String death_placeOfDeath;

    @JsonProperty("dateofbirth")
    private String dateofbirth;

    public ApiData() {
    }

    public static ApiDataBuilder builder() {
        return new ApiDataBuilder();
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public static class ApiDataBuilder {
        private final ApiData data = new ApiData();

        public ApiDataBuilder withAdmin(String dateofbirth, String firstName, String lastName, String middleName, String passport, String phone) {
            data.dateofbirth = dateofbirth;
            data.personalFirstName = firstName;
            data.personalLastName = lastName;
            data.personalMiddleName = middleName;
            data.personalNumberOfPassport = passport;
            data.personalPhoneNumber = phone;
            return this;
        }

        public ApiDataBuilder withApplicant(String lastName, String firstName, String middleName, String phone, String passport, String address) {
            data.personalLastName = lastName;
            data.personalFirstName = firstName;
            data.personalMiddleName = middleName;
            data.personalPhoneNumber = phone;
            data.personalNumberOfPassport = passport;
            data.personalAddress = address;
            return this;
        }

        public ApiDataBuilder withCitizen(String lastName, String firstName, String middleName, String birthDate, String passport, String gender, String address) {
            data.citizenLastName = lastName;
            data.citizenFirstName = firstName;
            data.citizenMiddleName = middleName;
            data.citizenBirthDate = birthDate;
            data.citizenNumberOfPassport = passport;
            data.citizenGender = gender;
            data.citizenAddress = address;
            return this;
        }

        public ApiDataBuilder withMode(String mode) {
            data.mode = mode;
            return this;
        }

        public ApiDataBuilder withMarriageDetails(String dateOfMarriage, String newLastName, String anotherLastName, String anotherFirstName, String anotherMiddleName, String anotherBirthDate, String anotherPassport) {
            data.dateOfMarriage = dateOfMarriage;
            data.newLastName = newLastName;
            data.anotherPersonLastName = anotherLastName;
            data.anotherPersonFirstName = anotherFirstName;
            data.anotherPersonMiddleName = anotherMiddleName;
            data.birth_of_anotoherPerson = anotherBirthDate;
            data.anotherPersonPassport = anotherPassport;
            return this;
        }

        public ApiDataBuilder withBirthDetails(String birthPlace, String mother, String father, String grandpa, String grandma) {
            data.birth_place = birthPlace;
            data.birth_mother = mother;
            data.birth_father = father;
            data.birth_grandpa = grandpa;
            data.birth_grandma = grandma;
            return this;
        }

        public ApiDataBuilder withDeathDetails(String dateOfDeath, String placeOfDeath, String grandpa, String grandma) {
            data.death_dateOfDeath = dateOfDeath;
            data.death_placeOfDeath = placeOfDeath;
            data.birth_grandpa = grandpa;
            data.birth_grandma = grandma;
            return this;
        }

        public ApiData build() {
            return data;
        }
    }

    public String getMode() {
        return mode;
    }

    public String getPersonalLastName() {
        return personalLastName;
    }

    public String getPersonalFirstName() {
        return personalFirstName;
    }

    public String getPersonalMiddleName() {
        return personalMiddleName;
    }

    public String getPersonalPhoneNumber() {
        return personalPhoneNumber;
    }

    public String getPersonalNumberOfPassport() {
        return personalNumberOfPassport;
    }

    public String getPersonalAddress() {
        return personalAddress;
    }

    public String getCitizenLastName() {
        return citizenLastName;
    }

    public String getCitizenFirstName() {
        return citizenFirstName;
    }

    public String getCitizenMiddleName() {
        return citizenMiddleName;
    }

    public String getCitizenBirthDate() {
        return citizenBirthDate;
    }

    public String getCitizenNumberOfPassport() {
        return citizenNumberOfPassport;
    }

    public String getCitizenGender() {
        return citizenGender;
    }

    public String getCitizenAddress() {
        return citizenAddress;
    }

    public String getDateOfMarriage() {
        return dateOfMarriage;
    }

    public String getNewLastName() {
        return newLastName;
    }

    public String getAnotherPersonLastName() {
        return anotherPersonLastName;
    }

    public String getAnotherPersonFirstName() {
        return anotherPersonFirstName;
    }

    public String getAnotherPersonMiddleName() {
        return anotherPersonMiddleName;
    }

    public String getBirth_of_anotoherPerson() {
        return birth_of_anotoherPerson;
    }

    public String getAnotherPersonPassport() {
        return anotherPersonPassport;
    }

    public String getBirth_place() {
        return birth_place;
    }

    public String getBirth_mother() {
        return birth_mother;
    }

    public String getBirth_father() {
        return birth_father;
    }

    public String getBirth_grandpa() {
        return birth_grandpa;
    }

    public String getBirth_grandma() {
        return birth_grandma;
    }

    public String getDeath_dateOfDeath() {
        return death_dateOfDeath;
    }

    public String getDeath_placeOfDeath() {
        return death_placeOfDeath;
    }
}
