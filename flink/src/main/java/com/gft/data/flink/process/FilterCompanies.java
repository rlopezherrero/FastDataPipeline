package com.gft.data.flink.process;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gft.data.config.AppConfig;

public class FilterCompanies implements FilterFunction<ObjectNode> {
    private static final Logger logger = LoggerFactory.getLogger(FilterCompanies.class);
    private AppConfig appConfig;
   
	public FilterCompanies(AppConfig appConfig) {
        this.appConfig = appConfig;
     }

	@Override
	public boolean filter(ObjectNode value) throws Exception {
		// TODO Auto-generated method stub
		
		if(appConfig.getInScopeCompanies().contains((value.get("symbol").asText())))
			return true;
		return false;
	}
	
	
}