/**
 * 
 */
package com.w4.report.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.squareup.okhttp.MediaType;
import com.w4.report.contracts.*;
import com.w4.report.models.Document;
import com.w4.report.providers.*;

/**
 * @author frederic
 *
 */
public class ReportBusiness {

	private static final Logger logger = LoggerFactory.getLogger(ReportBusiness.class);
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	public static GenericReportResponse PrintFicheInterventionSav(FicheInterventionSavRequest request) {
		GenericReportResponse response = new GenericReportResponse();

		/* Logical Code */
		if (request != null) {
			try {
				response = ReportProvider.getReportFicheInterventionSav(request);
			} catch (Exception e) {
				response.setHasError(true);
				response.setMessage(e.getMessage());
				logger.warn("EXCEPTION " + e.getMessage());
			}
		}
		/* End Logical Code */

		return response;
	}

	public static ReportResponse PrintFicheInterventionEngineSav(ReportRequest request) {
		ReportResponse response = new ReportResponse();

		/* Logical Code */
		if (request != null) {
			try {

				if (request.getVariables() != null) {

					FicheInterventionSavRequest requestFicheIntervention = new FicheInterventionSavRequest();
					String fileName = null;

					if (request.getVariables().get("idDossier") != null) {
						String idDossier = request.getVariables().get("idDossier").toString();
						fileName = "Fiche_SAV_ouverture_dossier_" + idDossier;
					}

					if (request.getVariables().get("nomClient") != null) {
						String nomClient = request.getVariables().get("nomClient").toString();
						requestFicheIntervention.getFicheInterventionSav().setNomClient(nomClient);
					}

					if (request.getVariables().get("prenomClient") != null) {
						String prenomClient = request.getVariables().get("prenomClient").toString();
						requestFicheIntervention.getFicheInterventionSav().setPrenomClient(prenomClient);
					}

					if (request.getVariables().get("contactClient") != null) {
						String contactClient = request.getVariables().get("contactClient").toString();
						requestFicheIntervention.getFicheInterventionSav().setContactClient(contactClient);
					}

					if (request.getVariables().get("contactClient2") != null) {
						String contactClient2 = request.getVariables().get("contactClient2").toString();
						requestFicheIntervention.getFicheInterventionSav().setContactClient2(contactClient2);
					}

					if (request.getVariables().get("localiteClient") != null) {
						String localiteClient = request.getVariables().get("localiteClient").toString();
						requestFicheIntervention.getFicheInterventionSav().setLocaliteClient(localiteClient);
					}

					if (request.getVariables().get("agenceType") != null) {
						String agenceType = request.getVariables().get("agenceType").toString();
						requestFicheIntervention.getFicheInterventionSav().setAgenceType(agenceType);
					}

					if (request.getVariables().get("agenceZone") != null) {
						String agenceZone = request.getVariables().get("agenceZone").toString();
						requestFicheIntervention.getFicheInterventionSav().setAgenceZone(agenceZone);
					}

					if (request.getVariables().get("loginAgentCorner") != null) {
						String loginAgentCorner = request.getVariables().get("loginAgentCorner").toString();
						requestFicheIntervention.getFicheInterventionSav().setLoginAgentCorner(loginAgentCorner);
					}

					if (request.getVariables().get("nomAgenCorner") != null) {
						String nomAgenCorner = request.getVariables().get("nomAgenCorner").toString();
						requestFicheIntervention.getFicheInterventionSav().setNomAgenCorner(nomAgenCorner);
					}

					if (request.getVariables().get("prenomAgentCorner") != null) {
						String prenomAgentCorner = request.getVariables().get("prenomAgentCorner").toString();
						requestFicheIntervention.getFicheInterventionSav().setPrenomAgentCorner(prenomAgentCorner);
					}

					if (request.getVariables().get("contactAgentCorner") != null) {
						String contactAgentCorner = request.getVariables().get("contactAgentCorner").toString();
						requestFicheIntervention.getFicheInterventionSav().setContactAgentCorner(contactAgentCorner);
					}

					if (request.getVariables().get("marqueMateriel") != null) {
						String marqueMateriel = request.getVariables().get("marqueMateriel").toString();
						requestFicheIntervention.getFicheInterventionSav().setMarqueMateriel(marqueMateriel);
					}

					if (request.getVariables().get("modeleMateriel") != null) {
						String modeleMateriel = request.getVariables().get("modeleMateriel").toString();
						requestFicheIntervention.getFicheInterventionSav().setModeleMateriel(modeleMateriel);
					}

					if (request.getVariables().get("imeiMateriel") != null) {
						String imeiMateriel = request.getVariables().get("imeiMateriel").toString();
						requestFicheIntervention.getFicheInterventionSav().setImeiMateriel(imeiMateriel);
					}

					if (request.getVariables().get("dateDepot") != null) {
						String dateDepot = request.getVariables().get("dateDepot").toString();
						requestFicheIntervention.getFicheInterventionSav().setDateDepot(dateDepot);
					}

					if (request.getVariables().get("noFactureAchat") != null) {
						String noFactureAchat = request.getVariables().get("noFactureAchat").toString();
						requestFicheIntervention.getFicheInterventionSav().setNoFactureAchat(noFactureAchat);
					}

					if (request.getVariables().get("dateFactureAchat") != null) {
						String dateFactureAchat = request.getVariables().get("dateFactureAchat").toString();
						requestFicheIntervention.getFicheInterventionSav().setDateFactureAchat(dateFactureAchat);
					}

					if (request.getVariables().get("statutGarantie") != null) {
						String statutGarantie = request.getVariables().get("statutGarantie").toString();
						requestFicheIntervention.getFicheInterventionSav().setStatutGarantie(statutGarantie);
					}

					if (request.getVariables().get("statutAssurance") != null) {
						String statutAssurance = request.getVariables().get("statutAssurance").toString();
						requestFicheIntervention.getFicheInterventionSav().setStatutAssurance(statutAssurance);
					}

					if (request.getVariables().get("dateFinGarantie") != null) {
						String dateFinGarantie = request.getVariables().get("dateFinGarantie").toString();
						requestFicheIntervention.getFicheInterventionSav().setDateFinGarantie(dateFinGarantie);
					}

					if (request.getVariables().get("savDescription") != null) {
						String savDescription = request.getVariables().get("savDescription").toString();
						requestFicheIntervention.getFicheInterventionSav().setSavDescription(savDescription);
					}

					if (request.getVariables().get("savObservation") != null) {
						String savObservation = request.getVariables().get("savObservation").toString();
						requestFicheIntervention.getFicheInterventionSav().setSavObservation(savObservation);
					}

					if (request.getVariables().get("contenuPaquetTransmis") != null) {
						String contenuPaquetTransmis = request.getVariables().get("contenuPaquetTransmis").toString();
						requestFicheIntervention.getFicheInterventionSav()
								.setContenuPaquetTransmis(contenuPaquetTransmis);
					}

					if (request.getVariables().get("panneSAV") != null) {
						String panneSAV = request.getVariables().get("panneSAV").toString();
						requestFicheIntervention.getFicheInterventionSav().setPanneSAV(panneSAV);
					}

					if (request.getVariables().get("dateFinTraitement") != null) {
						String dateFinTraitement = request.getVariables().get("dateFinTraitement").toString();
						requestFicheIntervention.getFicheInterventionSav().setDateFinTraitement(dateFinTraitement);
					}

					if (request.getVariables().get("statusDepannageNiveau2") != null) {
						String statusDepannageNiveau2 = request.getVariables().get("statusDepannageNiveau2").toString();
						requestFicheIntervention.getFicheInterventionSav()
								.setStatusDepannageNiveau2(statusDepannageNiveau2);
					}

					if (request.getVariables().get("typePersonneRecupTerminal") != null) {
						String typePersonneRecupTerminal = request.getVariables().get("typePersonneRecupTerminal")
								.toString();
						requestFicheIntervention.getFicheInterventionSav()
								.setTypePersonneRecupTerminal(typePersonneRecupTerminal);
					}

					if (request.getVariables().get("nomPersonneRecupTerminal") != null) {
						String nomPersonneRecupTerminal = request.getVariables().get("nomPersonneRecupTerminal")
								.toString();
						requestFicheIntervention.getFicheInterventionSav()
								.setNomPersonneRecupTerminal(nomPersonneRecupTerminal);
					}

					if (request.getVariables().get("prenomsPersonneRecupTerminal") != null) {
						String prenomsPersonneRecupTerminal = request.getVariables().get("prenomsPersonneRecupTerminal")
								.toString();
						requestFicheIntervention.getFicheInterventionSav()
								.setPrenomsPersonneRecupTerminal(prenomsPersonneRecupTerminal);
					}

					if (request.getVariables().get("contactPersonneRecupTerminal") != null) {
						String contactPersonneRecupTerminal = request.getVariables().get("contactPersonneRecupTerminal")
								.toString();
						requestFicheIntervention.getFicheInterventionSav()
								.setContactPersonneRecupTerminal(contactPersonneRecupTerminal);
					}

					if (request.getVariables().get("dateRemiseTerminalClient") != null) {
						String dateRemiseTerminalClient = request.getVariables().get("dateRemiseTerminalClient")
								.toString();
						requestFicheIntervention.getFicheInterventionSav()
								.setDateRemiseTerminalClient(dateRemiseTerminalClient);
					}

					if (request.getVariables().get("autrecontenuPaquetTransmis") != null) {
						String autrecontenuPaquetTransmis = request.getVariables().get("autrecontenuPaquetTransmis")
								.toString();
						requestFicheIntervention.getFicheInterventionSav()
								.setAutrecontenuPaquetTransmis(autrecontenuPaquetTransmis);
					}

					if (request.getVariables().get("newImeiMateriel") != null) {
						String newImeiMateriel = request.getVariables().get("newImeiMateriel").toString();
						requestFicheIntervention.getFicheInterventionSav().setNewImeiMateriel(newImeiMateriel);
					}

					if (request.getVariables().get("newTypeMateriel") != null) {
						String newTypeMateriel = request.getVariables().get("newTypeMateriel").toString();
						requestFicheIntervention.getFicheInterventionSav().setNewTypeMateriel(newTypeMateriel);
					}

					if (request.getVariables().get("newMarqueMateriel") != null) {
						String newMarqueMateriel = request.getVariables().get("newMarqueMateriel").toString();
						requestFicheIntervention.getFicheInterventionSav().setNewMarqueMateriel(newMarqueMateriel);
					}

					if (request.getVariables().get("contactPersonneRecupTerminal") != null) {
						String contactPersonneRecupTerminal = request.getVariables().get("contactPersonneRecupTerminal")
								.toString();
						requestFicheIntervention.getFicheInterventionSav()
								.setContactPersonneRecupTerminal(contactPersonneRecupTerminal);
					}

					requestFicheIntervention.setFileName(fileName);
					// requestFicheIntervention.getFicheInterventionSav().setAgenceType(request.getTaskItem());
					GenericReportResponse responseGeneratedDoc = ReportProvider
							.getReportFicheInterventionSav(requestFicheIntervention);
					if (responseGeneratedDoc.getHasError()) {
						throw new Exception(responseGeneratedDoc.getMessage());
					}
					Document document = new Document();
					document.setData(responseGeneratedDoc.getData());
					document.setFileName(responseGeneratedDoc.getFileName());
					document.setType(responseGeneratedDoc.getMimeType());
					response.getDocuments().add(document);
				}

			} catch (Exception e) {
				response.setHasError(true);
				response.setMessage(e.getMessage());
				logger.warn("EXCEPTION " + e.getMessage());
			}
		}
		/* End Logical Code */

		return response;
	}

