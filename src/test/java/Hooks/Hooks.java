package Hooks;

import Utilities.ConfigReader;
import Utilities.PD;
import io.cucumber.java.*;

public class Hooks {

    @BeforeAll
    public static void beforeAll(){
        PD.initBrowser();
    }

    @Before
    public  void before(){
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }
    @After
    public  void after(Scenario scenario){
        System.out.println(">>> @AFTER TETIKLENDI! Senaryo Durumu: " + scenario.getStatus());
        PD.closePage(scenario);
        ConfigReader.clearThreadData();
    }

    @AfterAll
    public static void afterAll(){
        PD.quitBrowser();
    }

}
