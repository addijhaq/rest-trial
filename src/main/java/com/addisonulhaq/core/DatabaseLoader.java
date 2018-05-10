package com.addisonulhaq.core;

import com.addisonulhaq.course.Course;
import com.addisonulhaq.course.CourseRepository;
import com.addisonulhaq.review.Review;
import com.addisonulhaq.user.User;
import com.addisonulhaq.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final CourseRepository courses;
    private final UserRepository users;

    @Autowired
    public DatabaseLoader(CourseRepository courses, UserRepository users) {
        this.courses = courses;
        this.users = users;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        String[] templates = {
                "Up and Running with %s",
                "%s Basics",
                "%s for Neckbeards",
                "%s for Beginners"
        };
        String[] buzzwords = {
                "Java 8",
                "Java 9",
                "Groovy",
                "Kotlin"
        };
        List<User> students = Arrays.asList(
                new User("jacobproffer", "Jacob",  "Proffer", "password", new String[] {"ROLE_USER"}),
                new User("mlnorman", "Mike",  "Norman", "password", new String[] {"ROLE_USER"}),
                new User("k_freemansmith", "Karen",  "Freeman-Smith", "password", new String[] {"ROLE_USER"}),
                new User("seth_lk", "Seth",  "Kroger", "password", new String[] {"ROLE_USER"}),
                new User("mrstreetgrid", "Java",  "Vince", "password", new String[] {"ROLE_USER"}),
                new User("anthonymikhail", "Tony",  "Mikhail", "password", new String[] {"ROLE_USER"}),
                new User("boog690", "AJ",  "Teacher", "password", new String[] {"ROLE_USER"}),
                new User("faelor", "Erik",  "Faelor Shafer", "password", new String[] {"ROLE_USER"}),
                new User("christophernowack", "Christopher",  "Nowack", "password", new String[] {"ROLE_USER"}),
                new User("calebkleveter", "Caleb",  "Kleveter", "password", new String[] {"ROLE_USER"}),
                new User("richdonellan", "Rich",  "Donnellan", "password", new String[] {"ROLE_USER"}),
                new User("albertqerimi", "Albert",  "Qerimi", "password", new String[] {"ROLE_USER"})
        );

        users.saveAll(students);
        User entity = new User("addijhaq", "Addison", "Ulhaq", "jaggerss", new String[]{"ROLE_USER", "ROLE_ADMIN"});
        users.save(entity);

        List<Course> bunchOfCourses = new ArrayList<>();
        IntStream.range(0,100).forEach(i -> {
            String template = templates[i% templates.length];
            String buzzword = buzzwords[i% buzzwords.length];
            String title = String.format(template, buzzword);
            Course c = new Course(title,"http://www.example.com");
            Review review = new Review((i % 5) + 1, String.format("Moar %s please!!!", buzzword));
            review.setReviewer(students.get(i%students.size()));
            c.addReview(review);
            bunchOfCourses.add(c);
        });

        courses.saveAll(bunchOfCourses);



    }
}


