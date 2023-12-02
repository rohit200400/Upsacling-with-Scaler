'''
Testcases:
    n = 0   >> 0
    n = -ve >> gives square
    n >= 10 && n <= 20 >> giving factorial of n-10
        fixed by adding equals in the elif condition
        while calculating factorial last number was getting missed so reduced 10 to 9 in the for loop
    n > 20 >> giving factorial of n-20
        commented one line and modified one line to modify it to calculate first n natural numbers >> n(n+1)/ 2
'''

def compute(n):
    if n < 10:
        out = n ** 2
    elif n <= 20: # added equal sign to include 20
        out = 1
        for i in range(1, n - 9):  # changed 10 to 9 for including the last number
            out *= i
    else:
        lim = n - 20
        out = lim * (lim + 1)  # used the formula of first n natural numbers >> n(n+1)/ 2
        # out = out - lim
        out = out / 2
    print(out)


n = int(input("Enter an integer: "))
compute(n)
