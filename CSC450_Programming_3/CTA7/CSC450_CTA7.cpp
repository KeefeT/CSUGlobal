
#include <thread>
#include "thread_functions.h"
using namespace std;

//g++ -pthread CSC450_CTA7.cpp thread_functions.cpp thread_functions.h

int main()
{
    int counter = 0;
    int *p_counter = &counter;
    cout << "Counter before: " << counter << endl;
    thread t1(t_increment, p_counter);
    t1.join();

    thread t2(t_decrement, p_counter);
    t2.join();

    cout << "Counter after: " << counter << endl;
    return 0;
}
