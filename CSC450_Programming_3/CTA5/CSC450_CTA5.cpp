
#include <iostream>
#include <fstream>
using namespace std;

int main()
{

    fstream file("CSC450_CT5_mod5.txt", ios::app);
    string user_input;

    if (file.is_open()) 
    {
        cout << "Enter a string to append to the end of the file: ";
        getline(cin, user_input);

        file << user_input;
        cout << "Success!" << endl;
        file.close();
        return 0;
    } else 
    {
        return 1;
    }
}
