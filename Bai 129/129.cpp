#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string>
#include <cstring>
#include <cctype>

using namespace std;

int main() {
    char s[100], *t;
    int i,j, max_num;
    printf("Nhap chuoi (it nhat 4 chu so): ");
    fgets(s, 100, stdin);

    if ((t = strrchr(s, '\n')) != NULL) {
        *t = '\0';
    }
    for (i = 0 ; i < strlen(s); i++) {
        if (!isdigit(s[i])) {
            strcpy(s + i, s+i+1);
            i--;
        }
    }
    if (strlen(s) < 4) {
        printf( "Phai co it nhat 4 so\n" ); return 0;
    }
    for (i = 0 ; i < 4 ; i++) {
        size_t max_pos = i;
        for (j = i ; j < strlen(s) - 3 + i; j++) {
            if (s[j] > s[max_pos]) {
                max_pos = j;
            }
        }
        if (max_pos > i) {
            strcpy(s+i,s+max_pos);
        }
    }
    s[4] = '\0';

    printf( "So lon nhat con lai: %s\n", s );
    return 0;
}
