/**
 * 
 */
package com.w4.report.infrastructures;

import java.awt.image.BufferedImage;
import java.io.*;
import java.security.GeneralSecurityException;
import java.security.spec.KeySpec;
import java.util.*;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;

import org.apache.commons.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.tomcat.util.codec.binary.Base64;

import eu.w4.bpm.BPMVariableMap;
import eu.w4.common.configuration.NetConfigurationKey;

import com.w4.report.models.*;

/**
 * @author frederic
 *
 */
public class Utility {

	private static final Logger logger = LoggerFactory.getLogger(Utility.class);

	public static Map<NetConfigurationKey, String> params(String host, String port, String mode) {

		Map<NetConfigurationKey, String> parameters = new HashMap<>();

		parameters.put(NetConfigurationKey.RMI_REGISTRY_HOST, host);
		parameters.put(NetConfigurationKey.RMI_REGISTRY_PORT, port);
		parameters.put(NetConfigurationKey.COMMUNICATION_MODE, mode);

		return parameters;
	}

	public static String translateState(String etat) {
		Map<String, String> stat = new HashMap<>();
		stat.put("CANCELLED", "Annulé");
		stat.put("CREATED", "Créé");
		stat.put("DELAGATED", "Delegué");
		stat.put("DONE", "Terminé");
		stat.put("EXPIRED", "Expiré");
		stat.put("OFFERED", "Offert");
		stat.put("REASSIGNED", "Reassigné");
		stat.put("RUNNING", "En cours");
		stat.put("SAVED", "Sauvegardé");
		stat.put("SUSPENDED", "Suspendu");
		try {
			return (String) stat.get(etat);
		} catch (Exception e) {
		}
		return etat;
	}

	public static boolean saveImage(String base64String, String nomCompletImage, String extension) {

		try {
			BufferedImage image = decodeToImage(base64String);

			if (image == null) {
				return false;
			}

			File f = new File(nomCompletImage);

			// write the image
			ImageIO.write(image, extension, f);
		} catch (Exception ex) {
			logger.warn("EXCEPTION : " + ex.getMessage());
		}
		return true;
	}

	public static String generatedDataFromBase64(String base64) {
		String data = base64;

		if (base64.contains(",")) {
			String[] parts = base64.split(",");
			data = parts[1];
		}

		return data;
	}

	public static String generatedMimeTypeFromBase64(String base64) {
		String data = base64;

		if (base64.contains(",")) {
			String[] parts = base64.split(",");
			data = parts[0];
			if (data.contains(";")) {
				String[] partsInfoFile = data.split(";");
				data = partsInfoFile[0];
				if (data.contains(":")) {
					String[] partsMimeType = data.split(":");
					data = partsMimeType[1];
				}
			}
		}

		return data;
	}

	public static String getReportLocation(String reportTemplateName, String fileExtension) {
		String filesDirectory = "/tmp/";
		Utility.createDirectory(filesDirectory);

		if (!filesDirectory.endsWith("/"))
			filesDirectory += "/";
		reportTemplateName = (reportTemplateName != null) ? reportTemplateName : "";

		return filesDirectory + reportTemplateName + "." + fileExtension;
	}

	public static void savePiece(String base64String, String cheminComplet) {

		try {
			byte[] fileByte;
			String data = generatedDataFromBase64(base64String);
			fileByte = Base64.decodeBase64(data);

			try (OutputStream stream = new FileOutputStream(cheminComplet)) {
				stream.write(fileByte);
			} catch (Exception Ex) {
				logger.warn(Ex.getMessage());
			}

		} catch (Exception ex) {
			logger.warn("EXCEPTION : " + ex.getMessage());
		}
	}

	public static BufferedImage decodeToImage(String base64) {

		BufferedImage image = null;
		try {

			String data = generatedDataFromBase64(base64);
			byte[] imageByte = Base64.decodeBase64(data);

			try (ByteArrayInputStream bis = new ByteArrayInputStream(imageByte)) {
				image = ImageIO.read(bis);
			} catch (Exception Ex) {
				logger.warn("EXCEPTION : " + Ex.getMessage());
			}
		} catch (Exception ex) {
			logger.warn("EXCEPTION : " + ex.getMessage());
		}
		return image;
	}

	public static byte[] inputStreamToByteArray(InputStream is) {

		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		byte[] byteArray = null;

		try {
			int nRead;
			byte[] data = new byte[1024];
			while ((nRead = is.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, nRead);
			}

			buffer.flush();
			byteArray = buffer.toByteArray();
		} catch (Exception ex) {
			logger.warn("EXCEPTION : " + ex.getMessage());
		}
		return byteArray;
	}

