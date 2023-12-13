
def main():

    count = 1
    arr = []
    sum = 0

    while count <= 5:
        arr.append(float(input("Please enter float " + str(count) + ": ")))
        sum += arr[count - 1]
        count += 1
        
    avg = sum / len(arr)
    maxNum = max(arr)
    minNum = min(arr)

    print("\nsum: %.2f" % sum)
    print("avg: %.2f" % avg)
    print("max: %.2f" % maxNum)
    print("min: %.2f" % minNum)

    print("\nInterest at 20% for each original value entered by the user\n")
    for item in arr:
        print("%.2f" % (item * 1.2))




if __name__ == '__main__':
    main()

