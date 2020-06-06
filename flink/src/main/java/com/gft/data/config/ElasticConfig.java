package com.gft.data.config;

import com.typesafe.config.Config;

import java.io.Serializable;

public class ElasticConfig implements Serializable {

  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String host;
	private final int port;
	
	private final String stockIndex;
	
		
    public ElasticConfig(Config confFile) {
    	
    	host = confFile.getString("elastic.elasticHost");
    	port = confFile.getInt("elastic.elasticPort");
    	
    	stockIndex = confFile.getString("elastic.stockIndex");
    	    	
    }

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public String getStockIndex() {
		return stockIndex;
	}

	

    
}
