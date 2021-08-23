package ru.netology.manager;

import ru.netology.domain.FilmPoster;


public class PosterManager {

    private int newLength = 10;
    private FilmPoster[] films = new FilmPoster[0];

    public PosterManager(int newLenght) {
        this.newLength = newLenght;
    }

    public PosterManager() {
    }

    public void add(FilmPoster film) {
        int length = films.length + 1;
        FilmPoster[] tmp = new FilmPoster[length];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public FilmPoster[] getLast10OrLess() {
        int resultLength = Math.min(films.length, newLength);
        FilmPoster[] result = new FilmPoster[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }
}
