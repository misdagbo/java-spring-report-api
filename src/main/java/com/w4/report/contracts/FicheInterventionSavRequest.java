/**
 * 
 */
package com.w4.report.contracts;

import javax.xml.bind.annotation.XmlRootElement;

import com.w4.report.infrastructures.RequestBase;
import com.w4.report.models.*;

/**
 * @author frederic
 *
 */
@XmlRootElement
public class FicheInterventionSavRequest extends RequestBase {

	private FicheInterventionSav ficheInterventionSav;
	private String fileName;

	/**
	 * 
	 */
	public FicheInterventionSavRequest() {
		super();
		// TODO Auto-generated constructor stub
		ficheInterventionSav = new FicheInterventionSav();
	}

	/**
	 * @return the ficheInterventionSav
	 */
	public FicheInterventionSav getFicheInterventionSav() {
		return ficheInterventionSav;
	}

	/**
	 * @param ficheInterventionSav
	 *            the ficheInterventionSav to set
	 */
	public void setFicheInterventionSav(FicheInterventionSav ficheInterventionSav) {
		this.ficheInterventionSav = ficheInterventionSav;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
