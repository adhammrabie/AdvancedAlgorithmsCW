package minHeap;


import java.util.ArrayList;

public class MinHeap {
	void minheapalgorithm(ArrayList<Integer> hT, int i) {
		int size = hT.size();
		int smallest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (l < size && hT.get(l) < hT.get(smallest))
			smallest = l;
		if (r < size && hT.get(r) < hT.get(smallest))
			smallest = r;

		if (smallest != i) {
			int temp = hT.get(smallest);
			hT.set(smallest, hT.get(i));
			hT.set(i, temp);
			minheapalgorithm(hT, smallest);
 }
}

void insert(ArrayList<Integer> hT, int newNum) {
	int size = hT.size();
	if (size == 0) {
		hT.add(newNum);
	} else {
		hT.add(newNum);
		for (int i = size / 2 - 1; i >= 0; i--) {
			minheapalgorithm(hT, i);
   }
 }
}

void deleteNode(ArrayList<Integer> hT, int num)
{
	int size = hT.size();
	int i;
	for (i = 0; i < size; i++)
	{
		if (num == hT.get(i))
			break;
	}

	int temp = hT.get(i);
	hT.set(i, hT.get(size-1));
	hT.set(size-1, temp);

	hT.remove(size-1);
	for (int j = size / 2 - 1; j >= 0; j--)
	{
		minheapalgorithm(hT, j);
	}
}

void printArray(ArrayList<Integer> array, int size) {
	for (Integer i : array) {
		System.out.print(i + " ");
	}
	System.out.println();
}

public static void main(String args[]) {

 ArrayList<Integer> array = new ArrayList<Integer>();
 int size = array.size();

 MinHeap h = new MinHeap();
 h.insert(array, 3);
 h.insert(array, 4);
 h.insert(array, 9);
 h.insert(array, 5);
 h.insert(array, 2);

 System.out.println("Min-Heap array: ");
 h.printArray(array, size);

 h.deleteNode(array, 4);
 System.out.println("After deleting an element: ");
 h.printArray(array, size);
}
}

