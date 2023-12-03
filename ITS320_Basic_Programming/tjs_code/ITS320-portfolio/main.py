#Author: Thomas Keefe
#Email: tjk819@gmail.com
#Date: 12/03/2023

from Inventory import Inventory

def main():
    inventory = Inventory()

    #Your program should have appropriate methods such as:
    #add a new vehicle
    lightning_mcqueen = inventory.make_car("Ford", "Fusion", "red", 2007, 195000)
    subaroo = inventory.make_car("Subaru", "Forester", "black", 2012, 155000)
    pauline = inventory.make_car("Jeep", "Wrangler", "white", 2021, 42000)
    custom_car = inventory.input_car()

    inventory.add_car(lightning_mcqueen)
    inventory.add_car(subaroo)
    inventory.add_car(pauline)
    inventory.add_car(custom_car)

    print(inventory)

    #Your program should have appropriate methods such as:
    #remove a vehicle
    inventory.remove_car(subaroo)
    #removing again to test error handling
    inventory.remove_car(subaroo)

    print(inventory)


    #Your program should have appropriate methods such as:
    #update vehicle attributes
    idx = inventory.select_car()
    inventory.update_car(idx)

    print(inventory)

    #At the end of your program, it should allow the user to output all vehicle inventory to a text file.
    user = ''
    while (user != 'y' and user != 'n'):
        user = (input("Would you like to export the inventory to a file? (y/n)\n")).lower()

    if (user == 'y'):
        print("Writing file...\n") 
        inventory.write_file()

    print("Thank you!")



if __name__ == "__main__":
    main()