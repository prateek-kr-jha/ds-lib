import sys

print(type(sys.argv))
print(sys.argv)
my_list = []
if len(sys.argv) >= 2:
    #print("Hello, world!")
    for index, item in enumerate(sys.argv):
        print(index, item)
        if(index != 0):
            my_list.append(item)

    for item in sys.argv:
        print(f"formatted {item}")
else:
        print("Please provide proper input")



my_new_list = [int(item) ** 2 for item in my_list]
user_input = sys.stdin.read()
i = 0
while(i < len(my_new_list)):
    print(f"from while {my_new_list[i]}")
    i+=1
print(user_input)
print(type(user_input))
for char in user_input:
    if(char != " " and char != "\n"):
        print(char,end= ", ")
print("\n")