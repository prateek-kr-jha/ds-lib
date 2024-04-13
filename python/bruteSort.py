array_1 = [5, 6, 1, 3, 8, 10]

def min(num1, num2):
    if(num1 > num2):
        return num2
    return num1

def swap(num1, num2):
    temp = num1
    num1 = num2
    num2 = temp


# def bruteSort(array_1):
#     n = len(array_1)
#     for i in range(n):
#         for j in range(i + 1, n):
#             if(sorted_arr[j])

def internal_swap(array):
    n = len(array)

    i = 0
    while i < n:
        if(i < n - 1):
            temp = array[i]
            array[i] = array[i + 1]
            array[i + 1] = temp  

        i+=2

print(array_1)
internal_swap(array_1)
print(array_1)
num1 = 3
num2 = 4
temp = num1
num1 = num2
num2 = temp
swap(num1, num2)
print(num1, num2)