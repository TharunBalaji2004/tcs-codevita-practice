#include <iostream>
#include <stdlib.h>

using namespace std;

int main()
{

    int n;
    cin >> n;

    cout << staircaseRecursiveApproach(n) << endl;
    cout << staircaseDPApproach(n) << endl;

    return 0;
}

int staircaseDPApproach(int n)
{
    int a = 1;
    int b = 2;
    for (int i = 3; i <= n; i++)
    {
        int c = a + b;
        a = b;
        b = c;
    }
    return b;
}

int staircaseRecursiveApproach(int n)
{
    if (n <= 2)
    {
        return n;
    }
    else
    {
        return staircaseRecursiveApproach(n - 1) + staircaseRecursiveApproach(n - 2);
    }
}