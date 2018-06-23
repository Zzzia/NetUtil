package netUtil;

public class ParametersBuilder {
    private StringBuilder parameters = new StringBuilder();

    public ParametersBuilder put(String key, String value) {
        parameters.append(key);
        parameters.append("=");
        parameters.append(value);
        parameters.append("&");
        return this;
    }

    public ParametersBuilder put(String str){
        parameters.append(str);
        return this;
    }

    public String getParameters() {
        int lastPosition = parameters.length();
        parameters.delete(lastPosition - 1, lastPosition);
        return parameters.toString();
    }

    @Override
    public String toString() {
        return getParameters();
    }
}