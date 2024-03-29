import numpy as np
import matplotlib.pyplot as plt

N = 10

# Directly specify the binary sequence
n = np.array([1, 0, 1, 1, 0, 1, 0, 0, 1, 1])  # Example binary sequence
print("Binary sequence:", n)

i = 1
t = np.arange(0, N + 0.01, 0.01)  # 100 Times duration set up for a single binary bit
y = np.zeros(len(t))

for j in range(len(t)):
    if t[j] < i:  # Binary input data index Check-up Condition
        y[j] = n[i - 1]  # Assign value from the mapping function
    else:
        y[j] = n[i - 1]
        i += 1  # Binary input data index increment

# Plotting
plt.plot(t, y, linewidth=1)
plt.axis([0, N, -0.2, 1.5])
plt.grid(True)
plt.title('Unipolar NRZ Signaling')
plt.xticks(np.arange(N), np.arange(N))
plt.xlabel('Bit Index')
plt.ylabel('Amplitude')
plt.show()
