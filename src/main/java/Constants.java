import java.util.regex.Pattern;

public class Constants {
    public static final String NORMAL_INPUT_REGEX = "^[0-9]*[\\,\\:][0-9]*[\\,\\:][0-9]*$";
    public static final Pattern NORMAL_INPUT_PATTERN = Pattern.compile(Constants.NORMAL_INPUT_REGEX);

}
