class ArrayPuzzle
{
	static void MissingElements(int[] arr,int n)
	{
		int arr_sum = 0;
		
		for(int i=0;i<arr.length;i++)
		{
			arr_sum += arr[i];
		}
		
		int n_sum = n*(n+1)/2;
		
		System.out.println("Missing Element is : "+(n_sum-arr_sum)+"\n");
	}
	
	static void Min_Max(int[] arr)
	{
		int min = arr[0];
		int max = arr[0];
		
		for(int i=0;i<arr.length;i++)
		{
			if(min>arr[i])
			{
				min=arr[i];
			}
			if(max<arr[i])
			{
				max=arr[i];
			}
		}
		
		System.out.println("Minimum Element = "+min+"\n");
		System.out.println("Maximum Element = "+max+"\n");
	}
		
	static void Sort(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int k = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=k;
				}
			}
		}
		
		System.out.print("Sorted Array = ");
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println("\n");
	}
	
	static void Search(int[] arr,int find)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==find)
			{
				System.out.println(find+" Element Found!!"+"\n");
				return;
			}
		}
		System.out.println(find+" Element not Found");
	}
	
	static void SumPairs(int[] arr,int f_add)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0+i;j<arr.length;j++)
			{
				if(arr[i]!=arr[j])
				{
					if(f_add==arr[i]+arr[j])
					{
						System.out.println("Sum Pair of "+f_add+" is : ("+arr[i]+","+arr[j]+")");
					}
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		int[] arr={4,1,6,3,5};
		int n=6;
		int find=3;
		int f_add=6;
		
		System.out.println("Elements are fron 1 to 6");
		System.out.print("Array = ");
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("Element to be found = "+find);
		System.out.println("Sum Pair Element = "+f_add+"\n");
		
		MissingElements(arr,n);
		Min_Max(arr);
		Sort(arr);
		Search(arr,find);
		SumPairs(arr,f_add);
	}
		
}
