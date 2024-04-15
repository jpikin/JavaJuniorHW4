import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Random;

public class Courses {

    private static final Random random = new Random();
    private static final String[] courses = new String[]{"Алгебра", "История", "География", "Литература"};
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;

    int duration;

    public static Courses create() {
        return new Courses(courses[random.nextInt(courses.length)], random.nextInt(1, 5));
    }

    Courses() {
    }

    Courses(String title, int duration) {
        this.duration = duration;
        this.title = title;
    }

    Courses(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public void updateDuration(){
        duration = random.nextInt(20, 26);
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
