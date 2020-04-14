package kz.project.mynotebook.enums;

public enum StatusIssue {

    OPENED("Открыта"),
    IN_PROCESSING("В работе"),
    CLOSED("Закрыта");

    private String title;

    StatusIssue(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
