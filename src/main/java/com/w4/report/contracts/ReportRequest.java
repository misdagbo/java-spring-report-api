/**
 * 
 */
package com.w4.report.contracts;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import com.w4.report.infrastructures.RequestBase;

/**
 * @author frederic
 *
 */
@XmlRootElement
public class ReportRequest extends RequestBase {
	private Map<String, Object> variables;
	
	/**
	 * 
	 */
	public ReportRequest() {
		super();
		// TODO Auto-generated constructor stub
		variables = new HashMap<String, Object>();
	}

	/**
	 * @return the variables
	 */
	public Map<String, Object> getVariables() {
		return variables;
	}

	/**
	 * @param variables the variables to set
	 */
	public void setVariables(Map<String, Object> variables) {
		this.variables = variables;
	}
}
