Point {
    int x
    int y
}

int i = 1

def wypisz {
    print "Write something"
    int j = i + 2
    print i
    print j
}

wypisz()

repeat 3 {
    print i
    i = i + 1
}

if i == 4 {
    print "CZTERY"
}

Point p = Point(10 22)
p.x = 5

print p

int s = p.x * p.x
print s
