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
package org.apache.tuscany.das.rdb.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.tuscany.das.rdb.config.Command;
import org.apache.tuscany.das.rdb.config.Config;
import org.apache.tuscany.das.rdb.config.ConfigFactory;
import org.apache.tuscany.das.rdb.config.Create;
import org.apache.tuscany.das.rdb.config.Delete;
import org.apache.tuscany.das.rdb.config.Parameter;
import org.apache.tuscany.das.rdb.config.Update;

import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.impl.HelperProvider;

/**
 * Config util provides config-related utilities such as loading a Config
 * instance from an InputStream
 * 
 */
public final class ConfigUtil {

    private ConfigUtil() {
        
    }
    
    public static Config loadConfig(InputStream configStream) {

        if (configStream == null) {
            throw new RuntimeException("Cannot load configuration from a null InputStream. "
                    + "Possibly caused by an incorrect config xml file name");
        }

        HelperContext context = HelperProvider.getDefaultContext();
        ConfigFactory.INSTANCE.register(context);
        XMLHelper helper = context.getXMLHelper();

        try {
            return (Config) helper.load(configStream).getRootObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getParameters(Create createCommand) {
    	List parameters = createCommand.getParameters().getParameter();
    	if(parameters != null) {
	    	Iterator itr = parameters.iterator();
	    	StringBuffer serializedParameters = new StringBuffer();
	    	
	    	while(itr.hasNext()) {
	    		serializedParameters.append(((Parameter)itr.next()).getName()+" ");
	    	}
	    	return serializedParameters.toString().trim();
    	}
    	else {
    		return null;
    	}
    }
    
    public static String getParameters(Update updateCommand) {
    	List parameters = updateCommand.getParameters().getParameter();
    	if(parameters != null) {
	    	Iterator itr = parameters.iterator();
	    	StringBuffer serializedParameters = new StringBuffer();
	    	
	    	while(itr.hasNext()) {
	    		serializedParameters.append(((Parameter)itr.next()).getName()+" ");
	    	}
	    	return serializedParameters.toString().trim();
    	}
    	else {
    		return null;
    	}
    }
    
    public static String getParameters(Delete deleteCommand) {
    	List parameters = deleteCommand.getParameters().getParameter();
    	if(parameters != null) {
	    	Iterator itr = parameters.iterator();
	    	StringBuffer serializedParameters = new StringBuffer();
	    	
	    	while(itr.hasNext()) {
	    		serializedParameters.append(((Parameter)itr.next()).getName()+" ");
	    	}
	    	return serializedParameters.toString().trim();
    	}
    	else {
    		return null;
    	}
    }
    
    public static String getParameters(Command command) {
    	List parameters = command.getParameter();
    	if(parameters != null) {
	    	Iterator itr = parameters.iterator();
	    	StringBuffer serializedParameters = new StringBuffer();
	    	
	    	while(itr.hasNext()) {
	    		serializedParameters.append(((Parameter)itr.next()).getName()+" ");
	    	}
	    	return serializedParameters.toString().trim();
    	}
    	else {
    		return null;
    	}
    }    
}
