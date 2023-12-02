package Task2;

public class Request {
    private String expressions;
    private String clientId;

    public Request(String expressions, String clientId) {
        this.expressions = expressions;
        this.clientId = clientId;
    }

    public String getExpressions() {
        return expressions;
    }

    public void setExpressions(String expressions) {
        this.expressions = expressions;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
