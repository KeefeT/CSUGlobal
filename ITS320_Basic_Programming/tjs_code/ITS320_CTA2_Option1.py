
def main():
    
    hasAlpha = False
    hasNum = False
    hasLower = False
    hasUpper = False

    while True:
        string = input("enter string: ")

        if len(string) < 50:
            break
        else:
            print("please enter less that 50 characters")

    for c in string:
        if c.isalpha():
            hasAlpha = True
            if c.islower():
                hasLower = True
            else:
                hasUpper = True
        if c.isdigit():
            hasNum = True
        

    hasAlphaNum = hasAlpha or hasNum


    print("has alphanum: " + str(hasAlphaNum))
    print("has alpha: " + str(hasAlpha))
    print("has digit: " + str(hasNum))
    print("has lower: " + str(hasLower))
    print("has upper: " + str(hasUpper))


main()