package com.nationalexpress.spacecraft.services;

public class LastFm extends  EntertainmentProviders {

    public LastFm(IEntertainment entertainment) {
        this.entertainment = entertainment;
    }

    @Override
    public String providers() {
        return this.entertainment.providers().concat("LastFm");
    }
}
