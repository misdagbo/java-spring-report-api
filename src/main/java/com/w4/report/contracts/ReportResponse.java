/**
 * 
 */
package com.w4.report.contracts;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.w4.report.infrastructures.ResponseBase;
import  com.w4.report.models.Document;


/**
 * @author frederic
 *
 */
@XmlRootElement
public class ReportResponse extends ResponseBase {
	private List<Document> documents;
	
	/**
	 * 
	 */
	public ReportResponse() {
		super();
		// TODO Auto-generated constructor stub
		documents = new ArrayList<>();
	}

	/**
	 * @return the documents
	 */
	public List<Document> getDocuments() {
		return documents;
	}

	/**
	 * @param documents the documents to set
	 */
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
}
