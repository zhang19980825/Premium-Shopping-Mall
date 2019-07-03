package demo;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Before;
import org.junit.Test;

public class SearchDemo {

	private HttpSolrServer httpSolrServer;

	// 提取HttpSolrServer创建
	@Before
	public void init() {
		// 1. 创建HttpSolrServer对象
		// 设置solr服务接口,浏览器客户端地址http://127.0.0.1:8081/solr/#/
		String baseURL = "http://192.168.96.152:8888/solr";
		this.httpSolrServer = new HttpSolrServer(baseURL);
	}

	@Test
	public void searchTest() throws Exception{
		// 创建搜索对象
		SolrQuery query = new SolrQuery();
		// 设置搜索条件
		query.setQuery("*:*");
//		query.set("q", "*:*");

		// 发起搜索请求
		QueryResponse response = this.httpSolrServer.query(query);
		// 处理搜索结果
		SolrDocumentList results = response.getResults();

		System.out.println("搜索到的结果总数：" + results.getNumFound());

		// 遍历搜索结果
		for (SolrDocument solrDocument : results) {

		System.out.println("----------------------------------------------------");

			System.out.println("id：" + solrDocument.get("id"));
			System.out.println("content" + solrDocument.get("content"));
		}

	}
}
