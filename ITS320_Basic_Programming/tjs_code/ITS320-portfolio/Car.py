#Author: Thomas Keefe
#Email: tjk819@gmail.com
#Date: 12/03/2023

class Car:
    #Create an automobile class that will be used by a dealership as a vehicle inventory program. 
    #The following attributes should be present in your automobile class
    #
    #private string make
    #private string model
    #private string color
    #private int year
    #private int mileage

    #Your program should have appropriate methods such as:

    #constructor

    def __init__(self, make, model, color, year, mileage) -> None:
        self.make = make
        self.model = model
        self.color = color
        self.year = int(year)
        self.mileage = int(mileage)    
        
    def __str__(self) -> str:
        return f"{self.year} {self.make} {self.model}, {self.color}, {self.mileage} miles"
    
    def get_make(self):
        return self.make

    def get_model(self):
        return self.model
    
    def get_color(self):
        return self.color
    
    def get_year(self):
        return self.year
    
    def get_mileage(self):
        return self.mileage
    
    def set_make(self, make):
        self.make = make

    def set_model(self, model):
        self.model = model

    def set_color(self, color):
        self.color = color

    def set_year(self, year):
        self.year = year

    def set_mileage(self, mileage):
        self.mileage = mileage
