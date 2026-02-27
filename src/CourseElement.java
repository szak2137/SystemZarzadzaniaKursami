abstract class CourseElement {
    private String title;

    public CourseElement(String title) {
        this.title = title;
    }

    public String getTitle() { return title; }

    public abstract String describe();
}
