
#include<iostream>
using namespace std;

struct person {
string first;
string last;
string address;
string city;
int zip;
} p1;


int main()
{

    p1.first = "Thomas";
    p1.last = "Keefe";
    p1.address = "1234 Rainbow Road";
    p1.city = "Toad Kingdom";
    p1.zip = 80228;

    cout << "Name: " << p1.first << " " << p1.last << endl;
    cout << "Address " << p1.address << ", " << p1.city << ", " << p1.zip << endl;

   return 0;
}
