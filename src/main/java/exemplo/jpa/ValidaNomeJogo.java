package exemplo.jpa;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target( {ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidadorNomeJogo.class)
@Documented
public @interface ValidaNomeJogo {
    String message() default "{exemplo.jpa.Jogo.nome}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}