package cucumber.helper;

import org.testng.annotations.DataProvider;

import com.framework.config.PropertiesRepository;
import com.framework.utils.ExcelUtils;
import com.sc.constants.SCconstants;

public class Data {
	@DataProvider(name = SCconstants.dataProviderMethod)
	public Object[][] getDatagetTestDataFromExcel() {
		String filePath = System.getProperty("user.dir") + PropertiesRepository.getString("feature.excel.file");
		String[][] featureList = ExcelUtils.getFeatureFiles(filePath, SCconstants.featureSheetName);

		return featureList;
	}

}
