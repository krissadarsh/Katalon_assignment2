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
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://phptravels.net/admin')

WebUI.setText(findTestObject('Page_Administator Login/input_email'), 'admin@phptravels.comdemoa')

WebUI.setText(findTestObject('Page_Administator Login/input_email'), 'admin@phptravels.com')

WebUI.setText(findTestObject('Page_Administator Login/input_password'), 'demoadmin')

WebUI.click(findTestObject('Page_Administator Login/span_Login'))

WebUI.click(findTestObject('Page_Dashboard/a_Accounts'))

WebUI.click(findTestObject('Page_Dashboard/a_Admins'))

WebUI.click(findTestObject('Page_Admins Management/i_glyphicon glyphicon-plus-sig'))

def dbdata = findTestData('Database/Katalon_1')

int i = 1

WebUI.delay(5)

WebUI.setText(findTestObject('Page_AddAdmin/tabledata', [('var') : 'fname']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Page_AddAdmin/tabledata', [('var') : 'lname']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Page_AddAdmin/tabledata', [('var') : 'email']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Page_AddAdmin/tabledata', [('var') : 'password']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Page_AddAdmin/tabledata', [('var') : 'mobile']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Page_AddAdmin/tabledata', [('var') : 'address1']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Page_AddAdmin/tabledata', [('var') : 'address2']), dbdata.getValue(i++, 1))

WebUI.click(findTestObject('Page_AddAdmin/SelectDD'))

WebUI.delay(5)

WebUI.click(findTestObject('Page_AddAdmin/Country', [('Country1') : dbdata.getValue(i++, 1)]))

def dbdataForPermission = findTestData('Checkbox_data')

for (def index : (1..dbdataForPermission.getRowNumbers())) {
    for (def indexc : (1..dbdataForPermission.getColumnNumbers())) {
        WebUI.scrollToElement(findTestObject('Page_AddAdmin/checkbox1', [('value') : dbdataForPermission.getValue(indexc, 
                        index)]), 10)

        WebUI.click(findTestObject('Page_AddAdmin/checkbox1', [('value') : dbdataForPermission.getValue(indexc, index)]))
    }
}

//WebUI.click(findTestObject('Page_AddAdmin/li_Tours'))
//WebUI.click(findTestObject('Page_AddAdmin/li_Tours'))
WebUI.click(findTestObject('Page_AddAdmin/button_Submit'))

WebUI.delay(5)

//WebUI.verifyElementPresent(findTestObject(null), 0)
not_run: WebUI.closeBrowser()

WebUI.click(findTestObject('Page_AddAdmin/a_Log Out'))

