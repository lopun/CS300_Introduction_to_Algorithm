#include <stdio.h>
int rangesum(int start, int end);

int main()
{
	printf("%d\n", rangesum(1, 100));
	printf("%d\n", rangesum(1000, 1500));
	printf("%d\n", rangesum(310, 5000));
}

int rangesum(int start, int end)
{
	int sum = 0;

	for (start; start < end+1; start++)
	{
		sum = sum + start;
	}

	return sum;
}
