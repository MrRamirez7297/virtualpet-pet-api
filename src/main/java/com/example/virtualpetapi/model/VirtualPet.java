package com.example.virtualpetapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class VirtualPet {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int hunger;
    private int thirst;
    private int energy;
    

    // Constructors
    public VirtualPet(String name) {
        this.name = name;
        this.hunger = 5;
        this.thirst = 5;
        this.energy = 10;
    }

    public VirtualPet() {
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getEnergy() {
        return energy;
    }
    // public Object getModel() {
    //     return null;
    // }
    // public Object getMake() {
    //     return null;
    // }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
//     public void setMake(Object make) {
//     }

//     public void setModel(Object model) {
//     }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + hunger;
        result = prime * result + thirst;
        result = prime * result + energy;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VirtualPet other = (VirtualPet) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (hunger != other.hunger)
            return false;
        if (thirst != other.thirst)
            return false;
        if (energy != other.energy)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "VirtualPet [id=" + id + ", name=" + name + ", hunger=" + hunger + ", thirst=" + thirst + ", energy="
                + energy + "]";
    }




    
    
    
}
