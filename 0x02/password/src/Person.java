import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Person {

    public boolean checkUser(String user) {
        Pattern pattern = Pattern.compile("\\w{8,}");
        return user != null && user.matches(pattern.toString());
    }

    public boolean checkPassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,}$");
        return  password != null && password.matches(pattern.toString());
    }
}
