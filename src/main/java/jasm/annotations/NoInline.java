package jasm.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation to indicate that method SHOULD NOT be inlined by a optimizing compiler.
 * Duplication of the @NoInline annotations in projects such as Jikes RVM but decoupled
 * from any VM implementation.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NoInline {
}
