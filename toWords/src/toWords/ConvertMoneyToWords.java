package toWords;

	import java.util.Scanner;
	
	public class ConvertMoneyToWords {
	 public static void main(String args[]) {
	  String word2 = "";
	  NumToWords NTW = new NumToWords();
	  Scanner input = new Scanner(System.in);
	  System.out.println("Enter Amount in ksh: ");
	  String amt = input.next();
	  int shillings = Integer.parseInt(amt.split("\\.")[0]);
	  String word1 = NTW.convert(shillings);
	  word1 += " shillings ";
	  int cents = Integer.parseInt(amt.split("\\.")[1]);
	  if (cents != 0) {
	   word2 += " and";
	   word2 = NTW.convert(cents);
	   word2 += " cents ";
	   input.close();
	  }
	  System.out.println(word1 + word2 + "Only");
	 }
	}


	class NumToWords {
	 String string;
	 String st1[] = { "", "One", "Two", "Three", "Four", "Five", "Six",
	   "Seven", "Eight", "Nine", };
	 String st2[] = { "Hundred", "Thousand", "hundred thousand", "million" };
	 String st3[] = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
	   "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Ninteen", };
	 String st4[] = { "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy",
	   "Eighty", "Ninety" };


	 public String convert(int number) {
	  int n = 1;
	  
	  int word;
	  
	  string = "";
	  
	  while (number != 0) {
	   switch (n) {
	   case 1:
		   
	    word = number % 100;
	    
	    pass(word);
	    
	    if (number > 100 && number % 100 != 0) {
	    	
	     show("and ");
	    }
	    
	    number /= 100;
	    break;
	    
	   case 2:
	    word = number % 10;
	    
	    if (word != 0) {
	     show(" ");
	     show(st2[0]);
	     show(" ");
	     pass(word);
	    }
	    
	    number /= 10;
   	    break;
	    
	   case 3:
	    word = number % 100;
	    
	    if (word != 0) {
	     show(" ");
	     show(st2[1]);
	     show(" ");
	     pass(word);
	    }
	    number /= 100;
	    break;
	    
	   case 4:
	    word = number % 100;
	    if (word != 0) {
	     show(" ");
	     show(st2[2]);
	     show(" ");
	     pass(word);
	    }
	    number /= 100;
	    break;
	    
	   case 5:
	    word = number % 1000;
	    if (word != 0) {
	     show(" ");
	     show(st2[3]);
	     show(" ");
	     pass(word);
	    }
	  number /= 100;
	    break;
	  
	   }
	   n++;
	  }
	  return string;
	 }


	 public void pass(int number) {
		 
	  int word, q;
	  if (number < 10) {
	   show(st1[number]);
	   
	  }
	  
	  if (number > 9 && number < 20) {
		  
	   show(st3[number - 10]);
	  }
	  if (number > 19) {
	   word = number % 10;
	   if (word == 0) {
	    q = number / 10;
	    show(st4[q - 2]);
	   } else {
	    q = number / 10;
	    show(st1[word]);
	    show("-");
	    show(st4[q - 2]);
	   }
	  }
	 }


	 public void show(String s) {
		 
	  String st;
	  st = string;
	  string = s;
	  string += st;
	 }
	}


