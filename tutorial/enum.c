#include <stdio.h>

enum cardsuit {
	CLUBS = 1,
	DIAMONDS,
	HEARTS = 100,
	SPACES
};

int main()
{
	printf("%d\n", CLUBS);
	printf("%d\n", DIAMONDS);
	printf("%d\n", HEARTS);
	printf("%d\n", SPACES);

}
