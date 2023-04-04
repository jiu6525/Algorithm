import math

lcm = 1
for i in range(1,21):
    gcd = math.gcd(lcm,i)
    lcm = int(lcm*i/gcd)

    print(i,gcd,lcm)


