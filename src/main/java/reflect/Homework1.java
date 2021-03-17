package reflect;

import java.lang.reflect.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

public class Homework1 {

    /**
     * Prints the declared methods of java.lang.String sorted by name.
     */
    public void streamPipeline1() {
        Arrays.stream(String.class.getMethods())
                .sorted(Comparator.comparing(Method::getName))
                .forEach(System.out::println);
    }

    /**
     *  Prints all distinct names of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline2() {
        Arrays.stream(String.class.getMethods())
                .map(Method::getName)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with two or more parameters whose parameters are all of the same type, sorted by name.
     */
    public void streamPipeline3() {
        Arrays.stream(String.class.getMethods())
                .filter(method -> method.getParameterCount() >= 2 && Arrays.stream(method.getParameterTypes()).distinct().count() == 1)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(System.out::println);
    }

    /**
     * Prints all distinct return types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline4() {
        Arrays.stream(String.class.getMethods())
                .flatMap(method -> Arrays.stream(method.getParameterTypes()))
                .distinct()
                .sorted(Comparator.comparing(Class::getName))
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with at least one boolean parameter, sorted by name.
     */
    public void streamPipeline5() {
        Arrays.stream(String.class.getMethods())
                .filter(method -> Arrays.stream(method.getParameterTypes()).anyMatch(type -> type.equals(boolean.class)))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String whose parameters are all of type int, sorted by name.
     */
    public void streamPipeline6() {
        Arrays.stream(String.class.getMethods())
                .filter(method -> !Arrays.asList(method.getParameterTypes()).isEmpty() && Arrays.stream(method.getParameterTypes()).allMatch(type -> type.equals(int.class)))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(System.out::println);
    }

    /**
     * Returns the longest name of the declared methods of java.lang.String.
     */
    public String streamPipeline7() {
        return Arrays.stream(String.class.getMethods())
                .map(Method::getName)
                .max(Comparator.comparing(String::length))
                .orElse("");
    }

    /**
     *  Returns the longest one from the names of the public declared methods of java.lang.String.
     */
    public String streamPipeline8() {
        return Arrays.stream(String.class.getMethods())
                .filter(method -> method.getModifiers() == Modifier.PUBLIC)
                .map(Method::getName)
                .max(Comparator.comparing(String::length))
                .orElse("");
    }

    /**
     * Returns summary statistics about the number of parameters for the declared methods of java.lang.String.
     */
    public IntSummaryStatistics streamPipeline9() {
        return Arrays.stream(String.class.getMethods())
                .mapToInt(Method::getParameterCount)
                .summaryStatistics();
    }

    /**
     * Returns the maximum number of parameters accepted by the declared methods of java.lang.String.
     */
    public int streamPipeline10() {
        return Arrays.stream(String.class.getMethods())
                .mapToInt(Method::getParameterCount)
                .max()
                .orElse(0);
    }

    /**
     * Returns the declared method of java.lang.String with the most number of parameters.
     */
    public Method streamPipeline11() {
        return Arrays.stream(String.class.getMethods())
                .filter(method -> method.getParameterCount() == streamPipeline10())
                .findFirst()
                .orElse(null);
    }

    /**
     * Prints all distinct parameter types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline12() {
        Arrays.stream(String.class.getMethods())
                .flatMap(method -> Arrays.stream(method.getParameterTypes()))
                .distinct()
                .sorted(Comparator.comparing(Class::getName))
                .forEach(System.out::println);
    }

}
