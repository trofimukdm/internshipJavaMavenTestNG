package tests;

import org.testng.annotations.DataProvider;
import enums.ApplicationType;
import enums.ServiceType;
import utils.TestDataFactory;

public class MyDataProvider {
    @DataProvider(name = "registrationCaseData")
    public static Object[][] registrationCaseData() {
        return new Object[][]{
                {ServiceType.MARRIAGE, TestDataFactory.getMarriageInfo(), ApplicationType.MARRIAGE_CERTIFICATE},
                {ServiceType.BIRTH, TestDataFactory.getBirthInfo(), ApplicationType.BIRTH_CERTIFICATE},
                {ServiceType.DEATH, TestDataFactory.getDeathInfo(), ApplicationType.DEATH_CERTIFICATE}
        };
    }
}
