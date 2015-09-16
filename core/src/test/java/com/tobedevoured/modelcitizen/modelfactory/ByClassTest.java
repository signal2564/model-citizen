package com.tobedevoured.modelcitizen.modelfactory;

/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.tobedevoured.modelcitizen.CreateModelException;
import com.tobedevoured.modelcitizen.Erector;
import com.tobedevoured.modelcitizen.ModelFactory;
import com.tobedevoured.modelcitizen.RegisterBlueprintException;
import com.tobedevoured.modelcitizen.blueprint.*;
import com.tobedevoured.modelcitizen.field.ModelField;
import com.tobedevoured.modelcitizen.model.Car;
import com.tobedevoured.modelcitizen.model.Wheel;
import com.tobedevoured.modelcitizen.template.BlueprintTemplateException;
import com.tobedevoured.modelcitizen.util.Pair;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ByClassTest {

    private ModelFactory modelFactory;
    private CarBlueprint carBlueprint = new CarBlueprint();
    private CoolCarBlueprint coolCarBlueprint = new CoolCarBlueprint();
    private BadCarBlueprint badCarBlueprint = new BadCarBlueprint();
    private WheelBlueprint wheelBlueprint = new WheelBlueprint();
    private DriverBlueprint driverBlueprint = new DriverBlueprint();
    private UserBlueprint userBlueprint = new UserBlueprint();
    private OptionBlueprint optionBlueprint = new OptionBlueprint();

    @Before
    public void setUp() throws RegisterBlueprintException {
        modelFactory = new ModelFactory();
        modelFactory.registerBlueprint(carBlueprint);
        modelFactory.registerBlueprint("cool", coolCarBlueprint);
        modelFactory.registerBlueprint(badCarBlueprint);
        modelFactory.registerBlueprint(wheelBlueprint);
        modelFactory.registerBlueprint(driverBlueprint);
        modelFactory.registerBlueprint(userBlueprint);
        modelFactory.registerBlueprint(optionBlueprint);
        modelFactory.registerBlueprint("different", optionBlueprint);
    }

    @Test
    public void testCreateModelWithClass() throws RegisterBlueprintException, CreateModelException {

        Car car = modelFactory.createModel(Car.class);
        assertEquals(carBlueprint.make, car.getMake());
        assertEquals(carBlueprint.manufacturer, car.getManufacturer());
        assertEquals(carBlueprint.status, car.getStatus());
        assertEquals(4, car.getWheels().size());

        for (Wheel wheel : car.getWheels()) {
            assertEquals(wheelBlueprint.size, wheel.getSize());
        }
    }


    @Test
    public void testBlueprintWithPrimitive() throws CreateModelException, BlueprintTemplateException {
        Car car = modelFactory.createModel(Car.class);

        Erector erector = modelFactory.getErectors().get(Pair.of(ModelFactory.DEFAULT_BLUEPRINT_NAME, (Class) Car.class));

        ModelField modelField = erector.getModelField("mileage");
        assertEquals(new Float(100.1), modelField.getValue());

        // Val is zero because primitive initializes as zero
        Object val = erector.getTemplate().get(new Car(), "mileage");
        assertEquals(new Float(0.0), val);

        // Val is zero because primitive initializes as zero
        assertEquals(0.0, car.getMileage(), 0);
    }

    @Test
    public void testRegisterBlueprintWithAliasCreateAliasSpecificObject() throws CreateModelException {
        Car car = modelFactory.createModel(Car.class); // registered with default alias
        Car coolCar = modelFactory.createModel("cool", Car.class); // registered with explicit alias
        Car badCar = modelFactory.createModel("bad", Car.class); // registered with annotation alias

        assertEquals("Default car make should match make from blueprint", car.getMake(), carBlueprint.make);
        assertEquals("Cool car make should match make from blueprint", coolCar.getMake(), coolCarBlueprint.make);
        assertEquals("Bad car make should match make from blueprint", badCar.getMake(), badCarBlueprint.make);
    }
}
