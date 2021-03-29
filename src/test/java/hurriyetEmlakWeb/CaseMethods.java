package hurriyetEmlakWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CaseMethods extends BasePage{

    Constant constant = new Constant();

    enum Filter{
         city,
         county,
         category,
         priceRange,
         buildAge
    }



    public CaseMethods(WebDriver driver){
        super(driver);
    }

    public void caseFirst(){
        driver.get(constant.getMainPage());
        waitPageLoad();

        if(driver.getCurrentUrl().equals(constant.getMainPage())){
            Assert.assertTrue(true);
        }

        clickElementByXpath("//*[@src='/_nuxt/img/satilik.c924a0d.svg']");

        clickElementByXpath("//*[@class='he-filter-control he-select js-city-filter']/div/div");
        sleep(1);
        clickElementByXpath("//*[@class='he-filter-control he-select js-city-filter']/div/div/div/following-sibling::div//li[3]");
        clickElementByXpath("//*[@class='he-filter-control he-multiselect js-county-filter']");
        fillInTheBlankByXpath("//*[@placeholder='İlçe Ara']", "Bornova");
        sleep(1);
        clickElementByXpath("//*[@class='he-checkbox he-multiselect__checkbox']");
        clickElementByXpath("//*[@class='filter-item-wrap categoryMainSec']/div/ul/li[2]");
        sleep(1);
        fillInTheBlankByXpath("//*[@class='floating-input priceMin']", "100.000");
        sleep(1);
        fillInTheBlankByXpath("//*[@class='floating-input priceMax']", "2.000.000");
        sleep(1);
        clickElementByXpath("//*[@class='buildingAgeSec']/span/following-sibling::section/div");
        sleep(1);

        for(int i=1; i<4; ++i) {
            clickElementByXpath("//*[@class='dropdown-lightbox']/div/div/ul/li["+ i +"]");
        }
        clickElementByXpath("//*[@class='btn btn-red btn-large']");


        for(Filter myCase : Filter.values()) {

            switch (myCase){
                case city:
                    Assert.assertEquals(driver.findElement(By.xpath("//*[@class='applied-filters-list']/li[1]/span[2]")).getText(), "İzmir" );
                    break;
                case county:
                    Assert.assertEquals(driver.findElement(By.xpath("//*[@class='applied-filters-list']/li[2]/span[2]")).getText(), "Bornova" );
                    break;
                case category:
                    Assert.assertEquals(driver.findElement(By.xpath("//*[@class='applied-filters-list']/li[3]/span[2]")).getText(), "İşyeri" );
                    break;
                case priceRange:
                    Assert.assertEquals(driver.findElement(By.xpath("//*[@class='applied-filters-list']/li[4]/span[2]")).getText(), "100.000 TL - 2.000.000 TL" );
                    break;
                case buildAge:
                    Assert.assertEquals(driver.findElement(By.xpath("//*[@class='applied-filters-list']/li[5]/span[2]")).getText(), "Sıfır Bina" );
                    Assert.assertEquals(driver.findElement(By.xpath("//*[@class='applied-filters-list']/li[5]/following-sibling::span[1]")).getText(), "1-5" );
                    Assert.assertEquals(driver.findElement(By.xpath("//*[@class='applied-filters-list']/li[5]/following-sibling::span[2]")).getText(), "6-10" );
                    break;

            }

        }

    }

    public void caseSecond(){
        driver.get(constant.getMainPage());
        waitPageLoad();

        if(driver.getCurrentUrl().equals(constant.getMainPage())){
            Assert.assertTrue(true);
        }

        clickElementByXpath("//*[@src='/_nuxt/img/kiralik.1359811.svg']");
        clickElementByXpath("//*[@class='he-filter-control he-select js-city-filter']/div/div");
        clickElementByXpath("//*[@class='he-filter-control he-select js-city-filter']/div/div/div/following-sibling::div//li[2]");
        clickElementByXpath("//*[@class='he-filter-control he-multiselect js-county-filter']");
        fillInTheBlankByXpath("//*[@placeholder='İlçe Ara']", "Çankaya");
        sleep(1);
        clickElementByXpath("//*[@class='he-checkbox he-multiselect__checkbox']");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='filter-item-wrap categoryMainSec']/div/ul/li[1]")).getText(), "Konut");
        clickElementByXpath("//*[@class='roomTypeSec']/span/following-sibling::section/div");
        clickElementByXpath("//*[@class='roomTypeSec']/span/following-sibling::section/div/div[2]/div/div//li[3]");
        clickElementByXpath("//*[@class='roomTypeSec']/span/following-sibling::section/div");
        clickElementByXpath("//section[@class='filter-switch withinSiteSec']//*[@class='md-switch']/div[2]");
        sleep(1);
        clickElementByXpath("//*[@class='btn btn-red btn-large']");
        waitPageLoad();
        sleep(1);
        clickElementByXpath("//*[@class='listView']/div[4]//*[@class='telephone-button']");
        String getMobilePhone = driver.findElement(By.xpath("//div[@class='list-phone-container list-telephone-detail showPhones']/div/a/following-sibling::div/following-sibling::ul/li[2]")).getText();
        System.out.println(getMobilePhone);
        Assert.assertEquals(getMobilePhone, "0532 504 56 18");






    }


}
