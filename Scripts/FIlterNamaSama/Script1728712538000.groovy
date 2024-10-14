import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys



def firstName = '5data'  
def lastName = 'sama'   


def responseByName = WS.sendRequest(findTestObject('Object Repository/GetBookingByName', [('firstname') : firstName, ('lastname') : lastName]))

// Verifikasi jika respons valid (status code 200)
WS.verifyResponseStatusCode(responseByName, 200)


def jsonResponseByName = WS.getResponseBody(responseByName)
println('Response JSON: ' + jsonResponseByName)


WS.verifyMatch(WS.getElementPropertyValue(responseByName, '[0].firstname'), firstName, false)
WS.verifyMatch(WS.getElementPropertyValue(responseByName, '[0].lastname'), lastName, false)
