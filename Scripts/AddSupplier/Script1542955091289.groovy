import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl('https://phptravels.net/admin')

WebUI.setText(findTestObject('Page_Administator Login/input_email'), 'admin@phptravels.comdemoa')

WebUI.setText(findTestObject('Page_Administator Login/input_email'), 'admin@phptravels.com')

WebUI.setText(findTestObject('Page_Administator Login/input_password'), 'demoadmin')

WebUI.click(findTestObject('Page_Administator Login/span_Login'))

WebUI.click(findTestObject('Page_Dashboard/a_Accounts'))

WebUI.click(findTestObject('Supplier/ClickSupplier'))

WebUI.click(findTestObject('Page_Admins Management/i_glyphicon glyphicon-plus-sig'))

def ExcelData = findTestData('SupplierData')

int i = 1

WebUI.setText(findTestObject('Page_AddAdmin/tabledata', [('var') : 'fname']), ExcelData.getValue(i++, 1))

WebUI.setText(findTestObject('Page_AddAdmin/tabledata', [('var') : 'lname']), ExcelData.getValue(i++, 1))

WebUI.setText(findTestObject('Page_AddAdmin/tabledata', [('var') : 'email']), ExcelData.getValue(i++, 1))

WebUI.setText(findTestObject('Page_AddAdmin/tabledata', [('var') : 'password']), ExcelData.getValue(i++, 1))

WebUI.setText(findTestObject('Page_AddAdmin/tabledata', [('var') : 'mobile']), ExcelData.getValue(i++, 1))

WebUI.click(findTestObject('Page_AddAdmin/SelectDD'))

WebUI.delay(5)

WebUI.click(findTestObject('Page_AddAdmin/Country', [('Country1') : ExcelData.getValue(i++, 1)]))

WebUI.delay(5)

WebUI.setText(findTestObject('Page_AddAdmin/tabledata', [('var') : 'address1']), ExcelData.getValue(i++, 1))

WebUI.setText(findTestObject('Page_AddAdmin/tabledata', [('var') : 'address2']), ExcelData.getValue(i++, 1))

WebUI.click(findTestObject('Supplier/SupplierFor'))

WebUI.click(findTestObject('Supplier/SelectApplier', [('supplier') : ExcelData.getValue(i++, 1)]))

WebUI.setText(findTestObject('Page_AddAdmin/tabledata', [('var') : 'itemname']), ExcelData.getValue(i++, 1))

WebUI.click(findTestObject('Supplier/Assignhotel'))

WebUI.click(findTestObject('Supplier/SelectAssignHotel', [('assignhotel') : ExcelData.getValue(i++, 1)]))

WebUI.click(findTestObject('Supplier/ClickAssignTours'))

WebUI.click(findTestObject('Supplier/SelectAssignTours', [('assigntours') : ExcelData.getValue(i++, 1)]))

WebUI.click(findTestObject('Supplier/ClickSelectCars'))

WebUI.click(findTestObject('Supplier/SelectSelectCars', [('assigncars') : ExcelData.getValue(i++, 1)]))

def dbdataForPermission = findTestData('Checkbox_data')

for (def index : (1..dbdataForPermission.getRowNumbers())) {
    for (def indexc : (1..dbdataForPermission.getColumnNumbers())) {
        WebUI.scrollToElement(findTestObject('Page_AddAdmin/checkbox1', [('value') : dbdataForPermission.getValue(indexc, index)]), 
            10)

        WebUI.click(findTestObject('Page_AddAdmin/checkbox1', [('value') : dbdataForPermission.getValue(indexc, index)]))
    }
}

WebUI.click(findTestObject('Supplier/SupplierSubmit'))

WebUI.closeBrowser()

