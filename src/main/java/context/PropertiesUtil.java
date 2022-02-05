package context;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    Properties prop;

    public String readConfig(String propFileName,String param) throws IOException {
        prop = new Properties();
        System.out.println(System.getProperty("user.dir"));
        String path = System.getProperty("user.dir")+"/config/"+propFileName+".properties";
        FileInputStream fs = new FileInputStream(path);
        prop.load(fs);
        System.out.println(prop.getProperty(param));
        return prop.getProperty(param);
    }
}
