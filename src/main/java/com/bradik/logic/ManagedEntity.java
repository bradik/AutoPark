package com.bradik.logic;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Brad on 18.04.2017.
 */

@MappedSuperclass
public class ManagedEntity extends VersionedEntity {

    public static final long NULL_LONG = 0L;
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id = NULL_LONG;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
