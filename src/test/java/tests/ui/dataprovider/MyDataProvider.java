package tests.ui.dataprovider;

import org.testng.annotations.DataProvider;
import enums.ApplicationType;
import utils.TestDataFactory;

public class MyDataProvider {
    @DataProvider(name = "registrationCaseData")
    public static Object[][] registrationCaseData() {
        return new Object[][]{
                {TestDataFactory.getMarriageInfo(), ApplicationType.MARRIAGE_CERTIFICATE},
                {TestDataFactory.getBirthInfo(), ApplicationType.BIRTH_CERTIFICATE},
                {TestDataFactory.getDeathInfo(), ApplicationType.DEATH_CERTIFICATE}
        };
    }
}
