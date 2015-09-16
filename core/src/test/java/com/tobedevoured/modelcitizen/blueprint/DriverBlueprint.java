package com.tobedevoured.modelcitizen.blueprint;

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

import com.tobedevoured.modelcitizen.ModelFactory;
import com.tobedevoured.modelcitizen.annotation.Blueprint;
import com.tobedevoured.modelcitizen.annotation.Default;
import com.tobedevoured.modelcitizen.annotation.Mapped;
import com.tobedevoured.modelcitizen.annotation.MappedListByAliases;
import com.tobedevoured.modelcitizen.model.Car;
import com.tobedevoured.modelcitizen.model.Driver;
import com.tobedevoured.modelcitizen.model.Option;

import java.util.List;

@Blueprint(Driver.class)
public class DriverBlueprint {

    @Default(force = true)
    public String name = "Lev the Driver";

    @Default
    public Integer age = 16;

    @MappedListByAliases(target = Option.class, aliases = { "different", "different", ModelFactory.DEFAULT_BLUEPRINT_NAME})
    public List<Option> favoriteCars;

}
