# fibo(1) = 1, fibo(2) = 1,1 fibo(3) = 1,1,2 fibo(4)= 1,1,2,3

fib = []
ef = []

first = 1
second = 1
third = 0
fib.append(first)
fib.append(second)

while third <= 4000000:
            third = first + second
            first = second
            second = third
            fib.append(third) 

#400만 이하의 피보나치 수열 출력

for i1 in fib:
    if i1 % 2 == 0:
        ef.append(i1)       

#400만 이하의 2의 배수 출력


print(ef) #2가지 조건을 만족하는 ef 리스트 sum하여 출력




#피보나치 공부자료



# a = 0				# 첫 번째 항
# b = 1				# 두 번째 항
# c = 0				# 그 다음 항

# f = []				# 값 저장
# Ef = []				# 짝수 저장

# while c <= 4000000:		# 400만 초과하면 False
#         c = a+b
#         a = b			# 조건식 1번(피보나치 수열)
#         b = c
#         f.append(c)		# 리스트에 추가



# for i in f:
# 	    if i % 2 == 0:		# 조건식 2번(짝수 판별)
#     		Ef.append(i)	# 리스트에 추가

# print(Ef)	
