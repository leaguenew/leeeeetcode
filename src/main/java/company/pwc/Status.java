package company.pwc;

public enum Status {

    FREEZING("freezing"),
    BOILING("boiling"),
    COMMON("common");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
