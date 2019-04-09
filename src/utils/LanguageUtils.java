package utils;

public class LanguageUtils {

    public static String getLanguageName(int id){
        switch (id){
            case 1:
                return "ANSI C";
            case 2:
                return "Java";
            case 3:
                return "C++";
            case 4:
                return "Pascal";
            case 5:
                return "C++11";
        }

        return "unknown";
    }
}
