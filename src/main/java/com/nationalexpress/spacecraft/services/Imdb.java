package com.nationalexpress.spacecraft.services;

public class Imdb extends EntertainmentProviders {
    public Imdb(IEntertainment entertainment) {
        this.entertainment = entertainment;
    }

    @Override
    public String providers() {
        return this.entertainment.providers().concat("Imdb");
    }
}
