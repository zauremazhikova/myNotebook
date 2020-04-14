package kz.project.mynotebook.enums;

public enum PriorityIssue {

    TRIVIAL("Тривиальный"),
    SECONDARY("Средний"),
    HIGH("Высокий");

    private String title;

    PriorityIssue(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
