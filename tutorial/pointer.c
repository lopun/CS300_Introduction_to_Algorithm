#include <stdio.h>
#include <stdlib.h>

int main()
{
	int *pdata;
	int i;
	pdata = (int *)malloc(sizeof(int)*5);
	for (i=0; i<5; i++)
	{
		pdata[i] = i;
	}
	pdata = pdata+2;
	printf("%d\n", pdata[0]);
	printf("%d\n", *pdata);
}
