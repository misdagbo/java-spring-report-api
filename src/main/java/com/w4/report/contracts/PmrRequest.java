/**
 * 
 */
package com.w4.report.contracts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import com.w4.report.infrastructures.RequestBase;
import com.w4.report.models.PmrClientCommercial;
import com.w4.report.models.PmrDetailsGroupe;

/**
 * @author frederic
 *
 */
@XmlRootElement
public class PmrRequest extends RequestBase {

	private PmrClientCommercial pmrClientCommercial;
	private List<PmrDetailsGroupe> pmrDetailsGroupe;

	/**
	 * 
	 */
	public PmrRequest() {
		super();
		// TODO Auto-generated constructor stub
		pmrDetailsGroupe = new ArrayList<>();
		pmrClientCommercial = new PmrClientCommercial();
	}

	/**
	 * @return the pmrClientCommercial
	 */
	public PmrClientCommercial getPmrClientCommercial() {
		return pmrClientCommercial;
	}

	/**
	 * @param pmrClientCommercial
	 *            the pmrClientCommercial to set
	 */
	public void setPmrClientCommercial(PmrClientCommercial pmrClientCommercial) {
		this.pmrClientCommercial = pmrClientCommercial;
	}

	/**
	 * @return the pmrDetailsGroupe
	 */
	public List<PmrDetailsGroupe> getPmrDetailsGroupe() {
		return pmrDetailsGroupe;
	}

	/**
	 * @param pmrDetailsGroupe
	 *            the pmrDetailsGroupe to set
	 */
	public void setPmrDetailsGroupe(List<PmrDetailsGroupe> pmrDetailsGroupe) {
		this.pmrDetailsGroupe = pmrDetailsGroupe;
	}
}