	public static Fichier downloadFile(String filePath) {

		Fichier download = new Fichier();
		download.setFile(new File(filePath));
		int fileNbBytes = new Long(download.getFile().length()).intValue();
		download.setBytes(new byte[fileNbBytes]);

		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(download.getFile());
		} catch (FileNotFoundException exception) {
			logger.warn("Fichier introuvable : " + exception.getMessage());
		}
		try {
			inputStream.read(download.getBytes());
		} catch (IOException exception) {
			logger.warn("Erreur I/O : " + exception.getMessage());
		}
		return download;
	}

	public static String convertFileToBase64(String pathFichier) {

		File originalFile = new File(pathFichier);
		String encodedBase64 = null;
		FileInputStream fileInputStreamReader = null;
		try {
			fileInputStreamReader = new FileInputStream(originalFile);
			byte[] bytes = new byte[(int) originalFile.length()];
			fileInputStreamReader.read(bytes);
			encodedBase64 = new String(Base64.encodeBase64(bytes));
		} catch (FileNotFoundException e) {
			logger.warn("Exception : " + e.getMessage());
		} catch (IOException e) {
			logger.warn("Exception : " + e.getMessage());
		} finally {
			try {
				fileInputStreamReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.warn("Exception : " + e.getMessage());
			}
		}
		return encodedBase64;
	}

	public static String formatToBase64(String base64, String mimeType) throws IOException {
		base64 = "data:" + mimeType + ";base64," + base64;
		return base64;
	}

	public static String convertInputStreamToFile(InputStream file, String fileName) {

		byte[] buffer = new byte[1024];
		BufferedInputStream bis;
		String fileNameBase64 = null;
		try {
			String folderName = "/tmp";
			bis = new BufferedInputStream(file);

			if (!new File(folderName).exists()) {
				new File(folderName).mkdirs();
			}

			File newFile = new File(folderName + "/" + fileName);

			// Download file
			OutputStream os = new FileOutputStream(newFile);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			int readCount;
			while ((readCount = bis.read(buffer)) > 0) {
				bos.write(buffer, 0, readCount);
			}
			bis.close();
			bos.close();

			fileNameBase64 = convertFileToBase64(folderName + "/" + fileName);
		} catch (Exception ex) {
			logger.warn("EXCEPTION " + ex.getMessage());
		}
		return fileNameBase64;
	}

	public static void deleteFile(String chemin) {

		File file = new File(chemin);
		try {
			if (file.exists() && file.getName() != null && !file.getName().isEmpty()) {
				FileUtils.forceDelete(new File(chemin));
			}
		} catch (IOException e) {
			logger.warn("EXCEPTION : " + e.getMessage());
		}
	}

	public static Map<String, Object> setTaskVariable(BPMVariableMap taskVariables) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			for (String variableName : taskVariables.keySet()) {
				map.put(variableName, taskVariables.get(variableName).getValue());
			}
		} catch (Exception e) {
			logger.warn("EXCEPTION : " + e.getMessage());
		}
		return map;
	}

	public static byte[] serialize(Object obj) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(out);
		os.writeObject(obj);
		return out.toByteArray();
	}

	private static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
		}
		return data;
	}

	private static SecretKey generateKey(String password, byte[] saltBytes) throws GeneralSecurityException {
		KeySpec keySpec = new PBEKeySpec(password.toCharArray(), saltBytes, 100, 128);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		SecretKey secretKey = keyFactory.generateSecret(keySpec);
		return new SecretKeySpec(secretKey.getEncoded(), "AES");
	}

	private static String convertBase64ToString(String base64, int iteration) {
		String pwd = "";
		int i = 0;
		while (i < iteration) {
			pwd = new String(Base64.decodeBase64(base64));
			base64 = pwd;
			i++;
		}
		return pwd;
	}

	public static String decrypt(String message) {
		String finalPassword = "";
		try {
			String salt = message.substring(0, 32);
			String iv = message.substring(32, 64);
			String key = message.substring(64, 96);
			int nbreIteration = Integer.parseInt(message.substring(96, 97));
			String encrypted = message.substring(97);
			byte[] saltBytes = hexStringToByteArray(salt);
			byte[] ivBytes = hexStringToByteArray(iv);
			IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);
			SecretKeySpec sKey = (SecretKeySpec) generateKey(key, saltBytes);
			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			c.init(Cipher.DECRYPT_MODE, sKey, ivParameterSpec);
			byte[] decordedValue = Base64.decodeBase64(encrypted);
			byte[] decValue = c.doFinal(decordedValue);
			String decryptedValue = new String(decValue);
			finalPassword = convertBase64ToString(decryptedValue, nbreIteration);
		} catch (Exception ex) {
			logger.warn("Erreur: " + ex.getMessage());
		}
		return finalPassword;
	}

	public static void createDirectory(String chemin) {
		File file = new File(chemin);
		if (!file.exists()) {
			try {
				FileUtils.forceMkdir(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static Date getCurrentDate() {
		return new Date();
	}
}
