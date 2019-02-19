package com.w4.report.services;

/**
 * @author misdagbo
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.w4.report.business.*;
import com.w4.report.contracts.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/report")
public class Service {

	private static final Logger logger = LoggerFactory.getLogger(Service.class);

	@RequestMapping(value = "/printFicheInterventionSav", method = RequestMethod.POST, produces = {
			"application/json" }, consumes = { "application/json" })
	public GenericReportResponse printFicheInterventionSav(@RequestBody FicheInterventionSavRequest request) {
		logger.info("...........................begin method PrintFicheInterventionSav............................");
		GenericReportResponse response = new GenericReportResponse();
		try {
			response = ReportBusiness.PrintFicheInterventionSav(request);

			if (response.getHasError()) {
				throw new Exception(response.getMessage());
			}
		} catch (Exception ex) {
			response.setHasError(true);
			response.setMessage("Une erreur est survenue au cours de l'exécution de la requête");
			logger.warn((ex.getMessage() == null || ex.getMessage().isEmpty())
					? "Une erreur est survenue au cours de l'exécution de la requête"
					: ex.getMessage());
		}
		logger.info("...........................end method PrintFicheInterventionSav............................");
		return response;
	}

	@RequestMapping(value = "/printFicheInterventionEngineSav", method = RequestMethod.POST, produces = {
			"application/json" }, consumes = { "application/json" })
	public ReportResponse printFicheInterventionEngineSav(@RequestBody ReportRequest request) {
		logger.info(
				"...........................begin method printFicheInterventionEngineSav............................");
		ReportResponse response = new ReportResponse();
		try {
			response = ReportBusiness.PrintFicheInterventionEngineSav(request);

			if (response.getHasError()) {
				throw new Exception(response.getMessage());
			}
		} catch (Exception ex) {
			response.setHasError(true);
			response.setMessage("Une erreur est survenue au cours de l'exécution de la requête");
			logger.warn((ex.getMessage() == null || ex.getMessage().isEmpty())
					? "Une erreur est survenue au cours de l'exécution de la requête"
					: ex.getMessage());
		}
		logger.info(
				"...........................end method printFicheInterventionEngineSav............................");
		return response;
	}

	@RequestMapping(value = "/printFicheInterventionSavRemise", method = RequestMethod.POST, produces = {
			"application/json" }, consumes = { "application/json" })
	public GenericReportResponse printFicheInterventionSavRemise(@RequestBody FicheInterventionSavRequest request) {
		logger.info(
				"...........................begin method PrintFicheInterventionSavRemise............................");
		GenericReportResponse response = new GenericReportResponse();
		try {
			response = ReportBusiness.PrintFicheInterventionSavRemise(request);

			if (response.getHasError()) {
				throw new Exception(response.getMessage());
			}
		} catch (Exception ex) {
			response.setHasError(true);
			response.setMessage("Une erreur est survenue au cours de l'exécution de la requête");
			logger.warn((ex.getMessage() == null || ex.getMessage().isEmpty())
					? "Une erreur est survenue au cours de l'exécution de la requête"
					: ex.getMessage());
		}
		logger.info(
				"...........................end method PrintFicheInterventionSavRemise............................");
		return response;
	}

	@RequestMapping(value = "/printFicheInterventionEngineSavRemise", method = RequestMethod.POST, produces = {
			"application/json" }, consumes = { "application/json" })
	public ReportResponse printFicheInterventionEngineSavRemise(@RequestBody ReportRequest request) {
		logger.info(
				"...........................begin method printFicheInterventionEngineSavRemise............................");
		ReportResponse response = new ReportResponse();
		try {
			response = ReportBusiness.PrintFicheInterventionEngineSavRemise(request);

			if (response.getHasError()) {
				throw new Exception(response.getMessage());
			}
		} catch (Exception ex) {
			response.setHasError(true);
			response.setMessage("Une erreur est survenue au cours de l'exécution de la requête");
			logger.warn((ex.getMessage() == null || ex.getMessage().isEmpty())
					? "Une erreur est survenue au cours de l'exécution de la requête"
					: ex.getMessage());
		}
		logger.info(
				"...........................end method printFicheInterventionEngineSavRemise............................");
		return response;
	}

	@RequestMapping(value = "/printFicheExpertAssistanceReparation", method = RequestMethod.POST, produces = {
			"application/json" }, consumes = { "application/json" })
	public GenericReportResponse printFicheExpertAssistanceReparation(
			@RequestBody FicheExpertAssistanceReparationRequest request) {
		logger.info(
				"...........................begin method printFicheExpertAssistanceReparation............................");
		GenericReportResponse response = new GenericReportResponse();
		try {
			response = ReportBusiness.PrintFicheExpertAssistanceReparation(request);

			if (response.getHasError()) {
				throw new Exception(response.getMessage());
			}
		} catch (Exception ex) {
			response.setHasError(true);
			response.setMessage("Une erreur est survenue au cours de l'exécution de la requête");
			logger.warn((ex.getMessage() == null || ex.getMessage().isEmpty())
					? "Une erreur est survenue au cours de l'exécution de la requête"
					: ex.getMessage());
		}
		logger.info(
				"...........................end method printFicheExpertAssistanceReparation............................");
		return response;
	}

	@RequestMapping(value = "/printFicheExpertAssistanceReparationEngine", method = RequestMethod.POST, produces = {
			"application/json" }, consumes = { "application/json" })
	public ReportResponse printFicheExpertAssistanceReparation(@RequestBody ReportRequest request) {
		logger.info(
				"...........................begin method printFicheExpertAssistanceReparationEngine............................");
		ReportResponse response = new ReportResponse();
		try {
			response = ReportBusiness.PrintFicheExpertAssistanceReparationEngine(request);

			if (response.getHasError()) {
				throw new Exception(response.getMessage());
			}
		} catch (Exception ex) {
			response.setHasError(true);
			response.setMessage("Une erreur est survenue au cours de l'exécution de la requête");
			logger.warn((ex.getMessage() == null || ex.getMessage().isEmpty())
					? "Une erreur est survenue au cours de l'exécution de la requête"
					: ex.getMessage());
		}
		logger.info(
				"...........................end method printFicheExpertAssistanceReparationEngine............................");
		return response;
	}

	@RequestMapping(value = "/printFicheMaintenanceOT", method = RequestMethod.POST, produces = {
			"application/json" }, consumes = { "application/json" })
	public GenericReportResponse printFicheMaintenanceOT(@RequestBody FicheMaintenanceOTRequest request) {
		logger.info("...........................begin method printFicheMaintenanceOT............................");
		GenericReportResponse response = new GenericReportResponse();
		try {
			response = ReportBusiness.PrintFicheMaintenanceOT(request);

			if (response.getHasError()) {
				throw new Exception(response.getMessage());
			}
		} catch (Exception ex) {
			response.setHasError(true);
			response.setMessage("Une erreur est survenue au cours de l'exécution de la requête");
			logger.warn((ex.getMessage() == null || ex.getMessage().isEmpty())
					? "Une erreur est survenue au cours de l'exécution de la requête"
					: ex.getMessage());
		}
		logger.info("...........................end method printFicheMaintenanceOT............................");
		return response;
	}

	@RequestMapping(value = "/printFicheMaintenanceSAVOT", method = RequestMethod.POST, produces = {
			"application/json" }, consumes = { "application/json" })
	public GenericReportResponse printFicheMaintenanceSAVOT(@RequestBody FicheMaintenanceOTRequest request) {
		logger.info("...........................begin method printFicheMaintenanceSAVOT............................");
		GenericReportResponse response = new GenericReportResponse();
		try {
			response = ReportBusiness.PrintFicheMaintenanceSAVOT(request);

			if (response.getHasError()) {
				throw new Exception(response.getMessage());
			}
		} catch (Exception ex) {
			response.setHasError(true);
			response.setMessage("Une erreur est survenue au cours de l'exécution de la requête");
			logger.warn((ex.getMessage() == null || ex.getMessage().isEmpty())
					? "Une erreur est survenue au cours de l'exécution de la requête"
					: ex.getMessage());
		}
		logger.info("...........................end method printFicheMaintenanceSAVOT............................");
		return response;
	}

	@RequestMapping(value = "/printFicheInterventionFtth", method = RequestMethod.POST, produces = {
			"application/json" }, consumes = { "application/json" })
	public GenericReportResponse printFicheInterventionFtth(@RequestBody FicheMaintenanceOTRequest request) {
		logger.info("...........................begin method PrintFicheInterventionFtth............................");
		GenericReportResponse response = new GenericReportResponse();
		try {
			response = ReportBusiness.PrintFicheInterventionFtth(request);

			if (response.getHasError()) {
				throw new Exception(response.getMessage());
			}
		} catch (Exception ex) {
			response.setHasError(true);
			response.setMessage("Une erreur est survenue au cours de l'exécution de la requête");
			logger.warn((ex.getMessage() == null || ex.getMessage().isEmpty())
					? "Une erreur est survenue au cours de l'exécution de la requête"
					: ex.getMessage());
		}
		logger.info("...........................end method PrintFicheInterventionFtth............................");
		return response;
	}

	@RequestMapping(value = "/printFicheInterventionCommandeFtth", method = RequestMethod.POST, produces = {
			"application/json" }, consumes = { "application/json" })
	public GenericReportResponse printFicheInterventionCommandeFtth(@RequestBody FicheMaintenanceOTRequest request) {
		logger.info(
				"...........................begin method printFicheInterventionCommandeFtth............................");
		GenericReportResponse response = new GenericReportResponse();
		try {
			response = ReportBusiness.PrintFicheInterventionCommandeFtth(request);

			if (response.getHasError()) {
				throw new Exception(response.getMessage());
			}
		} catch (Exception ex) {
			response.setHasError(true);
			response.setMessage("Une erreur est survenue au cours de l'exécution de la requête");
			logger.warn((ex.getMessage() == null || ex.getMessage().isEmpty())
					? "Une erreur est survenue au cours de l'exécution de la requête"
					: ex.getMessage());
		}
		logger.info(
				"...........................end method printFicheInterventionCommandeFtth............................");
		return response;
	}

	@RequestMapping(value = "/printFicheEtudeCommandeFtth", method = RequestMethod.POST, produces = {
			"application/json" }, consumes = { "application/json" })
	public GenericReportResponse printFicheEtudeCommandeFtth(@RequestBody FicheMaintenanceOTRequest request) {
		logger.info("...........................begin method printFicheEtudeCommandeFtth............................");
		GenericReportResponse response = new GenericReportResponse();
		try {
			response = ReportBusiness.PrintFicheEtudeCommandeFtth(request);

			if (response.getHasError()) {
				throw new Exception(response.getMessage());
			}
		} catch (Exception ex) {
			response.setHasError(true);
			response.setMessage("Une erreur est survenue au cours de l'exécution de la requête");
			logger.warn((ex.getMessage() == null || ex.getMessage().isEmpty())
					? "Une erreur est survenue au cours de l'exécution de la requête"
					: ex.getMessage());
		}
		logger.info("...........................end method printFicheEtudeCommandeFtth............................");
		return response;
	}

	@RequestMapping(value = "/getReportFicheGroupePmr", method = RequestMethod.POST, produces = {
			"application/json" }, consumes = { "application/json" })
	public GenericReportResponse getReportFicheGroupePmr(@RequestBody PmrRequest request) {
		logger.info("...........................begin method getReportFicheGroupePmr............................");
		GenericReportResponse response = new GenericReportResponse();
		try {
			response = ReportBusiness.getReportFicheGroupePmr(request);

			if (response.getHasError()) {
				throw new Exception(response.getMessage());
			}
		} catch (Exception ex) {
			response.setHasError(true);
			response.setMessage("Une erreur est survenue au cours de l'exécution de la requête");
			logger.warn((ex.getMessage() == null || ex.getMessage().isEmpty())
					? "Une erreur est survenue au cours de l'exécution de la requête"
					: ex.getMessage());
		}
		logger.info("...........................end method getReportFicheGroupePmr............................");
		return response;
	}

}