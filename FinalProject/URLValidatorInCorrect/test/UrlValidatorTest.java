

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {   
	   System.out.print("testManualTest()");
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   boolean test1 = urlVal.isValid("test://www.google.com");
	   boolean test2 = urlVal.isValid("http://www.google.com:32");
	   boolean test5 = urlVal.isValid("http:/www.google.com:32/test?arg=a");
	   boolean test7 = urlVal.isValid("http://255.255.255.255:32/test?arg=view");
	   boolean test8 = urlVal.isValid("://www.google.com:32/test?arg=view");
	   boolean test9 = urlVal.isValid(" www.google.com:32/test?arg=view");
	   boolean test10 = urlVal.isValid("test://www.google.com/test?action=view");
	   boolean test11 = urlVal.isValid("www.google.com");
	   boolean test12 = urlVal.isValid("http:www.google.com:32/test?arg=a");
	   boolean test13 = urlVal.isValid(" ");
	   
	   System.out.printf("\n");
	   System.out.print(test1);
	   System.out.printf("\n");
	   System.out.print(test2);
	   System.out.printf("\n");
	   System.out.print(test5);
	   System.out.printf("\n");
	   System.out.print(test7);
	   System.out.printf("\n");
	   System.out.print(test8);
	   System.out.printf("\n");
	   System.out.print(test9);
	   System.out.printf("\n");
	   System.out.print(test10);
	   System.out.printf("\n");
	   System.out.print(test11);
	   System.out.printf("\n");
	   System.out.print(test12);
	   System.out.printf("\n");
	   System.out.print(test13);
	   System.out.printf("\n");

   }
   
   public void testYourFirstPartition()
   {
	 UrlValidator url = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	 String[] correctURLS = {"http://www.google.com","http://www.google.com/stuff", "ftp://www.google.com",  "ftp://www.google.net",  "http://www.google.net"};
	 for(int i=0; i < correctURLS.length;i++){
		 assert(url.isValid(correctURLS[i]) == true);
	 }	

   }
   
   public void testYourSecondPartition(){
		 UrlValidator url = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		 String[] incorrectURLS = {"test://www.google.com:80","www.google.com/", " "};
		 for(int i=0; i < incorrectURLS.length;i++){
			 assert(url.isValid(incorrectURLS[i]) == false);
		 }	
   }

   
   public void testIsValidPrograming()
   {
	   UrlValidator url = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   String[] prefix = {"http", "http://", "test","test://"," "};
	   String[] mainURL = {"www.google.com", "www.google.com:32", "www.google.com/test", " "};
	   
	   
	   for(int i=0;i < prefix.length; i++){
		   for(int j= 0; j< mainURL.length; j++){

			   boolean assertion = url.isValid(prefix[i] + mainURL[j]);
			   if(assertion == true){
				   System.out.printf(prefix[i] + mainURL[j] + "\n");
			   }
		   } 
	   }
	   
   }
   


}
