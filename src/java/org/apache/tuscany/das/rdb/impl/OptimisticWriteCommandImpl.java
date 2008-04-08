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
package org.apache.tuscany.das.rdb.impl;

import java.sql.SQLException;

import org.apache.tuscany.das.rdb.config.Update;
import org.apache.tuscany.das.rdb.exception.OptimisticConcurrencyException;

public class OptimisticWriteCommandImpl extends UpdateCommandImpl {

    public OptimisticWriteCommandImpl(String sqlString) {
        super(sqlString);
    }

    public OptimisticWriteCommandImpl(Update update) {
        super(update);
        addParameters(update.getParameters());
    }

    public void basicExecute() {
        try {
            int rowsAffected = statement.executeUpdate(parameters);
            if (rowsAffected == 0) {
                throw new OptimisticConcurrencyException("An update collision occurred");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
