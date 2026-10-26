package api;

public class ApiTestDataFactory {

    private static final String APPLICANT_LAST_NAME = "Иванов";
    private static final String APPLICANT_FIRST_NAME = "Иван";
    private static final String APPLICANT_MIDDLE_NAME = "Иванович";
    private static final String APPLICANT_PHONE = "1234567";
    private static final String APPLICANT_PASSPORT = "777777";
    private static final String APPLICANT_ADDRESS = "Минск";

    private static final String CITIZEN_LAST_NAME = "Иванов";
    private static final String CITIZEN_FIRST_NAME = "Иван";
    private static final String CITIZEN_MIDDLE_NAME = "Иванович";
    private static final String CITIZEN_BIRTH_DATE = "2001-02-01";
    private static final String CITIZEN_PASSPORT = "777777";
    private static final String CITIZEN_GENDER = "муж";
    private static final String CITIZEN_ADDRESS = "Минск";

    private static final String GRANDPA = "Николай";
    private static final String GRANDMA = "Юлия";

    private static final String DATE_OF_MARRIAGE = "2026-10-05";
    private static final String NEW_LAST_NAME = "Иванова";
    private static final String ANOTHER_PERSON_LAST_NAME = "Сидорова";
    private static final String ANOTHER_PERSON_FIRST_NAME = "Анна";
    private static final String ANOTHER_PERSON_MIDDLE_NAME = "Сергеевна";
    private static final String BIRTH_OF_ANOTOHER_PERSON = "2001-02-01";
    private static final String ANOTHER_PERSON_PASSPORT = "555555";

    private static final String BIRTH_PLACE = "Витебск";
    private static final String BIRTH_MOTHER = "Анна";
    private static final String BIRTH_FATHER = "Иван";

    private static final String DEATH_DATEOFDEATH = "2026-09-18";
    private static final String DEATH_PLACEOFDEATH = "Могилев";

    private static final String DATEOFBIRTH = "2001-12-10";

    public static ApiData createMarriageData() {
        return ApiData.builder()
                .withMode("wedding")
                .withApplicant(APPLICANT_LAST_NAME, APPLICANT_FIRST_NAME, APPLICANT_MIDDLE_NAME,
                        APPLICANT_PHONE, APPLICANT_PASSPORT, APPLICANT_ADDRESS)
                .withCitizen(CITIZEN_LAST_NAME, CITIZEN_FIRST_NAME, CITIZEN_MIDDLE_NAME,
                        CITIZEN_BIRTH_DATE, CITIZEN_PASSPORT, CITIZEN_GENDER, CITIZEN_ADDRESS)
                .withMarriageDetails(DATE_OF_MARRIAGE, NEW_LAST_NAME, ANOTHER_PERSON_LAST_NAME, ANOTHER_PERSON_FIRST_NAME, ANOTHER_PERSON_MIDDLE_NAME, BIRTH_OF_ANOTOHER_PERSON, ANOTHER_PERSON_PASSPORT)
                .build();
    }

    public static ApiData createBirthData() {
        return ApiData.builder()
                .withMode("birth")
                .withApplicant(APPLICANT_LAST_NAME, APPLICANT_FIRST_NAME, APPLICANT_MIDDLE_NAME,
                        APPLICANT_PHONE, APPLICANT_PASSPORT, APPLICANT_ADDRESS)
                .withCitizen(CITIZEN_LAST_NAME, CITIZEN_FIRST_NAME, CITIZEN_MIDDLE_NAME,
                        CITIZEN_BIRTH_DATE, CITIZEN_PASSPORT, CITIZEN_GENDER, CITIZEN_ADDRESS)
                .withBirthDetails(BIRTH_PLACE, BIRTH_MOTHER, BIRTH_FATHER, GRANDPA, GRANDMA)
                .build();
    }

    public static ApiData createDeathData() {
        return ApiData.builder()
                .withMode("death")
                .withApplicant(APPLICANT_LAST_NAME, APPLICANT_FIRST_NAME, APPLICANT_MIDDLE_NAME,
                        APPLICANT_PHONE, APPLICANT_PASSPORT, APPLICANT_ADDRESS)
                .withCitizen(CITIZEN_LAST_NAME, CITIZEN_FIRST_NAME, CITIZEN_MIDDLE_NAME,
                        CITIZEN_BIRTH_DATE, CITIZEN_PASSPORT, CITIZEN_GENDER, CITIZEN_ADDRESS)
                .withDeathDetails(DEATH_DATEOFDEATH, DEATH_PLACEOFDEATH, GRANDPA, GRANDMA)
                .build();
    }

    public static ApiData createAdminUserData() {
        return ApiData.builder()
                .withAdmin(DATEOFBIRTH, APPLICANT_FIRST_NAME, APPLICANT_LAST_NAME, APPLICANT_MIDDLE_NAME,
                        APPLICANT_PASSPORT, APPLICANT_PHONE)
                .build();
    }
}
