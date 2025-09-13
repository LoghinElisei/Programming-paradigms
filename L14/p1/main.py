from pyswip import Prolog

prolog = Prolog()
prolog.consult("familie.pl")

print("\n\tCe pereche de membri au o matusa ?")
for result in prolog.query("matusa(X,Y)"):
    print(f"Matusa: {result['X']}, Nepot: {result['Y']}")

print("\n\tCe pereche de membri au un bunic ?")
for result in prolog.query("bunicul(X,Y)"):
    print(f"Nepot: {result['X']}, Bunic: {result['Y']}")

print("\n\tCine este sora lui George ?")
for result in prolog.query("sora(george,X)"):
    print(f"Sora lui George: {result['X']}")



print("\n\tCe pereche de membri sunt verisori ?")
for result in prolog.query("verisor(X,Y)"):
    print(f"Verisor1: {result['X']}, Verisor2: {result['Y']}")
# for result in prolog.query("verisoara(X,Y)"):
#     print(f"Verisor1: {result['X']}, Verisor2: {result['Y']}")

print("\n\tCine este copilul lui ilie ?")
for result in prolog.query("copil(X,ilie)"):
    print(f"Copilul lui Ilie: {result['X']}")