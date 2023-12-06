package edu.hw4;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;

public class QueriesTest {
    @Test
    void testOne() {
        var animals = List.of(
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 13, 13, 13, true),
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 13, 3, 13, true),
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 13, 17, 13, true),
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 13, 15, 13, true),
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 13, 2, 13, true),
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 13, 19, 13, true));
        var result = new Queries(animals).one();
        assertThat(result.stream().map(Animal::height)).containsExactly(2, 3, 13, 15, 17, 19);
    }

    @Test
    void testTwo() {
        var animals = List.of(
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 13, 13, 23, true),
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 13, 3, 15, true),
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 13, 17, 4, true),
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 13, 15, 18, true),
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 13, 2, 11, true),
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 13, 19, 20, true));
        var result = new Queries(animals).two(3);
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.stream().map(Animal::weight)).containsExactly(23, 20, 18);
    }

    @Test
    void testThree() {
        var animals = List.of(
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 13, 13, 23, true),
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 13, 3, 15, true),
                new Animal("A", Animal.Type.CAT, Animal.Sex.F, 13, 17, 4, true),
                new Animal("A", Animal.Type.CAT, Animal.Sex.F, 13, 15, 18, true),
                new Animal("A", Animal.Type.CAT, Animal.Sex.F, 13, 2, 11, true),
                new Animal("A", Animal.Type.FISH, Animal.Sex.F, 13, 19, 20, true));
        var result = new Queries(animals).three();
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(Animal.Type.DOG)).isEqualTo(2);
        assertThat(result.get(Animal.Type.CAT)).isEqualTo(3);
        assertThat(result.get(Animal.Type.FISH)).isEqualTo(1);
    }

    @Test
    void testFour() {
        var animals = List.of(
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 13, 13, 23, true),
                new Animal("AB", Animal.Type.DOG, Animal.Sex.F, 13, 3, 15, true),
                new Animal("CDA", Animal.Type.CAT, Animal.Sex.F, 13, 17, 4, true),
                new Animal("AB", Animal.Type.CAT, Animal.Sex.F, 13, 15, 18, true),
                new Animal("ABCD", Animal.Type.CAT, Animal.Sex.F, 13, 2, 11, true),
                new Animal("AD", Animal.Type.FISH, Animal.Sex.F, 13, 19, 20, true));
        var result = new Queries(animals).four();
        assertThat(result.name()).isEqualTo("ABCD");
    }

    @Test
    void testFive() {
        var animals = List.of(
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 13, 13, 23, true),
                new Animal("AB", Animal.Type.DOG, Animal.Sex.M, 13, 3, 15, true),
                new Animal("CDA", Animal.Type.CAT, Animal.Sex.M, 13, 17, 4, true),
                new Animal("AB", Animal.Type.CAT, Animal.Sex.M, 13, 15, 18, true),
                new Animal("ABCD", Animal.Type.CAT, Animal.Sex.M, 13, 2, 11, true),
                new Animal("AD", Animal.Type.FISH, Animal.Sex.F, 13, 19, 20, true));
        var result = new Queries(animals).five();
        assertThat(result).isEqualTo(Animal.Sex.M);
    }

    @Test
    void testSix() {
        var animals = List.of(
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 13, 13, 23, true),
                new Animal("AB", Animal.Type.DOG, Animal.Sex.M, 13, 3, 15, true),
                new Animal("CDA", Animal.Type.CAT, Animal.Sex.M, 13, 17, 4, true),
                new Animal("AB", Animal.Type.CAT, Animal.Sex.M, 13, 15, 18, true),
                new Animal("ABCD", Animal.Type.CAT, Animal.Sex.M, 13, 2, 11, true),
                new Animal("AD", Animal.Type.FISH, Animal.Sex.F, 13, 19, 20, true));
        var result = new Queries(animals).six();
        assertThat(result.get(Animal.Type.DOG).name()).isEqualTo("A");
        assertThat(result.get(Animal.Type.CAT).name()).isEqualTo("AB");
        assertThat(result.get(Animal.Type.FISH).name()).isEqualTo("AD");
    }

    @Test
    void testSeven() {
        var animals = List.of(
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 13, 13, 23, true),
                new Animal("AB", Animal.Type.DOG, Animal.Sex.M, 13, 3, 15, true),
                new Animal("CDA", Animal.Type.CAT, Animal.Sex.M, 117, 17, 4, true),
                new Animal("AB", Animal.Type.CAT, Animal.Sex.M, 13, 15, 18, true),
                new Animal("ABCD", Animal.Type.CAT, Animal.Sex.M, 13, 2, 11, true),
                new Animal("AD", Animal.Type.FISH, Animal.Sex.F, 13, 19, 20, true));
        var result = new Queries(animals).seven();
        assertThat(result.name()).isEqualTo("CDA");
    }

    @Test
    void testEight() {
        var animals = List.of(
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 13, 13, 23, true),
                new Animal("AB", Animal.Type.DOG, Animal.Sex.M, 135, 3, 15, true),
                new Animal("CDA", Animal.Type.CAT, Animal.Sex.M, 117, 17, 4, true),
                new Animal("AB", Animal.Type.CAT, Animal.Sex.M, 13, 15, 18, true),
                new Animal("ABCD", Animal.Type.CAT, Animal.Sex.M, 132, 2, 11, true),
                new Animal("AD", Animal.Type.FISH, Animal.Sex.F, 13, 19, 20, true));
        var result = new Queries(animals).eight(14);
        assertThat(result.get().name()).isEqualTo("AB");
        result = new Queries(animals).eight(1);
        assertThat(result.isPresent()).isFalse();
    }

    @Test
    void testNine() {
        var animals = List.of(
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 13, 13, 23, true),
                new Animal("AB", Animal.Type.DOG, Animal.Sex.M, 135, 3, 15, true),
                new Animal("CDA", Animal.Type.CAT, Animal.Sex.M, 117, 17, 4, true),
                new Animal("AB", Animal.Type.CAT, Animal.Sex.M, 13, 15, 18, true),
                new Animal("ABCD", Animal.Type.CAT, Animal.Sex.M, 132, 2, 11, true),
                new Animal("AD", Animal.Type.FISH, Animal.Sex.F, 13, 19, 20, true));
        var result = new Queries(animals).nine();
        assertThat(result).isEqualTo(20);
    }

    @Test
    void testTen() {
        var animals = List.of(
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 4, 13, 23, true),
                new Animal("AB", Animal.Type.DOG, Animal.Sex.M, 4, 3, 15, true),
                new Animal("CDA", Animal.Type.CAT, Animal.Sex.M, 4, 17, 4, true),
                new Animal("AB", Animal.Type.CAT, Animal.Sex.M, 4, 15, 18, true),
                new Animal("ABCD", Animal.Type.CAT, Animal.Sex.M, 132, 2, 11, true),
                new Animal("AD", Animal.Type.FISH, Animal.Sex.F, 13, 19, 20, true));
        var result = new Queries(animals).ten();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).name()).isEqualTo("ABCD");
        assertThat(result.get(1).name()).isEqualTo("AD");
    }

    @Test
    void testEleven() {
        var animals = List.of(
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 4, 130, 23, true),
                new Animal("AB", Animal.Type.DOG, Animal.Sex.M, 4, 3, 15, true),
                new Animal("CDA", Animal.Type.CAT, Animal.Sex.M, 4, 170, 4, true),
                new Animal("AB", Animal.Type.CAT, Animal.Sex.M, 4, 15, 18, true),
                new Animal("ABCD", Animal.Type.CAT, Animal.Sex.M, 132, 200, 11, true),
                new Animal("AD", Animal.Type.FISH, Animal.Sex.F, 13, 19, 20, true));
        var result = new Queries(animals).eleven();
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0).name()).isEqualTo("A");
        assertThat(result.get(1).name()).isEqualTo("CDA");
        assertThat(result.get(2).name()).isEqualTo("ABCD");
    }

    @Test
    void testTwelve() {
        var animals = List.of(
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 4, 130, 23, true),
                new Animal("AB", Animal.Type.DOG, Animal.Sex.M, 4, 3, 15, true),
                new Animal("CDA", Animal.Type.CAT, Animal.Sex.M, 4, 170, 4, true),
                new Animal("ABD", Animal.Type.CAT, Animal.Sex.M, 4, 15, 18, true),
                new Animal("ABCD", Animal.Type.CAT, Animal.Sex.M, 132, 200, 11, true),
                new Animal("AD", Animal.Type.FISH, Animal.Sex.F, 13, 19, 20, true));
        var result = new Queries(animals).twelve();
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0).name()).isEqualTo("AB");
        assertThat(result.get(1).name()).isEqualTo("ABD");
        assertThat(result.get(2).name()).isEqualTo("AD");
    }

    @Test
    void testThirteen() {
        var animals = List.of(
                new Animal("A A A", Animal.Type.DOG, Animal.Sex.F, 4, 130, 23, true),
                new Animal("AB", Animal.Type.DOG, Animal.Sex.M, 4, 3, 15, true),
                new Animal("CDA A A", Animal.Type.CAT, Animal.Sex.M, 4, 170, 4, true),
                new Animal("ABD", Animal.Type.CAT, Animal.Sex.M, 4, 15, 18, true),
                new Animal("ABCD A A", Animal.Type.CAT, Animal.Sex.M, 132, 200, 11, true),
                new Animal("AD", Animal.Type.FISH, Animal.Sex.F, 13, 19, 20, true));
        var result = new Queries(animals).thirteen();
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0).name()).isEqualTo("A A A");
        assertThat(result.get(1).name()).isEqualTo("CDA A A");
        assertThat(result.get(2).name()).isEqualTo("ABCD A A");
    }

    @Test
    void testFourteen() {
        var animals = List.of(
                new Animal("A A A", Animal.Type.DOG, Animal.Sex.F, 4, 130, 23, true),
                new Animal("AB", Animal.Type.DOG, Animal.Sex.M, 4, 3, 15, true),
                new Animal("CDA A A", Animal.Type.CAT, Animal.Sex.M, 4, 170, 4, true),
                new Animal("ABD", Animal.Type.CAT, Animal.Sex.M, 4, 15, 18, true),
                new Animal("ABCD A A", Animal.Type.CAT, Animal.Sex.M, 132, 200, 11, true),
                new Animal("AD", Animal.Type.FISH, Animal.Sex.F, 13, 19, 20, true));
        var result = new Queries(animals).fourteen(13);
        assertThat(result).isTrue();
        result = new Queries(animals).fourteen(2415);
        assertThat(result).isFalse();
    }

    @Test
    void testFifteen() {
        var animals = List.of(
                new Animal("A A A", Animal.Type.DOG, Animal.Sex.F, 14, 130, 23, true),
                new Animal("AB", Animal.Type.DOG, Animal.Sex.M, 164, 3, 15, true),
                new Animal("CDA A A", Animal.Type.CAT, Animal.Sex.M, 14, 170, 4, true),
                new Animal("ABD", Animal.Type.CAT, Animal.Sex.M, 6365, 15, 18, true),
                new Animal("ABCD A A", Animal.Type.CAT, Animal.Sex.M, 132, 200, 11, true),
                new Animal("AD", Animal.Type.FISH, Animal.Sex.F, 15, 19, 20, true));
        var result = new Queries(animals).fifteen(5, 16);
        assertThat(result.get(Animal.Type.DOG)).isEqualTo(23);
        assertThat(result.get(Animal.Type.CAT)).isEqualTo(4);
        assertThat(result.get(Animal.Type.FISH)).isEqualTo(20);
    }

    @Test
    void testSixteen() {
        var animals = List.of(
                new Animal("A A A", Animal.Type.DOG, Animal.Sex.F, 14, 130, 23, true),
                new Animal("AB", Animal.Type.DOG, Animal.Sex.M, 164, 3, 15, true),
                new Animal("CDA A A", Animal.Type.CAT, Animal.Sex.M, 14, 170, 4, true),
                new Animal("ABD", Animal.Type.CAT, Animal.Sex.M, 6365, 15, 18, true),
                new Animal("ABCD A A", Animal.Type.CAT, Animal.Sex.M, 132, 200, 11, true),
                new Animal("AD", Animal.Type.FISH, Animal.Sex.F, 15, 19, 20, true));
        var result = new Queries(animals).sixteen();
        assertThat(result.stream().map(Animal::name).collect(Collectors.toList()))
                .containsExactly("ABCD A A", "ABD", "CDA A A", "AB", "A A A", "AD");
    }

    @Test
    void testSeventeen() {
        var animals = List.of(
                new Animal("A A A", Animal.Type.DOG, Animal.Sex.F, 14, 130, 23, true),
                new Animal("AB", Animal.Type.DOG, Animal.Sex.M, 164, 3, 15, true),
                new Animal("CDA A A", Animal.Type.DOG, Animal.Sex.M, 14, 170, 4, true),
                new Animal("ABD", Animal.Type.CAT, Animal.Sex.M, 6365, 15, 18, true),
                new Animal("ABCD A A", Animal.Type.SPIDER, Animal.Sex.M, 132, 200, 11, true),
                new Animal("AD", Animal.Type.SPIDER, Animal.Sex.F, 15, 19, 20, true));
        var result = new Queries(animals).seventeen();
        assertThat(result).isFalse();
        animals = List.of(
                new Animal("A A A", Animal.Type.DOG, Animal.Sex.F, 14, 130, 23, true),
                new Animal("AB", Animal.Type.DOG, Animal.Sex.M, 164, 3, 15, true),
                new Animal("CDA A A", Animal.Type.SPIDER, Animal.Sex.M, 14, 170, 4, true),
                new Animal("ABD", Animal.Type.SPIDER, Animal.Sex.M, 6365, 15, 18, true),
                new Animal("ABCD A A", Animal.Type.SPIDER, Animal.Sex.M, 132, 200, 11, true),
                new Animal("AD", Animal.Type.SPIDER, Animal.Sex.F, 15, 19, 20, true));
        result = new Queries(animals).seventeen();
        assertThat(result).isTrue();
    }

    @Test
    void testEighteen() {
        var animals1 = List.of(
                new Animal("A A A", Animal.Type.DOG, Animal.Sex.F, 14, 130, 23, true),
                new Animal("AB", Animal.Type.DOG, Animal.Sex.M, 164, 3, 15, true),
                new Animal("CDA A A", Animal.Type.CAT, Animal.Sex.M, 14, 170, 4, true),
                new Animal("ABD", Animal.Type.CAT, Animal.Sex.M, 6365, 15, 18, true),
                new Animal("ABCD A A", Animal.Type.CAT, Animal.Sex.M, 132, 200, 11, true),
                new Animal("F1", Animal.Type.FISH, Animal.Sex.F, 15, 19, 20, true));
        var animals2 = List.of(
                new Animal("F2", Animal.Type.FISH, Animal.Sex.F, 14, 130, 23, true),
                new Animal("F3", Animal.Type.FISH, Animal.Sex.M, 164, 3, 15, true),
                new Animal("CDA A A", Animal.Type.CAT, Animal.Sex.M, 14, 170, 4, true),
                new Animal("ABD", Animal.Type.CAT, Animal.Sex.M, 6365, 15, 18, true),
                new Animal("F4", Animal.Type.FISH, Animal.Sex.M, 132, 200, 11, true),
                new Animal("AD", Animal.Type.DOG, Animal.Sex.F, 15, 19, 20, true));
        var result = new Queries(null).eighteen(animals1, animals2);
        assertThat(result.name()).isEqualTo("F2");
    }

    @Test
    void testNineteen() {
        var animals1 = List.of(
                new Animal("A", Animal.Type.DOG, Animal.Sex.F, 14, -3, -5, true),
                new Animal("AB", Animal.Type.DOG, Animal.Sex.M, 164, 3, 15, true),
                new Animal("CDA", Animal.Type.CAT, Animal.Sex.M, 14, 170, -5, true),
                new Animal("ABD", Animal.Type.CAT, Animal.Sex.M, 6365, 15, 18, true),
                new Animal("ABCD", Animal.Type.CAT, Animal.Sex.M, 132, -11, 11, true),
                new Animal("F1", Animal.Type.FISH, Animal.Sex.F, 15, 19, 20, true));
        var result = new Queries(animals1).nineTeen();
        var aResult = result.get("A");
        var cdaResult = result.get("CDA");
        var abcdResult = result.get("ABCD");
        assertThat(aResult.size()).isEqualTo(2);
        assertThat(cdaResult.size()).isEqualTo(1);
        assertThat(abcdResult.size()).isEqualTo(1);
    }
}
