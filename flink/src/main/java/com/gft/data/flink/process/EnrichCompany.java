package com.gft.data.flink.process;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.JsonNode;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gft.data.config.AppConfig;
import com.gft.data.parser.CompaniesParser;

public class EnrichCompany extends ProcessFunction<ObjectNode, ObjectNode> {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1254137648754213264L;
	private static final Logger logger = LoggerFactory.getLogger(EnrichCompany.class);
    private AppConfig appConfig;
     
	public EnrichCompany(AppConfig appConfig) {
        this.appConfig = appConfig;
     }
	
	
	@Override
    public void processElement(ObjectNode quote, Context ctx, Collector<ObjectNode> collector) throws Exception {
     
		Map<String,ObjectNode> companiesMap=CompaniesParser.getCompaniesMap();
  	      			
    	String companyId=quote.get("symbol").asText();
    	ObjectNode companyRecord=companiesMap.get(companyId);
    		
      	
    	if(companyRecord!=null) {
    		Iterator<Entry<String,JsonNode>> companyFields=companyRecord.fields();
    		while(companyFields.hasNext()) {
    			Entry<String,JsonNode> company=companyFields.next();
    			quote.put(company.getKey(), company.getValue());
    		}
    	}
        collector.collect(quote);
        
    }
}