	public static GenericReportResponse PrintFicheInterventionSavRemise(FicheInterventionSavRequest request) {
		GenericReportResponse response = new GenericReportResponse();

		/* Logical Code */
		if (request != null) {
			try {
				response = ReportProvider.getReportFicheInterventionSavRemise(request);
			} catch (Exception e) {
				response.setHasError(true);
				response.setMessage(e.getMessage());
				logger.warn("EXCEPTION " + e.getMessage());
			}
		}
		/* End Logical Code */

		return response;
	}

	public static ReportResponse PrintFicheInterventionEngineSavRemise(ReportRequest request) {
		ReportResponse response = new ReportResponse();

		/* Logical Code */
		if (request != null) {
			try {
				// response =
				// ReportFicheInterventionSav.getReportFicheInterventionSavRemise(request);
				if (request.getVariables() != null) {

					FicheInterventionSavRequest requestFicheIntervention = new FicheInterventionSavRequest();
					String fileName = null;

					if (request.getVariables().get("idDossier") != null) {
						String idDossier = request.getVariables().get("idDossier").toString();
						fileName = "Fiche_SAV_remise_terminal_client_" + idDossier;
					}

					if (request.getVariables().get("nomClient") != null) {
						String nomClient = request.getVariables().get("nomClient").toString();
						requestFicheIntervention.getFicheInterventionSav().setNomClient(nomClient);
					}

					if (request.getVariables().get("prenomClient") != null) {
						String prenomClient = request.getVariables().get("prenomClient").toString();
						requestFicheIntervention.getFicheInterventionSav().setPrenomClient(prenomClient);
					}

					if (request.getVariables().get("contactClient") != null) {
						String contactClient = request.getVariables().get("contactClient").toString();
						requestFicheIntervention.getFicheInterventionSav().setContactClient(contactClient);
					}

					if (request.getVariables().get("contactClient2") != null) {
						String contactClient2 = request.getVariables().get("contactClient2").toString();
						requestFicheIntervention.getFicheInterventionSav().setContactClient2(contactClient2);
					}

					if (request.getVariables().get("localiteClient") != null) {
						String localiteClient = request.getVariables().get("localiteClient").toString();
						requestFicheIntervention.getFicheInterventionSav().setLocaliteClient(localiteClient);
					}

					if (request.getVariables().get("agenceType") != null) {
						String agenceType = request.getVariables().get("agenceType").toString();
						requestFicheIntervention.getFicheInterventionSav().setAgenceType(agenceType);
					}

					if (request.getVariables().get("agenceZone") != null) {
						String agenceZone = request.getVariables().get("agenceZone").toString();
						requestFicheIntervention.getFicheInterventionSav().setAgenceZone(agenceZone);
					}

					if (request.getVariables().get("loginAgentCorner") != null) {
						String loginAgentCorner = request.getVariables().get("loginAgentCorner").toString();
						requestFicheIntervention.getFicheInterventionSav().setLoginAgentCorner(loginAgentCorner);
					}

					if (request.getVariables().get("nomAgenCorner") != null) {
						String nomAgenCorner = request.getVariables().get("nomAgenCorner").toString();
						requestFicheIntervention.getFicheInterventionSav().setNomAgenCorner(nomAgenCorner);
					}

					if (request.getVariables().get("prenomAgentCorner") != null) {
						String prenomAgentCorner = request.getVariables().get("prenomAgentCorner").toString();
						requestFicheIntervention.getFicheInterventionSav().setPrenomAgentCorner(prenomAgentCorner);
					}

					if (request.getVariables().get("contactAgentCorner") != null) {
						String contactAgentCorner = request.getVariables().get("contactAgentCorner").toString();
						requestFicheIntervention.getFicheInterventionSav().setContactAgentCorner(contactAgentCorner);
					}

					if (request.getVariables().get("marqueMateriel") != null) {
						String marqueMateriel = request.getVariables().get("marqueMateriel").toString();
						requestFicheIntervention.getFicheInterventionSav().setMarqueMateriel(marqueMateriel);
					}

					if (request.getVariables().get("modeleMateriel") != null) {
						String modeleMateriel = request.getVariables().get("modeleMateriel").toString();
						requestFicheIntervention.getFicheInterventionSav().setModeleMateriel(modeleMateriel);
					}

					if (request.getVariables().get("imeiMateriel") != null) {
						String imeiMateriel = request.getVariables().get("imeiMateriel").toString();
						requestFicheIntervention.getFicheInterventionSav().setImeiMateriel(imeiMateriel);
					}

					if (request.getVariables().get("dateDepot") != null) {
						String dateDepot = request.getVariables().get("dateDepot").toString();
						requestFicheIntervention.getFicheInterventionSav().setDateDepot(dateDepot);
					}

					if (request.getVariables().get("noFactureAchat") != null) {
						String noFactureAchat = request.getVariables().get("noFactureAchat").toString();
						requestFicheIntervention.getFicheInterventionSav().setNoFactureAchat(noFactureAchat);
					}

					if (request.getVariables().get("dateFactureAchat") != null) {
						String dateFactureAchat = request.getVariables().get("dateFactureAchat").toString();
						requestFicheIntervention.getFicheInterventionSav().setDateFactureAchat(dateFactureAchat);
					}

					if (request.getVariables().get("statutGarantie") != null) {
						String statutGarantie = request.getVariables().get("statutGarantie").toString();
						requestFicheIntervention.getFicheInterventionSav().setStatutGarantie(statutGarantie);
					}

					if (request.getVariables().get("statutAssurance") != null) {
						String statutAssurance = request.getVariables().get("statutAssurance").toString();
						requestFicheIntervention.getFicheInterventionSav().setStatutAssurance(statutAssurance);
					}

					if (request.getVariables().get("dateFinGarantie") != null) {
						String dateFinGarantie = request.getVariables().get("dateFinGarantie").toString();
						requestFicheIntervention.getFicheInterventionSav().setDateFinGarantie(dateFinGarantie);
					}

					if (request.getVariables().get("savDescription") != null) {
						String savDescription = request.getVariables().get("savDescription").toString();
						requestFicheIntervention.getFicheInterventionSav().setSavDescription(savDescription);
					}

					if (request.getVariables().get("savObservation") != null) {
						String savObservation = request.getVariables().get("savObservation").toString();
						requestFicheIntervention.getFicheInterventionSav().setSavObservation(savObservation);
					}

					if (request.getVariables().get("contenuPaquetTransmis") != null) {
						String contenuPaquetTransmis = request.getVariables().get("contenuPaquetTransmis").toString();
						requestFicheIntervention.getFicheInterventionSav()
								.setContenuPaquetTransmis(contenuPaquetTransmis);
					}

					if (request.getVariables().get("panneSAV") != null) {
						String panneSAV = request.getVariables().get("panneSAV").toString();
						requestFicheIntervention.getFicheInterventionSav().setPanneSAV(panneSAV);
					}

					if (request.getVariables().get("dateFinTraitement") != null) {
						String dateFinTraitement = request.getVariables().get("dateFinTraitement").toString();
						requestFicheIntervention.getFicheInterventionSav().setDateFinTraitement(dateFinTraitement);
					}

					if (request.getVariables().get("statusDepannageNiveau2") != null) {
						String statusDepannageNiveau2 = request.getVariables().get("statusDepannageNiveau2").toString();
						requestFicheIntervention.getFicheInterventionSav()
								.setStatusDepannageNiveau2(statusDepannageNiveau2);
					}

					if (request.getVariables().get("typePersonneRecupTerminal") != null) {
						String typePersonneRecupTerminal = request.getVariables().get("typePersonneRecupTerminal")
								.toString();
						requestFicheIntervention.getFicheInterventionSav()
								.setTypePersonneRecupTerminal(typePersonneRecupTerminal);
					}

					if (request.getVariables().get("nomPersonneRecupTerminal") != null) {
						String nomPersonneRecupTerminal = request.getVariables().get("nomPersonneRecupTerminal")
								.toString();
						requestFicheIntervention.getFicheInterventionSav()
								.setNomPersonneRecupTerminal(nomPersonneRecupTerminal);
					}

					if (request.getVariables().get("prenomsPersonneRecupTerminal") != null) {
						String prenomsPersonneRecupTerminal = request.getVariables().get("prenomsPersonneRecupTerminal")
								.toString();
						requestFicheIntervention.getFicheInterventionSav()
								.setPrenomsPersonneRecupTerminal(prenomsPersonneRecupTerminal);
					}

					if (request.getVariables().get("contactPersonneRecupTerminal") != null) {
						String contactPersonneRecupTerminal = request.getVariables().get("contactPersonneRecupTerminal")
								.toString();
						requestFicheIntervention.getFicheInterventionSav()
								.setContactPersonneRecupTerminal(contactPersonneRecupTerminal);
					}

					if (request.getVariables().get("dateRemiseTerminalClient") != null) {
						String dateRemiseTerminalClient = request.getVariables().get("dateRemiseTerminalClient")
								.toString();
						requestFicheIntervention.getFicheInterventionSav()
								.setDateRemiseTerminalClient(dateRemiseTerminalClient);
					}

					if (request.getVariables().get("autrecontenuPaquetTransmis") != null) {
						String autrecontenuPaquetTransmis = request.getVariables().get("autrecontenuPaquetTransmis")
								.toString();
						requestFicheIntervention.getFicheInterventionSav()
								.setAutrecontenuPaquetTransmis(autrecontenuPaquetTransmis);
					}

					if (request.getVariables().get("newImeiMateriel") != null) {
						String newImeiMateriel = request.getVariables().get("newImeiMateriel").toString();
						requestFicheIntervention.getFicheInterventionSav().setNewImeiMateriel(newImeiMateriel);
					}

					if (request.getVariables().get("newTypeMateriel") != null) {
						String newTypeMateriel = request.getVariables().get("newTypeMateriel").toString();
						requestFicheIntervention.getFicheInterventionSav().setNewTypeMateriel(newTypeMateriel);
					}

					if (request.getVariables().get("newMarqueMateriel") != null) {
						String newMarqueMateriel = request.getVariables().get("newMarqueMateriel").toString();
						requestFicheIntervention.getFicheInterventionSav().setNewMarqueMateriel(newMarqueMateriel);
					}

					if (request.getVariables().get("contactPersonneRecupTerminal") != null) {
						String contactPersonneRecupTerminal = request.getVariables().get("contactPersonneRecupTerminal")
								.toString();
						requestFicheIntervention.getFicheInterventionSav()
								.setContactPersonneRecupTerminal(contactPersonneRecupTerminal);
					}

					requestFicheIntervention.setFileName(fileName);
					// requestFicheIntervention.getFicheInterventionSav().setAgenceType(request.getTaskItem());
					GenericReportResponse responseGeneratedDoc = ReportProvider
							.getReportFicheInterventionSavRemise(requestFicheIntervention);
					if (responseGeneratedDoc.getHasError()) {
						throw new Exception(responseGeneratedDoc.getMessage());
					}
					Document document = new Document();
					document.setData(responseGeneratedDoc.getData());
					document.setFileName(responseGeneratedDoc.getFileName());
					document.setType(responseGeneratedDoc.getMimeType());
					response.getDocuments().add(document);
				}
			} catch (Exception e) {
				response.setHasError(true);
				response.setMessage(e.getMessage());
				logger.warn("EXCEPTION " + e.getMessage());
			}
		}
		/* End Logical Code */

		return response;

	}

