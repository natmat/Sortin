/*
 ============================================================================
 Name        : MergeSort.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void mergeSort(int *arr, int n) {
	for (int i = 0 ; i < n ; i++) {
		printf("%d ", arr[i]);
	}
	printf("\n");


}

void merge(int *a1, int *a2) {

}

void divide(int *arr, int n) {
	if (n == 1) {
		return();
	}

	int a1[n/2];
	int a2[];
}

int main(void) {
	srand((unsigned)time(NULL));

	int arr[20];
	int n;
	n = (rand()%10) + 10;
	for (int i = 0 ; i < n ; i++) {
		arr[i] = 1 + rand()%21;
	}

	mergeSort(arr, n);

	return EXIT_SUCCESS;
}



