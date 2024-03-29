import numpy as np
import matplotlib.pyplot as plt

N = 10

# Binary sequence declaration
n = np.array([1, 0, 1, 1, 0, 1, 0, 0, 1, 1])  # Example binary sequence
print("Binary sequence:", n)

# Conversion to polar values
nn = np.where(n == 1, 1, -1)

# Time array creation
t = np.arange(0, N + 0.01, 0.01)# each unit in the time array represents 0.01 time units.

# Initialization of the output array
y = np.zeros(len(t))


# Filling the output array with polar values
for i in range(N):
    y[i * 100:(i + 1) * 100] = nn[i]

# Plotting
plt.plot(t, y, linewidth=2)
plt.grid(True)
plt.axis([0, N, -1.5, 1.5])
plt.title("Polar Non Return to Zero")
plt.xticks(np.arange(N), np.arange(N))
plt.show()