	public static GenericReportResponse PrintFicheExpertAssistanceReparation(
			FicheExpertAssistanceReparationRequest request) {
		GenericReportResponse response = new GenericReportResponse();

		/* Logical Code */
		if (request != null) {
			try {
				response = ReportProvider.getReportFicheExpertAssistanceReparation(request);
			} catch (Exception e) {
				response.setHasError(true);
				response.setMessage(e.getMessage());
				logger.warn("EXCEPTION " + e.getMessage());
			}
		}
		/* End Logical Code */

		return response;
	}

	public static ReportResponse PrintFicheExpertAssistanceReparationEngine(ReportRequest request) {
		ReportResponse response = new ReportResponse();

		/* Logical Code */
		if (request != null) {
			try {
				// response =
				// ReportFicheInterventionSav.getReportFicheExpertAssistanceReparation(request);
				if (request.getVariables() != null) {

					FicheExpertAssistanceReparationRequest requestFicheExpertAssistanceReparation = new FicheExpertAssistanceReparationRequest();
					String fileName = null;

					if (request.getVariables().get("idDossier") != null) {
						String idDossier = request.getVariables().get("idDossier").toString();
						fileName = "Fiche_expert_assistance_reparation_" + idDossier;
					}

					if (request.getVariables().get("nomClient") != null) {
						String nomClient = request.getVariables().get("nomClient").toString();
						requestFicheExpertAssistanceReparation.getFicheExpertAssistanceReparation()
								.setNomClient(nomClient);
					}

					if (request.getVariables().get("prenomClient") != null) {
						String prenomClient = request.getVariables().get("prenomClient").toString();
						requestFicheExpertAssistanceReparation.getFicheExpertAssistanceReparation()
								.setPrenomClient(prenomClient);
					}

					if (request.getVariables().get("contactClient") != null) {
						String contactClient = request.getVariables().get("contactClient").toString();
						requestFicheExpertAssistanceReparation.getFicheExpertAssistanceReparation()
								.setContactClient(contactClient);
					}

					if (request.getVariables().get("raisonSocialeClient") != null) {
						String raisonSocialeClient = request.getVariables().get("raisonSocialeClient").toString();
						requestFicheExpertAssistanceReparation.getFicheExpertAssistanceReparation()
								.setRaisonSocialeClient(raisonSocialeClient);
					}

					if (request.getVariables().get("villeClient") != null) {
						String villeClient = request.getVariables().get("villeClient").toString();
						requestFicheExpertAssistanceReparation.getFicheExpertAssistanceReparation()
								.setVilleClient(villeClient);
					}
					if (request.getVariables().get("communeClient") != null) {
						String communeClient = request.getVariables().get("communeClient").toString();
						requestFicheExpertAssistanceReparation.getFicheExpertAssistanceReparation()
								.setCommuneClient(communeClient);
					}

					if (request.getVariables().get("emailClient") != null) {
						String emailClient = request.getVariables().get("emailClient").toString();
						requestFicheExpertAssistanceReparation.getFicheExpertAssistanceReparation()
								.setEmailClient(emailClient);
					}

					if (request.getVariables().get("adressePostaleClient") != null) {
						String adressePostaleClient = request.getVariables().get("adressePostaleClient").toString();
						requestFicheExpertAssistanceReparation.getFicheExpertAssistanceReparation()
								.setAdressePostaleClient(adressePostaleClient);
					}

					if (request.getVariables().get("pieceFourneClient") != null) {
						String pieceFourneClient = request.getVariables().get("pieceFourneClient").toString();
						requestFicheExpertAssistanceReparation.getFicheExpertAssistanceReparation()
								.setPieceFourneClient(pieceFourneClient);
					}

					if (request.getVariables().get("numeroPieceClient") != null) {
						String numeroPieceClient = request.getVariables().get("numeroPieceClient").toString();
						requestFicheExpertAssistanceReparation.getFicheExpertAssistanceReparation()
								.setNumeroPieceClient(numeroPieceClient);
					}

					if (request.getVariables().get("designationPanneReparation") != null) {
						String designationPanneReparation = request.getVariables().get("designationPanneReparation")
								.toString();
						requestFicheExpertAssistanceReparation.getFicheExpertAssistanceReparation()
								.setDesignationPanneReparation(designationPanneReparation);
					}

					if (request.getVariables().get("prixUnitaireReparation") != null) {
						String prixUnitaireReparation = request.getVariables().get("prixUnitaireReparation").toString();
						requestFicheExpertAssistanceReparation.getFicheExpertAssistanceReparation()
								.setPrixUnitaireReparation(prixUnitaireReparation);
					}

					if (request.getVariables().get("quantiteReparation") != null) {
						String quantiteReparation = request.getVariables().get("quantiteReparation").toString();
						requestFicheExpertAssistanceReparation.getFicheExpertAssistanceReparation()
								.setQuantiteReparation(quantiteReparation);
					}

					if (request.getVariables().get("montantReglerReparation") != null) {
						String montantReglerReparation = request.getVariables().get("montantReglerReparation")
								.toString();
						requestFicheExpertAssistanceReparation.getFicheExpertAssistanceReparation()
								.setMontantReglerReparation(montantReglerReparation);
					}

					if (request.getVariables().get("montantTotalForfaitsHT") != null) {
						String montantTotalForfaitsHT = request.getVariables().get("montantTotalForfaitsHT").toString();
						requestFicheExpertAssistanceReparation.getFicheExpertAssistanceReparation()
								.setMontantTotalForfaitsHT(montantTotalForfaitsHT);
					}

					if (request.getVariables().get("montantTotalForfaitsTTC") != null) {
						String montantTotalForfaitsTTC = request.getVariables().get("montantTotalForfaitsTTC")
								.toString();
						requestFicheExpertAssistanceReparation.getFicheExpertAssistanceReparation()
								.setMontantTotalForfaitsTTC(montantTotalForfaitsTTC);
					}

					if (request.getVariables().get("modePaiemantReparation") != null) {
						String modePaiemantReparation = request.getVariables().get("modePaiemantReparation").toString();
						requestFicheExpertAssistanceReparation.getFicheExpertAssistanceReparation()
								.setModePaiemantReparation(modePaiemantReparation);
					}

					if (request.getVariables().get("numeroFicheReparation") != null) {
						String numeroFicheReparation = request.getVariables().get("numeroFicheReparation").toString();
						if (request.getVariables().get("idDossier") != null) {
							numeroFicheReparation = numeroFicheReparation
									+ request.getVariables().get("idDossier").toString();
						}
						requestFicheExpertAssistanceReparation.getFicheExpertAssistanceReparation()
								.setNumeroFicheReparation(numeroFicheReparation);
					}

					requestFicheExpertAssistanceReparation.setFileName(fileName);
					GenericReportResponse responseGeneratedDoc = ReportProvider
							.getReportFicheExpertAssistanceReparation(requestFicheExpertAssistanceReparation);
					if (responseGeneratedDoc.getHasError()) {
						throw new Exception(responseGeneratedDoc.getMessage());
					}
					Document document = new Document();
					document.setData(responseGeneratedDoc.getData());
					document.setFileName(responseGeneratedDoc.getFileName());
					document.setType(responseGeneratedDoc.getMimeType());
					response.getDocuments().add(document);
				}
			} catch (Exception e) {
				response.setHasError(true);
				response.setMessage(e.getMessage());
				logger.warn("EXCEPTION " + e.getMessage());
			}
		}
		/* End Logical Code */

		return response;
	}

