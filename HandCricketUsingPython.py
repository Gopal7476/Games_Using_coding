import random

def check_input_lessthan_6():
  print("CAUTION: INPUT ERROR!!!!!")
  toss_user_number = int(input("Choose a number b/w 1-6: "))
  if(toss_user_number <= 6 and toss_user_number > 0):
    return toss_user_number
  return check_input_lessthan_6()

def batting(player, target):
    score = 0
    
    while(target > score):
        user_choose = int(input("Choose a number b/w 1-6: "))
        while(user_choose > 6 or user_choose == 0):
            user_choose = check_input_lessthan_6()
        comp_choose = random.choice([1,2,3,4,5,6])

        print(f"You have choosen {user_choose} and computer has choosen {comp_choose}")

        if(user_choose != comp_choose):
            if(player == "user"):
                score += user_choose
            else:
                score += comp_choose
        else:
            print(f"{player} OUT!!!")
            break
    return score


print("--------------------- Let the toss begins -------------------------")

toss_user = input("Choose ODD or Even: ").upper()
toss_user_number = int(input("Choose a number b/w 1-6: "))
while(toss_user_number > 6 or toss_user_number == 0):
  toss_user_number = check_input_lessthan_6()

while True:
    toss_comp = random.choice(["ODD","EVEN"])
    if(toss_user != toss_comp):
        break
toss_comp_number = random.choice([1,2,3,4,5,6])

print()
print("YOU CHOOSEN: ",toss_user)
print("YOU CHOOSEN A NUMBER: ",toss_user_number)
print("COMPUTER CHOOSEN: ",toss_comp)
print("COMPUTER CHOOSEN A NUMBER: ",toss_comp_number)
print()

toss_number = toss_user_number + toss_comp_number
if((toss_number%2 == 0 and toss_user == "EVEN") or (toss_number%2 !=0 and toss_user == "ODD")):
    print("You have won the toss, do you like to do BAT or BALL")
    user_toss = input("Choose to BAT or BALL: ").upper()
    if(user_toss == "BAT"):
        comp_toss = "BALL"
    else:
        comp_toss = "BAT"
else:
    comp_toss = random.choice(["BAT","BALL"])
    if(comp_toss == "BAT"):
        user_toss = "BALL"
    else:
        user_toss = "BAT"
    print(f"You have lost the toss and computer has choose {comp_toss} so you will do {user_toss}")
print("--------------------------------------------------------------------------------")

user_score = 0
comp_score = 0

if(user_toss == "BAT" or comp_toss == "BALL"):
    user_score = batting("user", 1000000)
    print("-----------------------------------")
    print("Computer TARGET is ",user_score+1)
    print("-----------------------------------")
    comp_score = batting("comp", user_score+1)
else:
    comp_score = batting("comp", 1000000)
    print("-----------------------------------")
    print("Your TARGET is ",comp_score+1)
    print("-----------------------------------")
    user_score = batting("user", comp_score+1)

if(user_score > comp_score):
    print("User won the game!!!")
elif(user_score == comp_score):
    print("Match TIED!!!")
else:
    print("Computer won the game!!!")