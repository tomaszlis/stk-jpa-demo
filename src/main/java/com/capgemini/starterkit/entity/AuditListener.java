package com.capgemini.starterkit.entity;

import java.time.LocalTime;

import javax.persistence.PrePersist;

public class AuditListener {

    @PrePersist
    public void ammendPersistingHistory(AbstractEntity entity) {
        String persistingHistory = entity.getPersistingHistory();

        if(persistingHistory == null) {
            persistingHistory="";
        }
        persistingHistory = persistingHistory + "| Persisted: " + LocalTime.now() +" |";
        entity.setPersistingHistory(persistingHistory);
    }

}
