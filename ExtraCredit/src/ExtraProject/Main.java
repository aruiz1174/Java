package ExtraProject;

import java.util.Arrays;
/**
 * 
 * @author Anibal Ruiz, N00866307
 * I worked with: Tony Ruiz
 * 
 * performs a statistical analysis on the running times of the O(n2) sorting and of the O (n log n) sorting algorithms. 
 * Run each algorithm 15 times on arrays of sizes 20,000, 40,000, 60,000, 80,000, 160,000, 320,000, and 640,000 random 
 * positive integers in the range of 0 to less than 2,000,000.
 * Running time should be displayed in ms.
 * 
 * I don't get stack overflow.
 *
 */

public class Main 
{

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{

		//instantiate an initialized sort vars and other needed vars.
		Sort sort = new Sort();
		int runTimes = 15;
		double start;
		double stop;

		int arraySizes[] = {20000, 40000, 60000, 80000, 160000, 320000, 640000};

		//arrays and doubles to calculate average at the end
		double qSort[] = new double[runTimes];
		double mSort[] = new double[runTimes];
		double bSort[] = new double[runTimes];
		double sSort[] = new double[runTimes];

		// create vars for the avg time for each algorithm
		double quickAvg, mergeAvg, bubbleAvg, selectionAvg;
		quickAvg = mergeAvg = bubbleAvg = selectionAvg = 0.0;

		//doubles for worst
		double qWorst, mWorst, bWorst, sWorst;
		qWorst = mWorst = bWorst = sWorst = 0.0;

		//For-loop to iterate for each array size.
		for (int i = 0; i < arraySizes.length; i++)
		{
			int tempOriginal[] = new int[arraySizes[i]];
			int tempToSort[] = Arrays.copyOf(tempOriginal, tempOriginal.length);

			//forloop to iterate 15 times each algorithm for a specific size
			for (int j = 0; j < runTimes; j++)
			{
				//forloop to fill array with positive random numbers from 0 to 2000000
				for (int k = 0; k < tempOriginal.length; k++)
					tempOriginal[k] = (int) ((Math.random() * 2000000) + 1 );


				//Quick Sort
				tempToSort = Arrays.copyOf(tempOriginal, tempOriginal.length);
				start = System.currentTimeMillis();
				sort.quickSort(tempToSort, 0, tempToSort.length - 1);
				stop = System.currentTimeMillis();
				qSort[j] = stop - start;

				//Merge Sort
				tempToSort = Arrays.copyOf(tempOriginal, tempOriginal.length);
				start = System.currentTimeMillis();
				sort.mergesort(tempToSort);
				stop = System.currentTimeMillis();
				mSort[j] = stop - start;

				//Selection Sort
				tempToSort = Arrays.copyOf(tempOriginal, tempOriginal.length);
				start = System.currentTimeMillis();
				sort.SelectionSort(tempToSort);
				stop = System.currentTimeMillis();
				sSort[j] = stop - start;

				//Bubble Sort
				tempToSort = Arrays.copyOf(tempOriginal, tempOriginal.length);
				start = System.currentTimeMillis();
				sort.bubbleSort(tempToSort);
				stop = System.currentTimeMillis();
				bSort[j] = stop - start;
			}
			//calculate worst
			for (int worstTime = 0; worstTime < runTimes; worstTime++) 
			{
				if(sWorst < sSort[worstTime])
					sWorst = sSort[worstTime];

				if(mWorst < mSort[worstTime])
					mWorst = mSort[worstTime];

				if(bWorst < bSort[worstTime])
					bWorst = bSort[worstTime];

				if(qWorst < qSort[worstTime])
					qWorst = qSort[worstTime];
			}

			//calculate averages
			for (int avg = 0; avg < runTimes; avg++)
			{
				quickAvg += qSort[avg];
				bubbleAvg += bSort[avg];
				selectionAvg += sSort[avg];
				mergeAvg += mSort[avg];
			}

			//averages
			quickAvg = quickAvg / 15;
			bubbleAvg = bubbleAvg / 15;
			mergeAvg = mergeAvg / 15;
			selectionAvg = selectionAvg / 15;

			//Big O
			double bubbleO = Math.pow(tempOriginal.length, 2) / bubbleAvg;
			double selectionO = Math.pow(tempOriginal.length, 2) / selectionAvg;
			double mergeO = tempOriginal.length * (Math.log(tempOriginal.length)/ Math.log(2)) / mergeAvg;
			double quickO = tempOriginal.length * (Math.log(tempOriginal.length)/ Math.log(2)) / quickAvg;

			//output
			System.out.println("Merge " + tempOriginal.length + " Average Time: " + mergeAvg);
			System.out.println("Quick " + tempOriginal.length + " Average Time: " + quickAvg);
			System.out.println("Selection " + tempOriginal.length + " Average Time: " + selectionAvg);
			System.out.println("Bubble " + tempOriginal.length + " Average Time: " + bubbleAvg + "\n***************************************************");
			System.out.println("Merge " + tempOriginal.length + " Worst Time: " + mWorst);
			System.out.println("Quick " + tempOriginal.length + " Worst Time: " + qWorst);
			System.out.println("Bubble " + tempOriginal.length + " Worst Time: " + bWorst);
			System.out.println("Selection " + tempOriginal.length + " Worst Time: " + sWorst + "\n***************************************************");
			System.out.println("Merge " + tempOriginal.length + " Big O: " + mergeO);
			System.out.println("Quick " + tempOriginal.length + " Big O: " + quickO);
			System.out.println("Selection " + tempOriginal.length + " Big O: " + selectionO);
			System.out.println("Bubble " + tempOriginal.length + " Big O: " + bubbleO + "\n***************************************************");

		}

	}

}
