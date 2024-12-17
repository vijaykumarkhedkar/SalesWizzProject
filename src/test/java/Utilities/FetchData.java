package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class FetchData {

	Properties prop;

	public FetchData() {
		File src = new File("C:\\Users\\mrk\\Desktop\\SambramAutomation\\SalesWizzAutomation\\Data.Properties\\Data.properties");
		try (FileInputStream file = new FileInputStream(src)) {
			prop = new Properties();
			prop.load(file);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String GetURL() {
		String url = prop.getProperty("URL");
		return url;

	}
	
	public String GetMobileNo() {
		String MobNo=prop.getProperty("MobileNo");
		return MobNo;
	}
	
	public String GetProdescrp() {
		String ProductDescription=prop.getProperty("P_Description");
		return ProductDescription;
	}
	
	public String GetNewMobNumber() {
		return prop.getProperty("NewMobNumber");
		
	}
	public String GetSupplierName() {
		 return prop.getProperty("SupplierName");
	}
	public String GetCompanyName() {
		return prop.getProperty("CompanyName");
	}
	public String GetMobileNumber() {
		return prop.getProperty("MobileNumber");
	}
	public String GetEmail() {
		return prop.getProperty("Email");
	}
	public String GetPinCode() {
		return prop.getProperty("PinCode");
	}
	public String GetAdressLine1() {
		return prop.getProperty("AdressLine1");
	}
	public String GetAdressLine2() {
		return prop.getProperty("AdressLine2");
	}
	public String GetCatalogueName() {
		return prop.getProperty("CatalogueNameForBulkOrder");
	}
}		