	public static GenericReportResponse PrintFicheMaintenanceOT(FicheMaintenanceOTRequest request) {
		GenericReportResponse response = new GenericReportResponse();

		/* Logical Code */
		if (request != null) {
			try {
				response = ReportProvider.getReportFicheMaintenanceOT(request);
			} catch (Exception e) {
				response.setHasError(true);
				response.setMessage(e.getMessage());
				logger.warn("EXCEPTION " + e.getMessage());
			}
		}
		/* End Logical Code */

		return response;
	}
	
	public static GenericReportResponse PrintFicheMaintenanceSAVOT(FicheMaintenanceOTRequest request) {
		GenericReportResponse response = new GenericReportResponse();

		/* Logical Code */
		if (request != null) {
			try {
				response = ReportProvider.getReportFicheMaintenanceSAVOT(request);
			} catch (Exception e) {
				response.setHasError(true);
				response.setMessage(e.getMessage());
				logger.warn("EXCEPTION " + e.getMessage());
			}
		}
		/* End Logical Code */

		return response;
	}
		
	
	public static GenericReportResponse PrintFicheInterventionFtth(FicheMaintenanceOTRequest request) {
		GenericReportResponse response = new GenericReportResponse();

		/* Logical Code */
		if (request != null) {
			try {
				response = ReportProvider.getReportFicheInterventionFtth(request);
			} catch (Exception e) {
				response.setHasError(true);
				response.setMessage(e.getMessage());
				logger.warn("EXCEPTION " + e.getMessage());
			}
		}
		/* End Logical Code */

		return response;
	}
	
