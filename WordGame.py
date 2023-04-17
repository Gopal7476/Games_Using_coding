import random

def generateSequence(x, y, ch):
    string = ""
    for i in range(0, x):
        string += "_"
    string += ch
    for j in range(x+1, y):
        string += "_"
    return string

def generateWord(a, b):
    b = list(b)
    for i in range(len(a)):
        if (a[i] != "_"):
            b[i] = a[i]
    return "".join(b)


list_of_words = ["Apple","Banana","Grapes", "ORANGE", "PineAPPle"]

gen_word = random.choice(list_of_words).lower()
ans = gen_word

word = "_" * len(gen_word)

count = 0
b = ""

print("Welcome! to guess a word game")
print("You only have {} chances".format(len(gen_word)))
for i in range(1, len(gen_word)+1):
    char = input("Enter a your character: ").lower()
    if char in gen_word:
        index_of_char = gen_word.index(char)
        a = generateSequence(index_of_char, len(gen_word), char)
        b = generateWord(a, word)
        word = b
        print(b)
        gen_word = list(gen_word)
        gen_word[index_of_char] = "0"
    else:
        print("You entered character is wrong!!!")
    if(len(gen_word)-i != 0):
        print("You only have {} chances".format(len(gen_word)-i))
if(b == ans):
    print("Congralutions! You won the game")
else:
    print("You lost the game!!!")
    print("Correct Answer: ", ans)
