package edu.hw4;

import static edu.hw4.Animal.*;
import edu.hw4.Animal.Type;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Queries {
    private final List<Animal> animals;

    public Queries(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Animal> One() {
        return animals.stream().sorted(Comparator.comparingInt(Animal::height)).toList();
    }

    public List<Animal> Two(int k) {
        return animals.stream().sorted((a, b) -> Integer.compare(b.weight(), a.weight())).limit(k).toList();
    }

    public Map<Type, Long> Three() {
        return animals.stream().collect(Collectors.groupingBy((Animal::type), Collectors.counting()));
    }

    public Animal Four() {
        return animals.stream().max(Comparator.comparingInt(animal -> animal.name().length())).orElse(null);
    }

    public Sex Five() {
        return animals.stream().filter(animal -> animal.sex() == Sex.F).count() > animals.toArray().length / 2
                ? Sex.F : Sex.M;
    }

    public Map<Type, Animal> Six() {
        return animals.stream().collect(Collectors.toMap(Animal::type, Function.identity(),
                BinaryOperator.maxBy(Comparator.comparingInt(Animal::weight))));
    }

    public Animal Seven() {
        return animals.stream().max(Comparator.comparingInt(Animal::age)).orElse(null);
    }

    public Optional<Animal> Eight(int k) {
        return animals.stream().filter(an -> an.height() < k).max(Comparator.comparingInt(Animal::age));
    }

    public Integer Nine() {
        return animals.stream().map(Animal::paws).mapToInt(a -> a).sum();
    }

    public List<Animal> Ten() {
        return animals.stream().filter(a -> a.paws() != a.age()).toList();
    }

    public List<Animal> Eleven() {
        // из задания: (bites == null или true). чо?? bites - boolean примитив
        return animals.stream().filter(a -> a.bites() && a.height() > 100).toList();
    }

    public List<Animal> Twelve() {
        return animals.stream().filter(a -> a.weight() > a.height()).toList();
    }

    public List<Animal> Thirteen() {
        return animals.stream().filter(a -> a.name().split(" ").length > 2).toList();
    }

    public Boolean Fourteen(int k) {
        return !animals.stream().filter(a -> a.type() == Type.DOG && a.height() > k).toList().isEmpty();
    }

    public Map<Type, Integer> Fifteen(int k, int l) {
        return animals.stream().filter(a -> a.age() >= k && a.age() <= l)
                .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    public List<Animal> Sixteen() {
        return animals.stream().sorted(
                Comparator.comparing(Animal::type).thenComparing(Animal::sex).thenComparing(Animal::name)).toList();
    }

    public Boolean Seventeen() {
        return animals.stream().filter(a -> a.type() == Type.SPIDER && a.bites()).toArray().length >
                animals.stream().filter(a -> a.type() == Type.DOG && a.bites()).toArray().length;
    }

    @SafeVarargs
    public final Animal Eighteen(List<Animal>... animals) {
        return 
    }

    public static void main(String[] args) {
        var animals = List.of(
                new Animal("Petya", Type.DOG, Sex.F, 1, 13, 4, true),
                new Animal("Petya", Type.DOG, Sex.F, 4, 13, 4, true),
                new Animal("Petya", Type.CAT, Sex.F, 17, 17, 4, true),
                new Animal("Petya", Type.BIRD, Sex.M, 3, 14, 4, true),
                new Animal("Petya", Type.SPIDER, Sex.M, 15, 14, 4, true),
                new Animal("Petya", Type.DOG, Sex.F, 5, 13, 16, true),
                new Animal("Petya", Type.CAT, Sex.F, 18, 17, 2, true),
                new Animal("Petya", Type.BIRD, Sex.M, 3, 14, 5, true),
                new Animal("Petya", Type.SPIDER, Sex.M, 16, 14, 1, true));
        var q = new Queries(animals);
        var res = q.Fifteen(1, 20);
        var a = Integer x, Integer y -> x + y;
    }
}
