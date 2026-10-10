package com.democicd1290.democicd1290;

import java.time.LocalTime;

public class GreetingService {
     //Ajout d'un commentaire pour un nouveau commit
    //Deuxieme ligne parce que j'ai mal configurer le after build step dans le pipeline
    //Troisieme commentaire
    public String greet(String name) {
        String safe = normalize(name);
        return "Hello " + safe;
    }

    public String normalize(String name) {
        if (name == null) return "World";
        String trimmed = name.trim();
        if (trimmed.isEmpty()) return "World";
        return trimmed.length() > 30 ? trimmed.substring(0, 30) : trimmed;
    }

    public boolean isQuietHours(LocalTime time) {
        if (time == null) throw new IllegalArgumentException("time is required");
        // Heures calmes: 22:00 -> 06:00
        return time.isAfter(LocalTime.of(21, 59)) || time.isBefore(LocalTime.of(6, 0));
    }
}