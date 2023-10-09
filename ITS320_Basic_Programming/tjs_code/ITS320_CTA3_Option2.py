

def main():

    bracket = {
        500: .1,
        1500: .15,
        2500: .2,
    }

    while True:
        income = input("please enter weekly income (enter q to exit): ")

        if income == 'q':
            break
        
        rate = .3

        for key in bracket.keys():
            if int(income) < int(key):
                rate = bracket[key]
                break

        tax = int(income) * rate;

        print("income: " + income + ", tax rate: " + str(rate) + ", tax: " + str(tax))

    print('exiting...')



main()