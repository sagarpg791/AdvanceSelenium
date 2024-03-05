package CommonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PropertyFileUtil {
	
	public String getDataFromPropertyFile(String keyname) throws IOException {
		
		FileInputStream fis = new FileInputStream("src/test/resources/Logincrediantial.properties");
		 Properties p = new Properties();
		 p.load(fis);
		String value = p.getProperty(keyname);
		 return value;
	}

}
