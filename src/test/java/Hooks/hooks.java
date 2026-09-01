package Hooks;

import Utilities.ConfigReader;
import Utilities.PD;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks {
    @Before
    public  void before(){
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }
    @After
    public  void after(Scenario scenario){
        System.out.println(">>> @AFTER TETIKLENDI! Senaryo Durumu: " + scenario.getStatus());
        PD.quitPage(scenario);
    }
}
