/**
 * @author harishan
 */
package roman_numerals;

import java.util.Arrays;
import java.util.List;

public class Roman {
	
	/**
	 * This convertToString method converts a given number to a Roman Numeral
	 * @param num short input representing the number to be converted
	 * @return the Roman numeral conversion of num
	 */
	public static String convertToString (short num) {
		//variable "letters" represents the Roman Numeral
		String letters = "";
		//num cannot be less than 0 or greater than 3999 (Invalid with Roman Numerals)
		if (num>0 && num<=3999) {
			/*while loop which breaks down the number based on whether it can fit within a particular 
			value. Also takes subtraction values into consideration
			*/
			while (num>0) {
				if (num>=1000) {
					letters+="M";
					num-=1000;
				} else if (num>=900) {
					letters+="CM";
					num-=900;
				} else if (num>=500) {
					letters+="D";
					num-=500;
				} else if (num>=400) {
					letters+="CD";
					num-=400;
				} else if (num>=100) {
					letters+="C";
					num-=100;
				} else if (num>=90) {
					letters+="XC";
					num-=90;
				} else if (num>=50) {
					letters+="L";
					num-=50;
				} else if (num>=40) {
					letters+="XL";
					num-=40;
				} else if (num>=10) {
					letters+="X";
					num-=10;
				} else if (num>=9) {
					letters+="IX";
					num-=9;
				} else if (num>=5) {
					letters+="V";
					num-=5;
				} else if (num>=4) {
					letters+="IV";
					num-=4;
				} else if (num>=1) {
					letters+="I";
					num-=1;
				}
			}
		}else {
			return ("Invalid Input");
		}
		return (letters);
	}
	
	/**
	 * This convertToInt method converts a given Roman Numeral into a number 
	 * @param str string input representing the Roman Numeral
	 * @return the numerical value of the Roman Numeral
	 */
	public static short convertToInt (String str) {
		//lists of Roman Numerals and its corresponding values
		List<Integer> roman_numbers = Arrays.asList (1000,500,100,50,10,5,1);
		List<Character> roman_letters = Arrays.asList ('M','D','C','L','X','V','I');
		//variable "total" represents the Roman Numeral's numerical value
		int total = 0;
		
		for (int i = 0; i<str.length(); i++) {
			//converts the Roman Character into its corresponding value
			char letter = str.charAt(i);
			int letter_location = roman_letters.indexOf(letter);
			int value1 = roman_numbers.get(letter_location);
			//second Roman Character will only be made if it does not exceed the length of str
			if (i+1<str.length()) {
				//converts the next Roman Character into its corresponding value
				char letter2 = str.charAt(i+1);
				int letter_location2 = roman_letters.indexOf(letter2);
				int value2 = roman_numbers.get(letter_location2);
				//checks if the first Roman Character is greater than the second
				if (value1 >= value2) {
					total+=value1;
				/*checks if the second Roman Character is greater than the first. If true, subtraction
				 * rule applies where first value is subtracted from the second value
				 */
				} else if (value2>value1) {
					total = total + (value2-value1);
					i++;
				}
			/*if second Roman Character does exceed the length of str, the first Roman Character is 
			simply added to the total*/
			} else {
				total += value1;
			}
		}
		//converts the number created back into Roman Numeral 
		String check = convertToString((short)total);
		//checks to see if the Roman Numeral, of the converted number, equals the original Roman Numeral
		if (check.equals(str)) {
			return((short)total);
		//Invalid Input will output 0
		} else {
			return (0);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(convertToInt("IIII"));
		System.out.println(convertToString((short) (3999)));
	}

}
