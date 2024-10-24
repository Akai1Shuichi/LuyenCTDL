#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string>
#include <cstring>

using namespace std;

bool isDoiXung(char* s) {
    char* l = s;
    char* r = s + strlen(s) - 1;

    while (l < r) {
        while (!isalpha(*l)) {
            l++;
        }
        while (!isalpha(*r)) {
            r--;
        }
        if (tolower(*l) != tolower(*r)) {
            return false;
        }
        l++; r--;
    }
    return true;
}

char* delC(char* s, int c) {
    char* s1 = strdup(s);

    for (int i = 0 ; i < strlen(s1); i++) {
        if (tolower(s1[i]) == tolower(c)) {
            strcpy(s1+i,s1+i+1);
            i--;
        }
    }

    return s1;
}

int main() {
    char s[100], *t, c;

    printf( "Nhap chuoi: " );
    fgets(s, 100, stdin);
    if ((t = strrchr(s, '\n')) != NULL) {
        *t = '\0';
    }

    if (isDoiXung( s )) {
        cout << "Chuoi Doi Xung" << endl;
    } else {
        cout << "Chuoi Khong Doi Xung" << endl;
    }
    printf("Xoa ky tu nao?");
    cin >> c;
    cout << delC(s, c);
}