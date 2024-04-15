
#include <iostream>
#include <limits>
using namespace std;

int main()
{

    int i1, i2, i3;
    int *p_i1, *p_i2, *p_i3;

    cout << "Enter number 1: " ;
    cin >> i1;
    cout << "Enter number 2: " ;
    cin >> i2;
    cout << "Enter number 3: " ;
    cin >> i3;

    p_i1 = new int(i1);
    p_i2 = new int(i2);
    p_i3 = new int(i3);

    cout << "num 1: " << i1 << ", p_num 1: " << *p_i1 << endl;
    cout << "num 1: " << i2 << ", p_num 1: " << *p_i2 << endl;
    cout << "num 1: " << i3 << ", p_num 1: " << *p_i3 << endl;

    delete p_i1, p_i2, p_i3;

   return 0;
}
