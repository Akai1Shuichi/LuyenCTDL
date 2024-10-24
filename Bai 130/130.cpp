#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string>
#include <cstring>

using namespace std;

bool findChar(char* s,char* s1) {
    char* p = strdup(s1);
    char* pFilter[100] = {0};
    int i = 0;

    while ((p = strtok(p, "*")) != NULL) {
        pFilter[i++] = p;
        p = NULL;
    }

    p = s;
    i = 0;

    while (pFilter[i] && (p = strstr(p, pFilter[i])) != NULL) {
        p += strlen(pFilter[i]);
        i++;
    }

    if ((s1[0] != '*' && strstr(s, pFilter[0]) != s) || (s1[strlen(s1)-1] != '*' && strcmp(s + strlen(s) - strlen(pFilter[i-1]), pFilter[i-1]))) {
        return 0;
    }

    return !pFilter[i];
}

int main() {
    char* s[] = {"television", "menu", "editions", "education"};
    char* s1[] = { "*en*u*", "e*i*n", "*e*o*" };
    int i, j, n, m ;
    
    n = sizeof (s) / sizeof(s[0]);
    m = sizeof (s1) / sizeof(s1[0]);

    for (i = 0 ; i < m ; i++) {
        cout << "Tim : " << s1[i] << endl;
        for (j = 0 ; j < n ; j++) {
            if (findChar(s[j], s1[i])) {
                cout << s[j] << " ";
            }
        }
        cout << endl;
    }    
}