	public static GenericReportResponse PrintFicheInterventionCommandeFtth(FicheMaintenanceOTRequest request) {
		GenericReportResponse response = new GenericReportResponse();

		/* Logical Code */
		if (request != null) {
			try {
				response = ReportProvider.getReportFicheInterventionCommandeFtth(request);
			} catch (Exception e) {
				response.setHasError(true);
				response.setMessage(e.getMessage());
				logger.warn("EXCEPTION " + e.getMessage());
			}
		}
		/* End Logical Code */

		return response;
	}
	
	public static GenericReportResponse PrintFicheEtudeCommandeFtth(FicheMaintenanceOTRequest request) {
		GenericReportResponse response = new GenericReportResponse();

		/* Logical Code */
		if (request != null) {
			try {
				response = ReportProvider.getReportFicheEtudeCommandeFtth(request);
			} catch (Exception e) {
				response.setHasError(true);
				response.setMessage(e.getMessage());
				logger.warn("EXCEPTION " + e.getMessage());
			}
		}
		/* End Logical Code */

		return response;
	}
	
	
	public static GenericReportResponse getReportFicheGroupePmr(PmrRequest request) {
		GenericReportResponse response = new GenericReportResponse();

		/* Logical Code */
		if (request != null) {
			try {
				response = ReportProvider.getReportFicheGroupePmr(request);
			} catch (Exception e) {
				response.setHasError(true);
				response.setMessage(e.getMessage());
				logger.warn("EXCEPTION " + e.getMessage());
			}
		}
		/* End Logical Code */

		return response;
	}
}
