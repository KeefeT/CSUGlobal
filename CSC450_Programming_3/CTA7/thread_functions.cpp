
#include <mutex>
#include "thread_functions.h"

std::mutex mtx;

void t_increment(int *p_int)
{
    mtx.lock();
    for (int i = 0; i < 20; i++)
    {
        std::cout << "p_int: " << *p_int << std::endl;
        *p_int = *p_int + 1;
    }
    mtx.unlock();
}

void t_decrement(int *p_int)
{
    mtx.lock();
    for (int i = 0; i < 20; i++)
    {
        std::cout << "p_int: " << *p_int << std::endl;
        *p_int = *p_int - 1;
    }
    mtx.unlock();
}

