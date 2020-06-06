package com.gft.data.flink.process;

import org.apache.flink.api.common.functions.RuntimeContext;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.flink.streaming.connectors.elasticsearch.ElasticsearchSinkFunction;
import org.apache.flink.streaming.connectors.elasticsearch.RequestIndexer;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Requests;
import org.elasticsearch.common.xcontent.XContentType;


public class ExtendedElasticSink implements ElasticsearchSinkFunction<ObjectNode> {
	
	String index;
	
	public ExtendedElasticSink(String index) {
		this.index=index;
	}
	
	public IndexRequest createIndexRequest(ObjectNode element) {
  		
		return Requests.indexRequest()
                .index(index)
                .source(element.toString(),XContentType.JSON);
	}
	
	
	@Override
	public void process(ObjectNode element, RuntimeContext ctx, RequestIndexer indexer) {
		 indexer.add(createIndexRequest(element));
		
	}
}

/*

}*/