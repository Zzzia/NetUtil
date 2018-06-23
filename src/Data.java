public class Data {
    private int code;
    private String info;

    @Override
    public String toString() {
        return "Data{" +
                "code=" + code +
                ", info='" + info + '\'' +
                '}';
    }


    public Data(String json) {
        json = json.replace("}", "").replace("{", "");
        String s[] = json.split(",");
        for (String s1 : s) {
            if (s1.contains("code")) {
                code = s1.charAt(s1.length() - 1) - '0';
            } else if (s1.contains("info")) {
                String infos[] = s1.split(":");
                String infoUnicode = infos[1].replaceAll("\"", "");
                info = decodeUnicode(infoUnicode);
            }
        }
    }

    private String decodeUnicode(final String dataStr) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
