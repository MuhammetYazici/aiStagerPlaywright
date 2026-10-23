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
    private static final ThreadLocal<String> threadDynamicEmail = new ThreadLocal<>();
    private static final ThreadLocal<String> threadDynamicPassword = new ThreadLocal<>();


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
        String email = faker.internet().emailAddress();
        threadDynamicEmail.set(email);
        return email;
    }

    public static String getRandomPassword(){
        String dynmicPassword = faker.internet().password(8,16,true,true,true);
        threadDynamicPassword.set(dynmicPassword);
        return dynmicPassword;
    }

    public static String getRandomFullName(){
        return faker.name().fullName();
    }

    // aynı senaryoda daha önce üretilen emaili ve password u tekrar çağırmak
    public static String getGenerateEmail(){
        if (threadDynamicEmail.get() == null) {
            getRandomEmail();
        }
        return threadDynamicEmail.get();
    }

    public static String getGeneratePassword(){
        if (threadDynamicPassword.get() == null){
            getRandomPassword();
        }
        return threadDynamicPassword.get();
    }

    public static void clearThreadData() {
        threadDynamicEmail.remove();
        threadDynamicPassword.remove();
    }

}
