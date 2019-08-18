# A - Choose Two Numbers

def main():
    a_elements = int(input())
    a = [int(x) for x in input().split()]
    max_a = max(a)
    b_elements = int(input())
    b = [int(x) for x in input().split()]
    max_b = max(b)
    print(f"{max_a} {max_b}")

main()
