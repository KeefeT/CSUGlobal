
user_input = input('Enter numbers:')
tokens = user_input.split() # Split into separate strings

nums = []
for token in tokens:
    nums.append(int(token))

max_num = None
for num in nums:
    if (max_num == None) and (num % 2 == 0):
        max_num = num
    elif (max_num != None) and(num > max_num ) and (num % 2 == 0):
        max_num = num

print('Max #:', max_num)