import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Random;

public class Course {

    private static final Random random = new Random();
    private static final String[] courses = new String[]{"Алгебра", "История", "География", "Литература"};
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;

    int duration;

    public static Course create() {
        return new Course(courses[random.nextInt(courses.length)], random.nextInt(1, 5));
    }

    Course() {
    }

    Course(String title, int duration) {
        this.duration = duration;
        this.title = title;
    }

    Course(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public void updateDuration(){
        duration = random.nextInt(1, 6);
    }

    public void updateTitle(){
        title = courses[random.nextInt(courses.length)];
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
