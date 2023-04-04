l = []
li=[]

for i in range(1,101):
    a = i**2
    l.append(a)
    a = sum(l)
    
    li.append(i)
    b = sum(li)**2




print(b-a)
