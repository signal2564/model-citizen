package com.tobedevoured.modelcitizen.model;

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

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Car {
	private String make;
	private String manufacturer;
	private Integer milage;
	private Map status;
	private List<Wheel> wheels;
	private Set<Wheel> spares;
	private Driver driver;
	private Driver passenger;
	
	public Car() {
		
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Integer getMilage() {
		return milage;
	}

	public void setMilage(Integer milage) {
		this.milage = milage;
	}

	public Map getStatus() {
		return status;
	}

	public void setStatus(Map status) {
		this.status = status;
	}

	public List<Wheel> getWheels() {
		return wheels;
	}

	public void setWheels(List<Wheel> wheels) {
		this.wheels = wheels;
	}

	public Set<Wheel> getSpares() {
		return spares;
	}

	public void setSpares(Set<Wheel> spares) {
		this.spares = spares;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	public Driver getPassenger() {
		return passenger;
	}

	public void setPassenger(Driver passenger) {
		this.passenger = passenger;
	}
	
}