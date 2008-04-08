/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */
package org.apache.tuscany.das.rdb.config.wrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.tuscany.das.rdb.config.KeyPair;
import org.apache.tuscany.das.rdb.config.Relationship;

public class RelationshipWrapper {

    private Relationship relationship;

    public RelationshipWrapper(Relationship r) {
        this.relationship = r;
    }

    public Collection getForeignKeys() {
        List keys = new ArrayList();
        Iterator i = this.relationship.getKeyPair().iterator();
        while (i.hasNext()) {
            KeyPair pair = (KeyPair) i.next();
            keys.add(pair.getForeignKeyColumn());
        }
        return keys;
    }

}
