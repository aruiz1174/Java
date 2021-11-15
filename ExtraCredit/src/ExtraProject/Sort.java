package ExtraProject;
/**
 * 
 * @author Anibal Ruiz
 * Help from: Tony Ruiz, and GeeksForGeeks website.
 * 
 * Sort list of objects using Bubble, selection sort, quick sort and merge sort,
 *  and a swap method to keep things simple.
 * 
 *
 * @param <E>
 */
public class Sort
{
	
	
	//two algorithms with running time of O(n2) (bubble and selection)
	
	
	/**
	 * BubbleSort - compare the first two values and change positions if the second one is less than the first one,
	 * keep comparing until you go through all the array.
	 * @param array
	 */
	public void bubbleSort(int arr[]) 
	{
		int i, j;
		boolean swapped = true; //to narrow down iterations

		for (i = 0; i < arr.length -1 && swapped == true; i++) 
		{  
			swapped = false; 
			for (j = 0; j < arr.length-i-1; j++)  //length-i-1 to narrow to even less iterations
			{ 
				if (arr[j] > arr[j+1]) 
				{ 
					swap(arr, j, j+1); 
					swapped = true; 
				} 
			} 
		} 
	}


	
	
	/**
	 * SekectionSort - find the minimum value in the array and put it in the beginning, 
	 * then keep looking for the minimum again and put i the next spot until you reach the last value.
	 * @param array
	 */
	public void SelectionSort(int arr[])
	{
		
		int minIndex = 0;
		int j;

		for(int i = 0; i < arr.length-1; i++) {
			minIndex = i;
			for(j = i; j < arr.length; j++) {
				if(arr[minIndex] > arr[j]) { //A person object is sent
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}

		
	}

	//******************************************************************************************************
	
	//two algorithms with running time O(n log n) (merge and quick sort). 
	
	/**
	 * quickSort: It picks an element as pivot and partitions the given array around the picked pivot.
	 * Target of partitions is, given an array and an element x of array as pivot, put x at its correct
	 * position in sorted array and put all smaller elements (smaller than x) before x, and put all greater
	 * elements (greater than x) after x.
	 * @param arr
	 * @param low
	 * @param high
	 */
	public void quickSort(int arr[], int sIndex, int eIndex)
	{
		if (sIndex >= eIndex)
			return;

		int pIndex = partition(arr, sIndex, eIndex);

		quickSort(arr, sIndex, pIndex - 1);
		quickSort(arr, pIndex + 1, eIndex);


	}
	/**
	 * partition: This function takes last element as pivot, places
	 * the pivot element at its correct position in sorted
	 * array, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot .
	 * @param arr
	 * @param sIndex
	 * @param eIndex
	 * @return
	 */
	public int partition(int arr[], int sIndex, int eIndex) 
    { 
		int pivot = arr[eIndex];
		int pIndex = sIndex;

		for(int i = sIndex; i < eIndex; i++) {
			if (arr[i] <= pivot) {
				swap(arr, i, pIndex); //swap method uses arr[i], and arr[pIndex]
				pIndex++;
			}
		}
		swap(arr, pIndex, eIndex);
		return pIndex;

		
    } 

	
	
	/**
	 * Mergesort:  It divides input array in two halves, calls itself for the 
	 * two halves and then merges the two sorted halves. the array is recursively 
	 * divided in two halves till the size becomes 1. Once the size becomes 1, 
	 * the merge processes comes into action and starts merging arrays back till the complete array is merged.
	 * 
	 * @param arr
	 * @param l
	 * @param m
	 * @param r
	 */
	public void merge(int leftArray[], int rightArray[], int[] arr) 
    { 
		int leftLen = leftArray.length;
		int rightLen = rightArray.length;

		int leftIndex = 0;
		int rightIndex = 0;
		int index = 0;

		while (leftIndex < leftLen && rightIndex < rightLen)
		{
			if (leftArray[leftIndex] <= rightArray[rightIndex])
			{
				arr[index] = leftArray[leftIndex];
				leftIndex++;
			} else
			{
				arr[index] = rightArray[rightIndex];
				rightIndex++;
			}
			index++;
		}


		while (leftIndex < leftLen)
		{
			arr[index] = leftArray[leftIndex];
			leftIndex++;
			index++;
		}
		while (rightIndex < rightLen)
		{
			arr[index] = rightArray[rightIndex];
			rightIndex++;
			index++;
		}

    }
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    public void mergesort(int arr[]) 
    { 
    	int len = arr.length;
		if (len < 2) 
			return;
		// Find the middle point 
		int m = (len)/2; 

		int[] tempLeftArray = new int[m];
		int[] tempRightArray = new int[len - m];

		int index = 0;

		for (int i = 0; i <= (m - 1); i++)
		{
			tempLeftArray[index] = arr[i];
			index++;
		}

		index = 0;

		for (int i = m; i <= (len - 1); i++)
		{
			tempRightArray[index] = arr[i];
			index++;
		}

		mergesort(tempLeftArray);
		mergesort(tempRightArray);

		merge(tempLeftArray, tempRightArray, arr);

        
        
    }
	
	/**
	 * Swap the Values in the array 
	 * @param array
	 * @param i
	 * @param j
	 */
	public void swap(int[] array, int target, int j) 
	{
		int temp = array[target];
		array[target] = array[j];
		array[j] = temp;
	}

}
