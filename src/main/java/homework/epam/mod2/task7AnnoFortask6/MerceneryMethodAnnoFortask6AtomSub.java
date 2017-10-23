package homework.epam.mod2.task7AnnoFortask6;

import java.lang.annotation.*;

@Inherited
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MerceneryMethodAnnoFortask6AtomSub {
    String submarineMethodName() default "Default method name";
}
