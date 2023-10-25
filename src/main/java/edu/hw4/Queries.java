package edu.hw4;

import edu.hw4.Animal.Sex;
import edu.hw4.Animal.Type;
import edu.hw4.errors.AgeError;
import edu.hw4.errors.HeightError;
import edu.hw4.errors.NameError;
import edu.hw4.errors.ValidationError;
import edu.hw4.errors.WeightError;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Queries {
    private final List<Animal> animals;
    private final static int ELEVEN_TASK_HEIGHT_LIMIT = 100;

    public Queries(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Animal> one() {
        return animals.stream().sorted(Comparator.comparingInt(Animal::height)).toList();
    }

    public List<Animal> two(int k) {
        return animals.stream().sorted((a, b) -> Integer.compare(b.weight(), a.weight())).limit(k).toList();
    }

    public Map<Type, Long> three() {
        return animals.stream().collect(Collectors.groupingBy((Animal::type), Collectors.counting()));
    }

    public Animal four() {
        return animals.stream().max(Comparator.comparingInt(animal -> animal.name().length())).orElse(null);
    }

    public Sex five() {
        return animals.stream().filter(animal -> animal.sex() == Sex.F).count() > animals.size() / 2
                ? Sex.F : Sex.M;
    }

    public Map<Type, Animal> six() {
        return animals.stream().collect(Collectors.toMap(Animal::type, Function.identity(),
                BinaryOperator.maxBy(Comparator.comparingInt(Animal::weight))));
    }

    public Animal seven() {
        return animals.stream().max(Comparator.comparingInt(Animal::age)).orElse(null);
    }

    public Optional<Animal> eight(int k) {
        return animals.stream().filter(an -> an.height() < k).max(Comparator.comparingInt(Animal::age));
    }

    public Integer nine() {
        return animals.stream().map(Animal::paws).mapToInt(a -> a).sum();
    }

    public List<Animal> ten() {
        return animals.stream().filter(a -> a.paws() != a.age()).toList();
    }

    public List<Animal> eleven() {
        // из задания: (bites == null или true). чо?? bites - boolean примитив
        return animals.stream().filter(a -> a.bites() && a.height() > ELEVEN_TASK_HEIGHT_LIMIT).toList();
    }

    public List<Animal> twelve() {
        return animals.stream().filter(a -> a.weight() > a.height()).toList();
    }

    public List<Animal> thirteen() {
        return animals.stream().filter(a -> a.name().split(" ").length > 2).toList();
    }

    public Boolean fourteen(int k) {
        return !animals.stream().filter(a -> a.type() == Type.DOG && a.height() > k).toList().isEmpty();
    }

    public Map<Type, Integer> fifteen(int k, int l) {
        return animals.stream().filter(a -> a.age() >= k && a.age() <= l)
                .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    public List<Animal> sixteen() {
        return animals.stream().sorted(
                Comparator.comparing(Animal::type).thenComparing(Animal::sex).thenComparing(Animal::name)).toList();
    }

    public Boolean seventeen() {
        return animals.stream().filter(a -> a.type() == Type.SPIDER && a.bites()).toArray().length
                > animals.stream().filter(a -> a.type() == Type.DOG && a.bites()).toArray().length;
    }

    @SafeVarargs
    public final Animal eighteen(List<Animal>... animals) {
        return Arrays.stream(animals)
                .flatMap(List::stream)
                .filter(a -> a.type() == Type.FISH)
                .max(Comparator.comparingInt(Animal::weight))
                .orElse(null);
    }

    private Set<ValidationError> getAnimalSetOfErrors(Animal animal) {
        var result = new HashSet<ValidationError>();
        if (animal.weight() <= 0) {
            result.add(new WeightError("weight must be natural"));
        }

        if (animal.height() <= 0) {
            result.add(new HeightError("height must be natural"));
        }

        if (animal.age() <= 0) {
            result.add(new AgeError("age must be natural"));
        }

        if (animal.name() == null) {
            result.add(new NameError("name must be not null"));
        }

        return result;
    }

    private String getAnimalStringOfErrors(Animal animal) {
        var resultSet = getAnimalSetOfErrors(animal);
        return resultSet.stream().map(Throwable::getMessage).collect(Collectors.joining(", "));
    }

    public final Map<String, Set<ValidationError>> nineTeen() {
        return animals.stream().collect(Collectors.toMap(
                Animal::name,
                this::getAnimalSetOfErrors
        ));
    }

    public final Map<String, String> twenty() {
        return animals.stream().collect(Collectors.toMap(
                Animal::name,
                this::getAnimalStringOfErrors
        ));
    }
}
