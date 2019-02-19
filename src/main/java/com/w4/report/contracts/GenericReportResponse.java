/**
 * 
 */
package com.w4.report.contracts;

import javax.xml.bind.annotation.XmlRootElement;

import com.w4.report.infrastructures.ResponseBase;

/**
 * @author misdagbo
 *
 */
@XmlRootElement
public class GenericReportResponse extends ResponseBase {

	private String data;
	private String fileName;
	private String mimeType;

	/**
	 * 
	 */
	public GenericReportResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the mimeType
	 */
	public String getMimeType() {
		return mimeType;
	}

	/**
	 * @param mimeType the mimeType to set
	 */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
}
