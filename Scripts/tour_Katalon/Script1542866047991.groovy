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

WebUI.callTestCase(findTestCase('CreateAdmin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.phptravels.net/admin')

WebUI.setText(findTestObject('Page_Administator Login (1)/input_email'), 'chelsea@gmail.com')

WebUI.setText(findTestObject('Page_Administator Login (1)/input_password'), 'inapp123')

WebUI.click(findTestObject('Page_Administator Login (1)/button_Login'))

WebUI.click(findTestObject('Page_Dashboard (1)/a_Tours'))

WebUI.click(findTestObject('Page_Dashboard (1)/a_Tours_1'))

WebUI.delay(5)

WebUI.click(findTestObject('Page_Tours Management/i_glyphicon glyphicon-plus-sig'))

def internalData = findTestData('tour_create')

int i = 1

WebUI.setText(findTestObject('Page_AddAdmin/fieldData', [('dynamicvariable') : 'tourname']), internalData.getValue(i++, 
        1))

WebUI.setText(findTestObject('Page_AddAdmin/fielddata', [('dynamicvariable') : 'maxadult']), internalData.getValue(i++, 
        1))

WebUI.setText(findTestObject('Page_AddAdmin/fielddata', [('dynamicvariable') : 'adultprice']), internalData.getValue(i++, 
        1))

WebUI.click(findTestObject('Page_AddAdmin/Childbutton'))

WebUI.setText(findTestObject('Page_AddAdmin/fielddata', [('dynamicvariable') : 'maxchild']), internalData.getValue(i++, 
        1))

WebUI.setText(findTestObject('Page_AddAdmin/fielddata', [('dynamicvariable') : 'childprice']), internalData.getValue(i++, 
        1))

WebUI.click(findTestObject('Page_AddAdmin/InfantButton'))

WebUI.setText(findTestObject('Page_AddAdmin/fielddata', [('dynamicvariable') : 'maxinfant']), internalData.getValue(i++, 
        1))

WebUI.setText(findTestObject('Page_AddAdmin/fielddata', [('dynamicvariable') : 'infantprice']), internalData.getValue(i++, 
        1))

WebUI.click(findTestObject('Page_AddAdmin/Page_Add Tour/select_Select'))

//WebUI.click(findTestObject('AddTour/StarDropdown'))
WebUI.click(findTestObject('Page_AddAdmin/StarSelection', [('var1') : internalData.getValue(i++, 1)]))

WebUI.setText(findTestObject('Page_AddAdmin/fielddata', [('dynamicvariable') : 'tourdays']), internalData.getValue(i++, 
        1))

WebUI.setText(findTestObject('Page_AddAdmin/fielddata', [('dynamicvariable') : 'tournights']), internalData.getValue(i++, 
        1))

WebUI.click(findTestObject('Page_AddAdmin/TourTypeDrop'))

WebUI.click(findTestObject('Page_AddAdmin/TourTypeSelection', [('type') : internalData.getValue(i++, 1)]))

WebUI.click(findTestObject('Page_AddAdmin/LocationDropdown'))

WebUI.setText(findTestObject('Page_AddAdmin/SearchLocation'), 'paris')

WebUI.click(findTestObject('Page_AddAdmin/LocationSelection'))

WebUI.click(findTestObject('Page_AddAdmin/a_Inclusions'))

WebUI.click(findTestObject('Page_AddAdmin/SelectAll'))

WebUI.delay(5)

WebUI.click(findTestObject('Page_AddAdmin/SelectAll'))

def tourfacilitiesinclude = findTestData('Database/inclusions')

for (def index : (1..tourfacilitiesinclude.getRowNumbers())) {
    WebUI.click(findTestObject('Page_AddAdmin/Includevar', [('var2') : tourfacilitiesinclude.getValue(1, index)]))
}

WebUI.click(findTestObject('Page_AddAdmin/a_Exclusions'))

def tourfacilitiesexclude = findTestData('Database/exclusions')

for (def indexe : (1..tourfacilitiesexclude.getRowNumbers())) {
    WebUI.click(findTestObject('Page_AddAdmin/excludevar', [('var3') : tourfacilitiesexclude.getValue(1, indexe)]))
}

WebUI.click(findTestObject('Page_AddAdmin/ButtonSubmit'))

WebUI.closeBrowser()

