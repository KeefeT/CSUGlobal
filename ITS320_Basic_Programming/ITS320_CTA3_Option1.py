
def getValue(year):
    
    if year < 1962:
        return "too old"
    elif year < 1965:
        return "$18,500"
    elif year < 1969:
        return "$6,000"
    elif year < 1972:
        return "$12,000"
    elif year < 1976:
        return "$48,000"
    elif year < 1981:
        return "$200,000"
    elif year < 1986:
        return "$650,000"
    elif year < 2013:
        return "$35,000,000"
    elif year < 2015:
        return "$52,000,000"
    else:
        return "too new"


def main():
    year = int(input("enter year of ferrari 250 GTO: "))

    print(getValue(year))


main()