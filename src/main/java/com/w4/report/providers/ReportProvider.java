package com.w4.report.providers;

/**
 * @author misdagbo
 *
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.w4.report.contracts.FicheExpertAssistanceReparationRequest;
import com.w4.report.contracts.FicheInterventionSavRequest;
import com.w4.report.contracts.FicheMaintenanceOTRequest;
import com.w4.report.contracts.GenericReportResponse;
import com.w4.report.contracts.PmrRequest;
import com.w4.report.infrastructures.ReportUtils;
import com.w4.report.infrastructures.Utility;
import com.w4.report.models.FicheExpertAssistanceReparation;
import com.w4.report.models.FicheInterventionSav;
import com.w4.report.models.FicheMaintenanceOT;
import com.w4.report.models.PmrClientCommercial;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReportProvider {

	private static final Logger logger = LoggerFactory.getLogger(ReportProvider.class);
	private static JasperPrint jasperPrint;
	private static String defaultReportUrl = "reports/FicheInterventionSav.jrxml";
	private static String defaultReportRemiseUrl = "reports/FicheInterventionSavRemise.jrxml";
	private static String reportFicheExpertAssistanceReparationUrl = "reports/FicheExpertAssistanceReparation.jrxml";
	private static String reportFicheMaintenaceOTUrl = "reports/FicheInterventionOT.jrxml";
	private static String reportFicheMaintenaceOTFtthUrl = "reports/FicheMaintenanceOT_FTTH.jrxml";
	private static String reportFicheMaintenaceOTCommandeFtthUrl = "reports/FicheMaintenanceOT_Commande_FTTH.jrxml";
	private static String reportFicheOTEtudeCommandeFtthUrl = "reports/FicheOT_Etude_Commande_FTTH.jrxml";
	private static String reportFicheMaintenaceSAVOTUrl = "reports/FicheMaintenanceSAVOT.jrxml";
	private static String reportUrlFicheGroupe = "reports/FicheClientDataVillage.jrxml";
	

	public static GenericReportResponse getReportFicheInterventionSav(FicheInterventionSavRequest request) {
		GenericReportResponse response = new GenericReportResponse();
		String reportLocation = "";
		String fileName = null;
		if (request.getFileName() != null) {
			fileName = request.getFileName();
		} else {
			fileName = "preview_fiche_SAV_ouverture_dossier";
		}

		try {
			List<FicheInterventionSav> dataSource = new ArrayList<FicheInterventionSav>();
			dataSource.add(request.getFicheInterventionSav());
			// fill the ready report with data and parameter
			jasperPrint = ReportUtils.getJasperPrint(defaultReportUrl, null, dataSource);
			/// exports report to PDF
			reportLocation = Utility.getReportLocation(fileName, "pdf");
			response.setMimeType("application/pdf");
			response.setFileName(fileName + "." + "pdf");
			/* Write content to PDF file */
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(reportLocation));
			String base64 = Utility.convertFileToBase64(reportLocation);
			response.setData(base64);
		} catch (Exception e) {
			response.setHasError(true);
			response.setMessage(e.getMessage());
			logger.warn("EXCEPTION " + e.getMessage());
		}
		return response;
	}

	public static GenericReportResponse getReportFicheInterventionSavRemise(FicheInterventionSavRequest request) {
		GenericReportResponse response = new GenericReportResponse();
		String reportLocation = "";
		String fileName = null;
		if (request.getFileName() != null) {
			fileName = request.getFileName();
		} else {
			fileName = "preview_fiche_SAV_remise_terminal_client";
		}
		try {
			List<FicheInterventionSav> dataSource = new ArrayList<FicheInterventionSav>();
			dataSource.add(request.getFicheInterventionSav());
			// fill the ready report with data and parameter
			jasperPrint = ReportUtils.getJasperPrint(defaultReportRemiseUrl, null, dataSource);
			/// exports report to PDF
			reportLocation = Utility.getReportLocation(fileName, "pdf");
			response.setMimeType("application/pdf");
			response.setFileName(fileName + "." + "pdf");
			/* Write content to PDF file */
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(reportLocation));
			String base64 = Utility.convertFileToBase64(reportLocation);
			response.setData(base64);
		} catch (Exception e) {
			response.setHasError(true);
			response.setMessage(e.getMessage());
			logger.warn("EXCEPTION " + e.getMessage());
		}
		return response;
	}

	public static GenericReportResponse getReportFicheExpertAssistanceReparation(
			FicheExpertAssistanceReparationRequest request) {
		GenericReportResponse response = new GenericReportResponse();
		String reportLocation = "";
		String fileName = null;
		if (request.getFileName() != null) {
			fileName = request.getFileName();
		} else {
			fileName = "preview_fiche_expert_assistance_reparation";
		}
		try {
			List<FicheExpertAssistanceReparation> dataSource = new ArrayList<FicheExpertAssistanceReparation>();
			dataSource.add(request.getFicheExpertAssistanceReparation());
			// fill the ready report with data and parameter
			jasperPrint = ReportUtils.getJasperPrint(reportFicheExpertAssistanceReparationUrl, null, dataSource);
			/// exports report to PDF
			reportLocation = Utility.getReportLocation(fileName, "pdf");
			response.setMimeType("application/pdf");
			response.setFileName(fileName + "." + "pdf");
			/* Write content to PDF file */
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(reportLocation));
			String base64 = Utility.convertFileToBase64(reportLocation);
			response.setData(base64);
		} catch (Exception e) {
			response.setHasError(true);
			response.setMessage(e.getMessage());
			logger.warn("EXCEPTION " + e.getMessage());
		}
		return response;
	}

	public static GenericReportResponse getReportFicheMaintenanceOT(FicheMaintenanceOTRequest request) {
		GenericReportResponse response = new GenericReportResponse();
		String reportLocation = "";
		String fileName = null;
		if (request.getFileName() != null) {
			fileName = request.getFileName();
		} else {
			fileName = "OT_fiche_intervention";
		}
		try {
			List<FicheMaintenanceOT> dataSource = new ArrayList<FicheMaintenanceOT>();
			dataSource.add(request.getFicheMaintenanceOT());
			// fill the ready report with data and parameter
			jasperPrint = ReportUtils.getJasperPrint(reportFicheMaintenaceOTUrl, null, dataSource);
			/// exports report to PDF
			reportLocation = Utility.getReportLocation(fileName, "pdf");
			response.setMimeType("application/pdf");
			response.setFileName(fileName + "." + "pdf");
			/* Write content to PDF file */
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(reportLocation));
			String base64 = Utility.convertFileToBase64(reportLocation);
			response.setData(base64);
		} catch (Exception e) {
			response.setHasError(true);
			response.setMessage(e.getMessage());
			logger.warn("EXCEPTION " + e.getMessage());
		}
		return response;
	}

	public static GenericReportResponse getReportFicheMaintenanceSAVOT(FicheMaintenanceOTRequest request) {
		GenericReportResponse response = new GenericReportResponse();
		String reportLocation = "";
		String fileName = null;
		if (request.getFileName() != null) {
			fileName = request.getFileName();
		} else {
			fileName = "fiche_maintenance_OT";
		}
		try {
			List<FicheMaintenanceOT> dataSource = new ArrayList<FicheMaintenanceOT>();
			dataSource.add(request.getFicheMaintenanceOT());
			// fill the ready report with data and parameter
			jasperPrint = ReportUtils.getJasperPrint(reportFicheMaintenaceSAVOTUrl, null, dataSource);
			/// exports report to PDF
			reportLocation = Utility.getReportLocation(fileName, "pdf");
			response.setMimeType("application/pdf");
			response.setFileName(fileName + "." + "pdf");
			/* Write content to PDF file */
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(reportLocation));
			String base64 = Utility.convertFileToBase64(reportLocation);
			response.setData(base64);
		} catch (Exception e) {
			response.setHasError(true);
			response.setMessage(e.getMessage());
			logger.warn("EXCEPTION " + e.getMessage());
		}
		return response;
	}
	
	public static GenericReportResponse getReportFicheInterventionFtth(FicheMaintenanceOTRequest request) {
		GenericReportResponse response = new GenericReportResponse();
		String reportLocation = "";
		String fileName = null;
		if (request.getFileName() != null) {
			fileName = request.getFileName();
		} else {
			fileName = "fiche_maintenance_OT_FTTH";
		}
		try {
			List<FicheMaintenanceOT> dataSource = new ArrayList<FicheMaintenanceOT>();
			dataSource.add(request.getFicheMaintenanceOT());
			// fill the ready report with data and parameter
			jasperPrint = ReportUtils.getJasperPrint(reportFicheMaintenaceOTFtthUrl, null, dataSource);
			/// exports report to PDF
			reportLocation = Utility.getReportLocation(fileName, "pdf");
			response.setMimeType("application/pdf");
			response.setFileName(fileName + "." + "pdf");
			/* Write content to PDF file */
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(reportLocation));
			String base64 = Utility.convertFileToBase64(reportLocation);
			response.setData(base64);
		} catch (Exception e) {
			response.setHasError(true);
			response.setMessage(e.getMessage());
			logger.warn("EXCEPTION " + e.getMessage());
		}
		return response;
	}
	
	public static GenericReportResponse getReportFicheInterventionCommandeFtth(FicheMaintenanceOTRequest request) {
		GenericReportResponse response = new GenericReportResponse();
		String reportLocation = "";
		String fileName = null;
		if (request.getFileName() != null) {
			fileName = request.getFileName();
		} else {
			fileName = "fiche_maintenance_OT_Commande_FTTH";
		}
		try {
			List<FicheMaintenanceOT> dataSource = new ArrayList<FicheMaintenanceOT>();
			dataSource.add(request.getFicheMaintenanceOT());
			// fill the ready report with data and parameter
			jasperPrint = ReportUtils.getJasperPrint(reportFicheMaintenaceOTCommandeFtthUrl, null, dataSource);
			/// exports report to PDF
			reportLocation = Utility.getReportLocation(fileName, "pdf");
			response.setMimeType("application/pdf");
			response.setFileName(fileName + "." + "pdf");
			/* Write content to PDF file */
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(reportLocation));
			String base64 = Utility.convertFileToBase64(reportLocation);
			response.setData(base64);
		} catch (Exception e) {
			response.setHasError(true);
			response.setMessage(e.getMessage());
			logger.warn("EXCEPTION " + e.getMessage());
		}
		return response;
	}
	
	public static GenericReportResponse getReportFicheEtudeCommandeFtth(FicheMaintenanceOTRequest request) {
		GenericReportResponse response = new GenericReportResponse();
		String reportLocation = "";
		String fileName = null;
		if (request.getFileName() != null) {
			fileName = request.getFileName();
		} else {
			fileName = "fiche_OT_Etude_Commande_FTTH";
		}
		try {
			List<FicheMaintenanceOT> dataSource = new ArrayList<FicheMaintenanceOT>();
			dataSource.add(request.getFicheMaintenanceOT());
			// fill the ready report with data and parameter
			jasperPrint = ReportUtils.getJasperPrint(reportFicheOTEtudeCommandeFtthUrl, null, dataSource);
			/// exports report to PDF
			reportLocation = Utility.getReportLocation(fileName, "pdf");
			response.setMimeType("application/pdf");
			response.setFileName(fileName + "." + "pdf");
			/* Write content to PDF file */
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(reportLocation));
			String base64 = Utility.convertFileToBase64(reportLocation);
			response.setData(base64);
		} catch (Exception e) {
			response.setHasError(true);
			response.setMessage(e.getMessage());
			logger.warn("EXCEPTION " + e.getMessage());
		}
		return response;
	}

	public static GenericReportResponse getReportFicheGroupePmr(PmrRequest request) throws IOException, JRException {
		GenericReportResponse response = new GenericReportResponse();
		try {
			String reportLocation = "";
			String fileName = "";
			/* Convert List to JRBeanCollectionDataSource */
			JRBeanCollectionDataSource datasDetailsGroupeJRBean = new JRBeanCollectionDataSource(
					request.getPmrDetailsGroupe());

			/* Map to hold Jasper report Parameters */
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("List_Group", datasDetailsGroupeJRBean);

			List<PmrClientCommercial> dataSource = new ArrayList<PmrClientCommercial>();
			dataSource.add(request.getPmrClientCommercial());
			// fill the ready report with data and parameter
			jasperPrint = ReportUtils.getJasperPrint(reportUrlFicheGroupe, parameters, dataSource);

			fileName = "Fiche de groupe_" + request.getPmrClientCommercial().getNomClient();

			/// exports report to PDF
			reportLocation = Utility.getReportLocation(fileName, "pdf");
			response.setMimeType("application/pdf");
			response.setFileName(fileName + "." + "pdf");
			/* Write content to PDF file */
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(reportLocation));
			String base64 = Utility.convertFileToBase64(reportLocation);
			response.setData(base64);
		} catch (JRException e) {
			// TODO: handle exception
			throw e;
		}

		return response;
	}
}
