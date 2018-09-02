#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
  char **data;
  char **org;
  int i;

  data = (void *)malloc(sizeof(char *) *4); // 4개의 포인터를 저장하기 위한 메모리 공간 확보
  org = data; // 원래 포인터의 주소를 저장하기 위한 용도.
  for (i = 0; i < 4; i++) {
    *data =
        malloc(sizeof(char) *
               25); // 각각의 포인터에 최대 25개의 char 데이터를 저장하기 위한
    data++; // 공간을 확보한다.
  }

  data = org;
  strcpy(*data, "hello world!!\0");

  data++;
  strcpy(*data, "My name is yundream.\0");

  data++;
  strcpy(*data, "What's your name.\0");

  data++;
  strcpy(*data, "Thank you.\0");

  data = org;
  for (i = 0; i < 4; i++) {
    printf("%s\n", *data);
    data++;
  }
}
