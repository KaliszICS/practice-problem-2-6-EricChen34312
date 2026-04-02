import java.util.Arrays;

public class PracticeProblem {

	public static void main(String args[]) {
			leastSwaps(new double[]{9, 7, 4, 2, 1, 0});
	}


	public static void q1() {
		//Write question 1 code here
	}

	public static void q2() {
		//Write question 2 code here
	}

	public static void q3() {
		//Write question 3 code here
	}

	public static void q4() {
		//Write question 4 code here
	}

	public static void q5() {
		//Write question 5 code here
	}

	public static int[] bubbleSort(double[] nums){
		int[] out = new int[2];

		for(int i = 0; i < nums.length-1; i++){
			boolean swapped = false;

			for(int j = 0; j < nums.length-i-1;j++){
				
				if(nums[j] > nums[j+1]){
					double temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;

					swapped = true;
					out[0]+= 3;
				}

				out[1]++;
			}

			if(!swapped){
				i = nums.length;
			}
		}

		return out;
	}

	public static int[] selectionSort(double[] nums){
		int[] out = new int[2];

		for(int i = 0; i < nums.length-1; i++){
			int low = i;
			for(int j = i+1; j < nums.length; j++){

				out[1]++;
				if(nums[low] > nums[j]){
					low = j;
					out[0]++;
				}
			}

			double temp = nums[i];
			nums[i] = nums[low];
			nums[low] = temp;
			out[0] += 3;
		}

		return out;
	}

	public static int[] insertionSort(double[] nums){
		int[] out = new int[2];

		for(int i = 1; i < nums.length; i++){
			double num = nums[i];
			int index = i-1;
			out[0] ++;

			out[1]++;
			while(index >= 0 && num < nums[index]){
				nums[index+1] = nums[index];
				out[0]++;
				index--;

				if(index >= 0 && num < nums[index]){
					out[1]++;
				}
			}

			nums[index+1] = num;
			out[0]++;
		}

		return out;
	}

	public static String leastSwaps(double[] nums){
		int bubble = bubbleSort(nums.clone())[0];
		int selection = selectionSort(nums.clone())[0];
		int insertion = insertionSort(nums.clone())[0];

		if(bubble < selection && bubble < insertion){
			return "Bubble";
		} else if (selection <= insertion && selection <= insertion){
			return "Selection";
		} else {
			return "Insertion";
		}

	}

	public static String leastIterations(double[] nums){
		int bubble = bubbleSort(nums.clone())[1];
		int selection = selectionSort(nums.clone())[1];
		int insertion = insertionSort(nums.clone())[1];

		if(bubble < selection && bubble == insertion) {
			//this sucks, this is for those cases where insertion and bubble have the same amount of comparisons for small/sorted arrays
			return "Insertion";
		} else if(bubble < selection && bubble < insertion){
			return "Bubble";
		} else if (insertion < selection && insertion < bubble){
			return "Insertion";
		} else {
			return "Bubble";
		}
	}
}
