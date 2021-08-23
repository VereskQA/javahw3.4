package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmPoster;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerTest {
    private FilmPoster first = new FilmPoster(1, 1, "Бладшот", 210, false);
    private FilmPoster second = new FilmPoster(2, 2, "Вперед", 180, false);
    private FilmPoster third = new FilmPoster(3, 3, "Отель", 190, false);
    private FilmPoster fourth = new FilmPoster(4, 4, "Джентльмены", 170, false);
    private FilmPoster fifth = new FilmPoster(5, 5, "Невидимка", 150, false);
    private FilmPoster sixth = new FilmPoster(6, 6, "Тролли", 50, true);
    private FilmPoster seventh = new FilmPoster(7, 7, "Номер один", 110, true);
    private FilmPoster eight = new FilmPoster(8, 8, "Аватар", 230, true);
    private FilmPoster ninth = new FilmPoster(9, 9, "Главный герой", 100, true);
    private FilmPoster tenth = new FilmPoster(10, 10, "Черная вдова", 250, true);

    @Test
    public void shouldReturnLast10() {
        PosterManager manager = new PosterManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eight);
        manager.add(ninth);
        manager.add(tenth);
        FilmPoster[] actual = manager.getLast10OrLess();
        FilmPoster[] expected;
        expected = new FilmPoster[]{tenth, ninth, eight, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnLess10() {
        PosterManager manager = new PosterManager(5);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eight);
        manager.add(ninth);
        manager.add(tenth);
        FilmPoster[] actual = manager.getLast10OrLess();
        FilmPoster[] expected;
        expected = new FilmPoster[]{tenth, ninth, eight, seventh, sixth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnAllLess10() {
        PosterManager manager = new PosterManager(12);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eight);
        manager.add(ninth);
        manager.add(tenth);
        FilmPoster[] actual = manager.getLast10OrLess();
        FilmPoster[] expected;
        expected = new FilmPoster[]{tenth, ninth, eight, seventh, sixth, fifth};

        assertArrayEquals(expected, actual);
    }
}