package Newpackage;
import java.util.HashMap;
//
import java.util.List;

//import java.util.stream.Stream;
//
public class Practice {
//
public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
  System.out.println("Hello world") ;
//		
//		
//		//
		String str = " Jiten " ;
		String str1 = str.substring(2);
		System.out.println ("updated string :" + str1) ;
//		//strip method removes all the trailing whitespaces inside the string
//		//Returns a string whose value is this string, with all leadingand trailing white spaceremoved. 
		//String str1 = str.strip() ;
		//System.out.println ("updated string :" + str1) ;
//		
//		//stripLeading()method is used to remove the white space from the beginning of a string.
//        //stripTrailing()method is used to remove the white space from the end of a string.
//		
//		//isBlank()
//		//This method returns true if the string is empty or contains only white spaces; otherwise, it returns false
//       
	//	String value = "" ;
		//boolean value1 = value.isBlank() ;
		//System.out.println ("updated value :" + value1) ;
//		
////		lines()
////		This method is used to return the stream of strings that are partitioned by line terminators. 
////	The lines in the stream are in the order in which they occur in the string. 
////	This method is more performant compared to the methods we are using currently.
//		
//		String str2 = "hello how are u \n Im good\n" ;
//		List<Object> str3 = str2.lines().collect(Collectors.toList()) ;
//		for ( Object elements : str3) {
//		System.out.println ("separated string :" + elements);
//		}
////		separated string :hello how are u 
////		separated string : Im good	
//		
////		repeat(n)
////		This method will return the concatenated string, and the number of times it will concatenate 
////		is dependant upon 
////		the count that we supply as an argument to this method.
//		
		String str4 = "Jiten";
	//	String str5 = str4.repeat(3);
	//	System.out.println ("repeated string :" + str5);
//		//repeated string :JitenJitenJiten
//		
////		writeString
////		This method is used to write the contents to a file. Characters are encoded 
////		into bytes using the specified charset, and the default value is a UTF-8 charset.
//
////		readString
////		This method will read all contents from a file into a string, decoding from bytes to characters 
////		using the UTF-8 charset. The method also ensures that the file is closed when all content has 
////		been read or an I/O error, or other runtime exception, is thrown.
//		
//		
//		
//	
		HashMap<Integer,String> hm = new HashMap <Integer,String> ();
		
		hm.put(2, "Kumar") ;
		hm.put(4, "Jitendra");
		
		for (String values : hm.values()) {
			System.out.println ("each value present " + values) ;
		}
		
		for (Integer element : hm.keySet()) {
			System.out.println("each key present :" + element) ;
		}
		
		//add elements inside hash map 
		
		
		
}
//	
//
}
