package com.bradik.logic;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Brad on 18.04.2017.
 */

@MappedSuperclass
public abstract class VersionedEntity implements Serializable{
    @Version
    @NotNull
    @Column(name = "obj_version")
    private long objVersion;

    public long getObjVersion() {
        return objVersion;
    }

    public void setObjVersion(long objVersion) {
        this.objVersion = objVersion;
    }

}
