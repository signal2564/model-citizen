package com.tobedevoured.modelcitizen.field;

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

import com.tobedevoured.modelcitizen.annotation.Blueprint;
import com.tobedevoured.modelcitizen.annotation.MappedList;

import java.util.Arrays;
import java.util.List;

/**
 * A {@link MappedList} annotated Field in the {@link Blueprint} that is mapped
 * to a {@link List} comprised of Models with a registered {@link Blueprint}.
 *
 * @author Michael Guymon
 */
public class MappedListField extends ModelField {

	private int size;
	private Class targetList;
    private boolean ignoreEmpty;
    private String[] aliases;

    /**
	 * Size of List to create
	 *
	 * @return int
	 */
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Class getTargetList() {
		return targetList;
	}

	public void setTargetList(Class targetList) {
		this.targetList = targetList;
	}

    public boolean isIgnoreEmpty() {
        return ignoreEmpty;
    }

    public void setIgnoreEmpty(boolean ignoreEmpty) {
        this.ignoreEmpty = ignoreEmpty;
    }

    public String[] getAliases() {
        return aliases;
    }

    public void setAliases(String[] aliases) {
        this.aliases = aliases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MappedListField that = (MappedListField) o;

        if (ignoreEmpty != that.ignoreEmpty) return false;
        if (size != that.size) return false;
        if (!targetList.equals(that.targetList)) return false;
        if (!Arrays.equals(aliases, that.aliases)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + size;
        result = 31 * result + targetList.hashCode();
        result = 31 * result + (ignoreEmpty ? 1 : 0);
        result = 31 * result + Arrays.hashCode(aliases);
        return result;
    }
}
