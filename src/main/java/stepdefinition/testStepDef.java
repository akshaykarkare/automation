package stepdefinition;

import io.cucumber.java.en.Given;

public class testStepDef {

@Given("^Print \"([^\"]*)\" statement$")
public void printStatement(String printText){
    System.out.println(printText);
}
}
