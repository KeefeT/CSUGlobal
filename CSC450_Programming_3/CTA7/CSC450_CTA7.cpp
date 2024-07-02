
#include "thread_functions.h"
using namespace std;

//g++ -pthread CSC450_CTA7.cpp thread_functions.cpp thread_functions.h

/*
Specifically, address:

Performance issues with concurrency:
In this program, the thread.join() calls are blocking.
In this case, it's not really a problem, but if it were perfoming -
more complex operations, then it could severely hold up the -
performance of the program.

Vulnerabilities exhibited with use of strings:
Character arrays are vulnerable to things like buffer overflows -
, null-termination errors, or input sanitization issues. C++ strings -
are much less prone to these kind of issues, but they can still happen.

Security of the data types exhibited:
I'm just using int's here, so pretty safe -
for the most part. 
*/

int main()
{
    int counter = 0;
    int *p_counter = &counter;
    cout << "Counter before: " << counter << endl;
    thread t1(t_increment, p_counter);
    t1.join();

    cout << "Counter middle: " << counter << endl;

    thread t2(t_decrement, p_counter);
    t2.join();
    
    cout << "Counter after: " << counter << endl;
    return 0;
}
