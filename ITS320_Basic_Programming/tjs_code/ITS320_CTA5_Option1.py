def main():

    strings = []

    for i in range(3):
        strings.append(input('Please enter a string for the program: '))

    print(newConcatStrings(strings))

#return to the user a concatenation of the string values in reverse order
#i.e. 
#[string1, python!, global@] -> "global@python!string1"
def concatStrings(list):
    list = reversed(list)
    out = ""
    for string in list:
        out += string
    return out

#new grading criteria
#[The, Old, Street] -> "teertSdlOehT"
def newConcatStrings(list):
    list = reversed(list)
    out = ""
    for string in list:
        out += string[::-1]
    return out

if __name__ == '__main__':
    main()