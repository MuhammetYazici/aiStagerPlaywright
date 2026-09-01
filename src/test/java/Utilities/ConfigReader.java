package Utilities;

import net.datafaker.Faker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();
    private static final String configFilePath = "src/test/resources/configuration.properties";
    private static Faker faker;
    private static String dynmicEmail;
    private static String dynmicPassword;


    static {
        try {
            FileInputStream file = new FileInputStream(configFilePath);
            properties.load(file);
            file.close();
        }catch (IOException e){
            System.out.println("configuration.properties dosyası okunamadı");
        }

        String lang = properties.getProperty("language");

        if (lang != null){
            faker = new Faker(new Locale(lang));
        }else {
            faker = new Faker(new Locale("en"));
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

    public static int getIntProperty(String key){
        return Integer.parseInt(properties.getProperty(key));
    }

    public static String getRandomEmail(){
        dynmicEmail= faker.internet().emailAddress();
        return dynmicEmail;
    }

    public static String getRandomPassword(){
        dynmicPassword = faker.internet().password(8,16,true,true,true);
        return dynmicPassword;
    }

    public static String getRandomFullName(){
        return faker.name().fullName();
    }

    // aynı senaryoda daha önce üretilen emaili ve password u tekrar çağırmak
    public static String getGenerateEmail(){
        if (dynmicEmail == null){
            dynmicEmail = faker.internet().emailAddress();
        }
        return dynmicEmail;
    }

    public static String getGeneratePassword(){
        if (dynmicPassword == null){
            dynmicPassword = faker.internet().password(8,16,true,true,true);
        }
        return dynmicPassword;
    }

}
