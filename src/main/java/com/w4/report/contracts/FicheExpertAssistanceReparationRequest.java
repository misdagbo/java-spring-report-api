package com.w4.report.contracts;

import javax.xml.bind.annotation.XmlRootElement;

import com.w4.report.models.FicheExpertAssistanceReparation;

@XmlRootElement
public class FicheExpertAssistanceReparationRequest {
	
	private FicheExpertAssistanceReparation ficheExpertAssistanceReparation;
	private String fileName;
	
	
	
	public FicheExpertAssistanceReparationRequest() {
		// TODO Auto-generated constructor stub
		ficheExpertAssistanceReparation = new FicheExpertAssistanceReparation();
	}

	/**
	 * @return the ficheExpertAssistanceReparation
	 */
	public FicheExpertAssistanceReparation getFicheExpertAssistanceReparation() {
		return ficheExpertAssistanceReparation;
	}

	/**
	 * @param ficheExpertAssistanceReparation the ficheExpertAssistanceReparation to set
	 */
	public void setFicheExpertAssistanceReparation(FicheExpertAssistanceReparation ficheExpertAssistanceReparation) {
		this.ficheExpertAssistanceReparation = ficheExpertAssistanceReparation;
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
