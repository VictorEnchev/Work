package reflectionannotationsregex.orderingofobjects;

import java.lang.annotation.*;

/**
 * Annotation that can be applied only on classes and invoked at runtime. Specifies the order of the annotated class
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Order {
    int value();
}
