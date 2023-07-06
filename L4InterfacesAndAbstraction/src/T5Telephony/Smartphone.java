package T5Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    private void setUrls(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String url : urls) {
            boolean flag = true;
            char[] urlToChar = url.toCharArray();
            for (int i = 0; i < urlToChar.length; i++) {
                if (Character.isDigit(urlToChar[i])) {
                    stringBuilder.append("Invalid URL!").append(System.lineSeparator());
                    flag = false;
                    break;
                }
            }
            if (flag) {
                stringBuilder.append("Browsing: "+url+"!").append(System.lineSeparator());
            }
        }
        return String.valueOf(stringBuilder);
    }

    @Override
    public String call() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String number : numbers) {
            boolean flag = true;
            char[] urlToChar = number.toCharArray();
            for (int i = 0; i < urlToChar.length; i++) {
                if (!Character.isDigit(urlToChar[i])) {
                    stringBuilder.append("Invalid number!").append(System.lineSeparator());
                    flag = false;
                    break;
                }
            }
            if (flag) {
                stringBuilder.append("Calling... "+number).append(System.lineSeparator());
            }
        }
        return String.valueOf(stringBuilder);
    }
}
