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
package org.apache.tuscany.das.rdb.graphbuilder.schema;

import java.sql.Types;

import org.apache.tuscany.sdo.SDOPackage;

import commonj.sdo.Type;
import commonj.sdo.helper.TypeHelper;

/**
 */
public class ResultSetTypeMap {

    public static final ResultSetTypeMap INSTANCE = new ResultSetTypeMap();

    /**
     * Constructor for ResultSetTypeMap.
     */
    protected ResultSetTypeMap() {
        // Empty Constructor
    }

    /**
     *
     * @param type
     * @param isNullable
     * @return
     */
    public Type getEDataType(int type, boolean isNullable) {

        TypeHelper helper = TypeHelper.INSTANCE;
        SDOPackage.eINSTANCE.eClass();
        switch (type) {

            case Types.CHAR:
            case Types.VARCHAR:
            case Types.LONGVARCHAR:
                return helper.getType("commonj.sdo", "String");

            case Types.NUMERIC:
            case Types.DECIMAL:
                return helper.getType("commonj.sdo", "Decimal");

            case Types.BIT:
            case Types.BOOLEAN:
                if (isNullable) {
                    return helper.getType("commonj.sdo", "Boolean");
                }
                return helper.getType("commonj.sdo", "boolean");


            case Types.TINYINT:
            case Types.SMALLINT:
            case Types.INTEGER:
                if (isNullable) {
                    return helper.getType("commonj.sdo", "IntObject");
                }

                return helper.getType("commonj.sdo", "Int");


            case Types.BIGINT:
                if (isNullable) {
                    return helper.getType("commonj.sdo", "Long");
                }
                return helper.getType("commonj.sdo", "long");

            case Types.REAL:
                if (isNullable) {
                    return helper.getType("commonj.sdo", "Float");
                }
                return helper.getType("commonj.sdo", "float");


            case Types.FLOAT:
            case Types.DOUBLE:
                if (isNullable) {
                    return helper.getType("commonj.sdo", "Double");
                }
                return helper.getType("commonj.sdo", "double");


            case Types.BINARY:
            case Types.VARBINARY:
            case Types.LONGVARBINARY:
                return helper.getType("commonj.sdo", "Bytes");

            case Types.DATE:
            case Types.TIME:
            case Types.TIMESTAMP:
                return helper.getType("commonj.sdo", "Date");

            case Types.CLOB:
                return helper.getType("commonj.sdo", "Object");

            case Types.BLOB:
                return helper.getType("commonj.sdo", "Bytes");

            case Types.ARRAY:
                return helper.getType("commonj.sdo", "Object");

            case Types.DISTINCT:
            case Types.STRUCT:
            case Types.REF:
            case Types.DATALINK:
            case Types.JAVA_OBJECT:
                return helper.getType("commonj.sdo", "Object");

            default:
                return helper.getType("commonj.sdo", "Object");
        }

    }

    public Type getType(int columnType, boolean b) {
        return getEDataType(columnType, b);
    }

}
