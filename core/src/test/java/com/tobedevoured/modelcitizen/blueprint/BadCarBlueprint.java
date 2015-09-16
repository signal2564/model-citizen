package com.tobedevoured.modelcitizen.blueprint;

import com.tobedevoured.modelcitizen.annotation.*;
import com.tobedevoured.modelcitizen.callback.AfterCreateCallback;
import com.tobedevoured.modelcitizen.model.Car;
import com.tobedevoured.modelcitizen.model.Driver;
import com.tobedevoured.modelcitizen.model.Wheel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Blueprint(value = Car.class, alias = "bad")
public class BadCarBlueprint {

    @Default
    public String make = "bad brand";

    @Default
    public String manufacturer = "bad brand ltd";

    @Default
    public float mileage = 600.1f;

    @Default
    public Map status = new HashMap();

    @MappedList(target = Wheel.class, size = 4, force = true)
    public List<Wheel> wheels;

    @MappedSet(target = Wheel.class, size = 1)
    public Set<Wheel> spares;

    @Mapped
    public Driver driver;

    @Mapped
    @Nullable
    public Driver passenger = null;

    // Set the Car for each of the Car's wheels
    AfterCreateCallback<Car> afterCreate = new AfterCreateCallback<Car>() {
        @Override
        public Car afterCreate(Car model) {
            for (Wheel wheel : model.getWheels()) {
                wheel.setCar(model);
            }

            return model;
        }
    };

}
