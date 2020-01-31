import random

f = open("generated.csv", "w")
f.write("client;age;money;ageReco;moneyReco;happy\n")

for i in range(200):
    name = "client"+str(i)
    money = random.randint(100,100000)
    age = random.randint(15,99)
    moneyReco = random.randint(100,100000)
    ageReco = random.randint(15,99)
    if(random.randint(0,1)==0):
        happy = "true"
    else:
        happy = "false"
    f.write(name+';'+str(age)+';'+str(money)+';'+str(ageReco)+';'+str(moneyReco)+';'+happy+'\n')

f.close()