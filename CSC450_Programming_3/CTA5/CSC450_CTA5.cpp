#include <algorithm>
#include <iostream>
#include <fstream>
using namespace std;

int main()
{

    fstream file("CSC450_CT5_mod5.txt", ios::in | ios::out | ios::app);
    string user_input;

    if (file.is_open()) 
    {
        cout << "Enter a string to append to the end of the file: ";
        getline(cin, user_input);

        file << user_input;
    } else 
    {
        cout << "Failed to open file!" << endl;
        return 1;
    }

    file.clear();
    file.seekg(0, ios::beg);

    fstream reversedFile("CSC450-mod5-reverse.txt", ios::out);
    string temp;

    if (reversedFile.is_open())
    {
        while (getline(file, temp))
        {
            reverse(temp.begin(), temp.end());
            reversedFile << temp << endl;
            temp.clear();
        }
    } else {
        cout << "Failed to open reversed file!" << endl;
        return 1;
    }

    cout << "Success!" << endl;
    return 0;
}
