
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Program {

    /**
     * Задача 2
     * ========
     * <p>
     * Настройте Hibernate, связав его с вашей базой данных.
     * Создайте класс Courses в Java, аннотируя его как сущность Hibernate.
     * Используя Hibernate, реализуйте вставку, чтение, обновление и
     * удаление данных в таблице courses.
     * Обратите внимание на использование сессий и транзакций в Hibernate.
     */

    public static void main(String[] args) {
// Создание фабрики сессий
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();


        // Создание сессии
        try (Session session = sessionFactory.getCurrentSession()){


            // Начало транзакции
            session.beginTransaction();

            // Создание объекта
            Course course = Course.create();

            // Сохранение объекта в базе данных
            session.save(course);
            System.out.println("Object course save successfully");


            // Чтение объекта из базы данных
            Course retrievedCourse = session.get(Course.class, course.getId());
            System.out.println("Object course retrieved successfully");
            System.out.println("Retrieved course object: " + retrievedCourse);

            // Обновление объекта
            retrievedCourse.updateTitle();
            retrievedCourse.updateDuration();
            session.update(retrievedCourse);
            System.out.println("Object course update successfully");


            Course retrievedCourse2 = session.get(Course.class, 5);
            // Удаление объекта
            session.delete(retrievedCourse2);
            System.out.println("Object course delete successfully");

            // Коммит транзакции
            session.getTransaction().commit();
            System.out.println("Transaction commit successfully");
        }
    }
}
