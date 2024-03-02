package com.driver;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter

public class Director {

   private String name;

    public Director(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
