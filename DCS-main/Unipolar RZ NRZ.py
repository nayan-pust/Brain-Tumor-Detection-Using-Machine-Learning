import numpy as np
import matplotlib.pyplot as plt
N=10
n=np.random.randint(2,size=N)
print(n)
#RZ
t=np.arange(0,N+0.01,0.01)
y=np.zeros(len(t))
for i in range(N):
    for j in range(len(t)):
        if t[j]>=i and t[j]<= i+0.5:
            y[j]=n[i]
        elif t[j] >i+0.5:
            break
plt.subplot(211)
plt.plot(t,y,linewidth=2)
plt.grid(True)
plt.axis([0,N, -1.5,1.5])
plt.title("Unipolar RZ")
#NRZ
nn = np.where(n == 1, 1, 0) #Converts the binary values to polar values.
t = np.arange(0, N + 0.01, 0.01) #Creates a time array t from 0 to N with a step size of 0.01
y = np.zeros(len(t)) #Initializes an array y filled with zeros with the same length as t.
for i in range(N):
    y[i * 100:(i + 1) * 100] = nn[i]
plt.subplot(212)
plt.plot(t,y,linewidth=2)
plt.grid(True)
plt.axis([0,N, -1.5,1.5])
plt.title("Unipolar NRZ")
plt.tight_layout()
plt.show()