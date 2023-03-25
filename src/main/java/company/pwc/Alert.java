package company.pwc;

public enum Alert {

    FREEZING("freezing"),
    UNFREEZING("unfreezing"),
    BOILING("boiling"),
    UNBOILING("unboiling");

    private String alert;

    Alert(String alert) {
        this.alert = alert;
    }

    public String getAlert() {
        return alert;
    }
}
