package TestsOfCases;

import hurriyetEmlakWeb.BaseTest;
import hurriyetEmlakWeb.CaseMethods;
import org.testng.annotations.Test;

public class tests extends BaseTest {

    CaseMethods caseMethods;

    @Test
    public void CaseFirst() {
        caseMethods = new CaseMethods(driver);
        caseMethods.caseFirst();
    }

    @Test
    public void CaseSecond() {
        caseMethods = new CaseMethods(driver);
        caseMethods.caseSecond();
    }
}
