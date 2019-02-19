package com.w4.report.contracts;

import javax.xml.bind.annotation.XmlRootElement;

import com.w4.report.models.FicheMaintenanceOT;


@XmlRootElement
public class FicheMaintenanceOTRequest {
	
	private FicheMaintenanceOT ficheMaintenanceOT;
	private String fileName;
	
	
	public FicheMaintenanceOTRequest() {
		// TODO Auto-generated constructor stub
		ficheMaintenanceOT = new FicheMaintenanceOT();
	}

	

	/**
	 * @return the ficheMaintenanceOT
	 */
	public FicheMaintenanceOT getFicheMaintenanceOT() {
		return ficheMaintenanceOT;
	}

	/**
	 * @param ficheMaintenanceOT the ficheMaintenanceOT to set
	 */
	public void setFicheMaintenanceOT(FicheMaintenanceOT ficheMaintenanceOT) {
		this.ficheMaintenanceOT = ficheMaintenanceOT;
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
