set projectLocation=E:\Projects\Autotest\Maven\Pochtabank2
cd %projectLocation%
set classpath=%projectLocation%\lib\*;%projectLocation%\target\test-classes;
java org.testng.TestNG %projectLocation%\testng.xml
pause