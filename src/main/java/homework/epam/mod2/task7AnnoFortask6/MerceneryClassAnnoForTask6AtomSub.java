package homework.epam.mod2.task7AnnoFortask6;

import java.lang.annotation.*;

/**
 *
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
/**
 *
 */
public @interface MerceneryClassAnnoForTask6AtomSub {
    String submarineType() default "Diesel";
    
    /**
     *
     * @return
     */
    int submarineClass() default 1;
}
