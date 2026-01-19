class ArrayPuzzle
{
	static void MissingElements(int[] arr,int n)  //To find missing elements in arr
	{
		int arr_sum = 0;
		
		for(int i=0;i<arr.length;i++)
		{
			arr_sum += arr[i];
		}
		
		int n_sum = n*(n+1)/2;
		
		System.out.println("Missing Element is : "+(n_sum-arr_sum)+"\n");
	}
	
	static void Min_Max(int[] arr)  //To find the minimum and maximum
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
		
	static void Sort(int[] arr)  //Bubble sort
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
	
	static void Search(int[] arr,int find)  //Search an element in arr
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==find)
			{
				System.out.println(find+" Element Found!!"+"\n");
				return;
			}
		}
		System.out.println(find+" Element not Found\n");
	}
	
	static void SumPairs(int[] arr,int f_add)  //To fins sum pairs of given elemrent
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
		System.out.println();
	}
	
	static void MergeNSort(int[] brr, int[] crr)  // //To merge n sort brr & crr simultaneously
	{
		int[] merge = new int[brr.length + crr.length];
		boolean[] usedB = new boolean[brr.length];
		boolean[] usedC = new boolean[crr.length];

		for (int i = 0; i < merge.length; i++)
		{
			int min = 9999;
			int index = -1;
			char from = ' ';

			// find smallest unused element in brr
			for (int j = 0; j < brr.length; j++)
			{
				if (!usedB[j] && brr[j] < min)
				{
					min = brr[j];
					index = j;
					from = 'B';
				}
			}

			// find smallest unused element in crr
			for (int j = 0; j < crr.length; j++)
			{
				if (!usedC[j] && crr[j] < min)
				{
					min = crr[j];
					index = j;
					from = 'C';
				}
			}

			// insert smallest into merged array
			merge[i] = min;

			// mark element as used
			if (from == 'B')
				usedB[index] = true;
			else
				usedC[index] = true;
		}

    System.out.print("Merged N Sorted Array = ");
    for (int i = 0; i < merge.length; i++)
    {
        System.out.print(merge[i] + " ");
    }
    System.out.println();
}

	
	public static void main(String[] args)  //Main function
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
		
		int[] brr={5,8,3,7};
		int[] crr={6,9,2,0,4,1};
		
		System.out.print("brr = ");
		for(int i=0;i<brr.length;i++)
		{
			System.out.print(brr[i]+" ");
		}
		System.out.println();
		System.out.print("crr = ");
		for(int i=0;i<crr.length;i++)
		{
			System.out.print(crr[i]+" ");
		}
		System.out.println("\n");
		
		MergeNSort(brr,crr);
	}
		
}
