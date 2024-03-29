import numpy as np
import matplotlib.pyplot as plt

N = 6

# Directly specify the binary sequence
n = np.array([1, 0, 1, 1, 0, 1])  # Example binary sequence
print("Original binary sequence:", n)

# Making data based on bipolar algorithm
nn = np.zeros(N)
flag = True  # true means lst assind value 1
for i in range(N):
    if n[i] == 1:
        if flag:
            nn[i] = 1
        else:
            nn[i] = -1
        flag ^= True # compound bitwise XOR operation

# Signal shaping
i = 1
a = 0
t = np.arange(0, N + 0.01, 0.01)
y = np.zeros(len(t))
for j in range(len(t)):
    if t[j] >= a and t[j] <= a + 0.5:
        y[j] = nn[i - 1]
    elif t[j] >= a + 0.5 and t[j] <= i:
        pass
    else:
        a += 1
        i += 1

# Plotting original binary sequence
plt.subplot(2, 1, 1)
plt.stem(np.arange(N), n, linefmt='b-', markerfmt='bo', basefmt=' ')
plt.axis([0, N, -1.5, 1.5])
plt.title("Original Binary Sequence")
plt.xlabel("Bit Index")
plt.ylabel("Binary Value")
plt.xticks(np.arange(N), np.arange(N))
plt.grid(True)

# Plotting shaped bipolar RZ signal
plt.subplot(2, 1, 2)
plt.plot(t, y, linewidth=2)
plt.grid(True)
plt.axis([0, N, -1.5, 1.5])
plt.title("Bipolar Return to Zero")
plt.xlabel("Time")
plt.ylabel("Amplitude")
plt.xticks(np.arange(N), np.arange(N))

plt.tight_layout()
plt.show()
