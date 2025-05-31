package com.gdserafini.springServer.utils.entity;

import java.util.UUID;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class HashableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Override
    public boolean equals(Object object){
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        var that = (HashableEntity) object;
        return this.id != null && this.id.equals(that.id);
    }

    @Override
    public int hashCode(){
        return this.id != null ? this.id.hashCode() : 0;
    }
}
