#Author: Thomas Keefe
#Email: tjk819@gmail.com
#Date: 12/03/2023

from Car import Car

class Inventory:

    #Your program should have appropriate methods such as:
    #constructor

    def __init__(self) -> None:
        self.inventory = []

    def __str__(self) -> str:
        out = ""
        idx = 0
        for car in self.inventory:
            out += f"Car {idx}:\n"
            out += f"{car}\n"
            idx += 1
        return out

    def make_car(self, make, model, color, year, mileage):
        return Car(make, model, color, year, mileage)
    
    def input_car(self):
        _make = input("Enter make: ")
        _model = input("Enter model: ")
        _color = input("Enter color: ")
        _year = int(input("Enter year: "))
        _mileage = int(input("Enter mileage: "))
        print("\n")
        return self.make_car(_make, _model, _color, _year, _mileage)

    #Your program should have appropriate methods such as:
    #add a new vehicle

    def add_car(self, car):
        self.inventory.append(car)

    #Your program should have appropriate methods such as:
    #remove a vehicle

    def remove_car(self, car):
        try:
            self.inventory.remove(car)
        except ValueError:
            print(f"Error! {car} is not in inventory\n")

    #Your program should have appropriate methods such as:
    #update vehicle attributes

    def update_car(self, idx):
        try:
            print(f"the car you selected is {self.inventory[idx]}")
            print("please enter the new information for the car now")
            self.inventory[idx] = self.input_car()
        except:
            print(f"Error! {idx} index is invalid\n")

    def select_car(self):
        try:
            return int(input("Please enter the index of the car you'd like to update: "))
        except:
            print(f"Error! Invalid entry\n")

    #At the end of your program, it should allow the user to output all vehicle inventory to a text file.

    def write_file(self):
        try:
            file = open('inventory.txt', 'w')
            file.write(str(self))
            file.close()
        except:
            print("Error writing file\n")