package Test;

import Base.BaseTest;
import Pages.HomePage;
import org.junit.Before;
import org.junit.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage;
    @Before
    public void beforeTest(){
        homePage = new HomePage(getDriver());
        homePage.goUrlDev();
    }
    @Test
    public void testRelativeLocators() {

        homePage.search().goHome();
    }
    @Test
    public void testDevGeo() {

        homePage.devGeo();
    }
    @Test
    public void testDevDevice() {

        homePage.devDevice();
    }

}
