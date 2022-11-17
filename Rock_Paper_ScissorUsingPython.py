import random

time = int(input("How many times do you want to play: "))

user_score = 0
comp_score = 0

while time!=0:
    user = input("Enter your choice R/P/S: ").upper()
    comp = random.choice(['R','P','S'])

    if((user == 'R' and comp == 'S') or (user == 'P' and comp == 'R') or (user == 'S' and comp == 'P')):
        user_score += 1
        print("----------------------------------------------------------------------")
        print(f'You choosen {user} and Computer choosen {comp}')
        print("You won!!")
        print(f'Your score is {user_score} and Computer score is {comp_score}')
        print("----------------------------------------------------------------------")
    elif((user == 'R' and comp == 'P') or (user =='P' and comp == 'S') or (user == 'S' and comp == 'R')):
        comp_score += 1
        print("----------------------------------------------------------------------")
        print(f'You choosen {user} and Computer choosen {comp}')
        print("Computer won!!")
        print(f'Your score is {user_score} and Computer score is {comp_score}')
        print("----------------------------------------------------------------------")
    else:
        print("----------------------------------------------------------------------")
        print(f'You choosen {user} and Computer choosen {comp}')
        print("TIED!!")
        print(f'Your score is {user_score} and Computer score is {comp_score}')
        print("----------------------------------------------------------------------")
    time -= 1

if (user_score > comp_score):
    print("User has won the game!!!")
elif(user_score < comp_score):
    print("Computer has won the game!!!")
else:
    print("Game TIED!!!")