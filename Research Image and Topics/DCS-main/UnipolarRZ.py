import numpy as np
import matplotlib.pyplot as plt

N = 10

# Directly specify the binary sequence
n = np.array([1, 0, 1, 1, 0, 1, 0, 0, 1, 1])  # Example binary sequence
print("Binary sequence:", n)

t = np.arange(0, N + 0.01, 0.01)
y = np.zeros(len(t))

for i in range(N):
    for j in range(len(t)):
        if t[j] >= i and t[j] <= i + 0.5:
            y[j] = n[i]
        elif t[j] > i + 0.5:
            break

# Plotting
plt.plot(t, y, linewidth=2)
plt.grid(True)
plt.axis([0, N, -1.5, 1.5])
plt.title("Unipolar Return to Zero")
plt.xticks(np.arange(N), np.arange(N))
plt.xlabel('Bit Index')
plt.ylabel('Amplitude')
plt.show()
