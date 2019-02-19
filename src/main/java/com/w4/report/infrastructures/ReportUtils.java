package com.w4.report.infrastructures;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class ReportUtils {

	public static JasperPrint getJasperPrint(String reportUrl, Map<String, Object> parameters, Collection<?> dataSource)
			throws JRException {
		JasperPrint jasperPrint;

		try {
			InputStream resourceAsStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(reportUrl);
			// get report file and then load into jasperDesign
			JasperDesign jasperDesign = JRXmlLoader.load(resourceAsStream);

			// compile the jasperDesign
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

			// fill the ready report with data and parameter
			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
					new JRBeanCollectionDataSource(dataSource));

		} catch (JRException e) {
			// TODO: handle exception
			throw e;
		}

		return jasperPrint;
	}

	public static File getNewFile(String path) {
		return new File(getAbsoluePath(path));
	}

	public static boolean existFile(String path) {
		File file = getNewFile(path);
		return file.exists();
	}

	public static String getAbsoluePath(String path) {
		String fullPath = path;

		Object object = Thread.currentThread().getContextClassLoader().getResource(path);
		if (object != null) {
			fullPath = Thread.currentThread().getContextClassLoader().getResource(path).getFile();
		}

		return fullPath;
	}
}
