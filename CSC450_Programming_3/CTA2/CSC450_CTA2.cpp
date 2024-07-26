
#include<iostream>
using namespace std;

int main()
{

    string in1, in2, out;

    for (int i = 0; i < 3; i++) 
    {
        //cout << "Run number " << i+1 << endl;
        cout << "String 1: ";
        getline(cin, in1);
        cout << "String 2: ";
        getline(cin, in2);

        cout << "Concatenated strings: " << in1 + in2 << endl;
    } 

   return 0;
}
