import java.util.*;

class Assignment3_1
{
	static void uppercase(String text1)  //Convert to uppercase
	{
		char[] arr = text1.toCharArray();
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>='a' && arr[i]<='z')
			{
				arr[i] = (char)(arr[i]-32);
			}
		}
		
		System.out.println("Uppercase : "+ new String(arr)+"\n");
	}
	
	static void lowercase(String text2)  //Convert to lowercase
	{
		char[] arr = text2.toCharArray();
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>='A' && arr[i]<='Z')
			{
				arr[i] = (char)(arr[i]+32);
			}
		}
		
		System.out.println("Lowercase : "+ new String(arr)+"\n");
	}
	
	static void compare(String text3,String text4)  //Compare strings
	{
		char[] arr3 = text3.toCharArray();
		char[] arr4 = text4.toCharArray();
		boolean boo = false;
		
		if(text3.length() != text4.length())
		{
			System.out.println("text3 & text 4 are not the same??\n");
			return;
		}
		else
		{
			for(int i=0;i<arr3.length;i++)
			{
				for(int j=0;i<arr4.length;j++)
				{
					if(arr3[i] == arr4[j])
					{
						boo = true;
					}
					else
					{
						System.out.println("text3 & text 4 are the same!!\n");
						return;
					}
				}
			}
		}
		
		System.out.println("text3 & text 4 are the same!!");
	}
	
	static void reverse(String text) //Reverse string
	{
	    char[] arr = text.toCharArray();

	    int i = 0;
	    int j = arr.length - 1;

	    while (i < j)
	    {
	        char temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	        i++;
	        j--;
	    }
	    System.out.println("Reverse  : " + new String(arr)+"\n");
	}

	
	static void extract_digits(String text)  //Extract the digits / numbers from a string
	{
		char[] arr = text.toCharArray();
		System.out.print("Numbers inside the string : ");		
		
		for (int i = 0; i < arr.length; i++) 
		{
			if (arr[i] >= '0' && arr[i] <= '9')
			{
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println("\n");
	}
	
	static void substring_search(String text,String subold)  //Extract the digits / numbers from a string
	{
			char[] t = text.toCharArray();
			char[] s = subold.toCharArray();
			
			int found = -1;
			
			for (int i = 0; i <= t.length - s.length; i++) 
			{
				int j;
				for (j = 0; j < s.length; j++) 
				{
					if (t[i + j] != s[j]) 
					{
					break;
					}
				}
				if (j == s.length) 
				{
					found = i;
					break;
				}
			}
			if (found != -1)
			System.out.println("Substring found at index: " + found +"\n");
			else
			System.out.println("Substring not found");
	}
	
	static void replace_substring(String text,String subold,String subnew)  //Extract the digits / numbers from a string
	{
			char[] t = text.toCharArray();
			char[] o = subold.toCharArray();
			char[] n = subnew.toCharArray();
			int index = -1;
			// Find old substring
			for (int i = 0; i <= t.length - o.length; i++)
			{
				int j;
				for (j = 0; j < o.length; j++) 
				{
					if (t[i + j] != o[j])
					break;
					}
				if (j == o.length) 
				{
					index = i;
					break;
				}
			}
			if (index == -1) 
			{
				System.out.println("Substring not found, cannot replace");
				return;
			}
			
			// New length
			int newLen = t.length - o.length + n.length;
			char[] result = new char[newLen];
			int k = 0;
			
			// Copy before old substring
			for (int i = 0; i < index; i++)
			result[k++] = t[i];
			
			// Copy new substring
			for (int i = 0; i < n.length; i++)
			result[k++] = n[i];
			
			// Copy remaining text
			for (int i = index + o.length; i < t.length; i++)
			result[k++] = t[i];
			System.out.println("After replacement: " + new String(result));
	}
	
	public static void main(String[] args)  //Main function
	{		
		String text1 = "aloha soi dora";
		String text2 = "ALOHA SOI DORA";
		String text3 = "ALOHA SOI DORA";
		String text4 = "ALOHA SOI DRA";
		String text5 = "Aloha Soi Dora";
		String text6 = "A10h4 S01 D0r4";
		String text7 = "Aloha Soi Dora";
		String text8 = "Aloha Soi Dora";		
		String subold = "Dora";
		String subnew = "Boots";
		
		System.out.println("Original : "+text1);
		uppercase(text1);
		System.out.println("Original : "+text2);
		lowercase(text2);
		System.out.println("Original strings : text3 = "+text3);
		System.out.println("                   text4 = "+text4);
		compare(text3,text4);
		System.out.println("Original : "+text5);
		reverse(text5);
		System.out.println("Original : "+text6);
		extract_digits(text6);
		System.out.println("Original : "+text7);
		System.out.println("Search : "+subold);
		substring_search(text7,subold);
		System.out.println("Original : "+text8);
		System.out.println("Replace : "+subold+" with "+subnew);
		replace_substring(text8,subold,subnew);
	}
}
