package context;

public class TestContext {
    private WebDriverManager webDriverManager;
    private PropertiesUtil propUtil;

    public TestContext(){
        System.out.println("Constructor Test Context");
        webDriverManager = new WebDriverManager();
        propUtil = new PropertiesUtil();
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public PropertiesUtil getProperty(){
        return propUtil;
    }

}
