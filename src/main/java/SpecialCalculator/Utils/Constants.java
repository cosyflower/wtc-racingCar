package SpecialCalculator.Utils;

import java.util.regex.Pattern;

public class Constants {
    private static final String NORMAL_INPUT_REGEX = "^[\\,\\:\\d]+$";
    private static final String ONLY_NUMBER_REGEX = "^[0-9]*$";
    private static final String CUSTOM_INPUT_REGEX = "^//.\\n[0-9]+.*$";

    public static final String DECLARED_DELIMITER = ",|\\:";

    public static final Pattern NORMAL_INPUT_PATTERN = Pattern.compile(Constants.NORMAL_INPUT_REGEX);
    public static final Pattern ONLY_NUMBER_PATTERN = Pattern.compile(Constants.ONLY_NUMBER_REGEX);
    public static final Pattern CUSTOM_INPUT_PATTERN = Pattern.compile(Constants.CUSTOM_INPUT_REGEX);

    public static final int CUSTOM_DELIMITER_INDEX = 2;
    public static final String ERROR_STARTED_WITH_SLASH = "//로 시작하는 커스텀 구분자를 포함한 문자열입니다. 규칙에 맞게 입력해주세요";

}
