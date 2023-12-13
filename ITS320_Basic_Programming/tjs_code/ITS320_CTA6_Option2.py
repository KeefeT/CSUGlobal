
def main():

    print("enter a number to add to listA (press q to end early)")
    flag = ''
    count = 1
    listA = []
    listB = []

    while count <= 10:
        flag = input("enter number " + str(count) + " to listA: ")
        if flag == 'q':
            break
        else:
            listA.append(int(flag))
            count += 1

    flag = ''
    count = 1

    print("enter a number to add to listB (press q to end early)")
    while count <= 10:
        flag = input("enter number " + str(count) + " to listB: ")
        if flag == 'q':
            break
        else:
            listB.append(int(flag))
            count += 1

    compute(listA, listB)
    

def compute(a,b):

    out = []

    for itemA in a:
        for itemB in b:
            out.append([itemA,itemB])

    print(out)

if __name__ == '__main__':
    main()