package dk.magnusjensen.adventofcode.templates;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.atteo.classindex.IndexAnnotated;

@IndexAnnotated
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CalenderAssignment {
    int calendarName() default -1;
    String assignmentName() default "Assignment";
    int number() default 1;
    String description() default "No description.";
}
