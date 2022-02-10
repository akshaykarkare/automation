package context;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import org.yaml.snakeyaml.*;

public class PropertiesUtil {
    Properties prop;
    static Map<?,?> objRepo;
    static String ymlPath = "src/main/resources/locators.yml";

    public String readConfig(String propFileName,String param) throws IOException {
        prop = new Properties();
        System.out.println(System.getProperty("user.dir"));
        String path = System.getProperty("user.dir")+"/config/"+propFileName+".properties";
        FileInputStream fs = new FileInputStream(path);
        prop.load(fs);
        System.out.println(prop.getProperty(param));
        return prop.getProperty(param);
    }

    public String readYml(String locString) {
        System.out.println(locString);
        Reader reader;
        Map<?,?> map = null;
        try {
            reader = new FileReader(ymlPath);
            Yaml yml = new Yaml();
            objRepo = yml.load(reader);
            reader.close();
            map = (Map<?, ?>) objRepo.get(locString.split("\\.")[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map.get(locString.split("\\.")[1]).toString();
    }

}
