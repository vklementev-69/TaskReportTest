set projectLocation=E:\Projects\Autotest\Maven\TaskReportTest
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*;%projectLocation%\src\test\java;
java org.testng.TestNG %projectLocation%\testng.xml
pause