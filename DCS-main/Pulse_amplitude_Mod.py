import numpy as np
import matplotlib.pyplot as plt
# Parameters
fc, fm, fs, t, duty = 20, 2, 1000, 1, 20 # time vector in duration 1 seconds
# Time axis
n = np.arange(0, t, 1/fs) 

# Square wave generation
s = np.where(np.floor(2 * fc * n) % 2 == 0, 1, 0)
# Sine wave generation
m = np.sin(2 * np.pi * fm * n)
# PAM waveform generation
period_samp = len(n) / fc    # period 
on_samp = int(np.ceil(period_samp * duty / 100)) # celi function used to check rounding integer value
ind = np.arange(0, len(n), int(period_samp)) # indicate period where start and end 
pam = np.zeros(len(n))
for i in ind:
    pam[i:i+on_samp] = m[i]
# Plotting
plt.figure(figsize=(8, 6))
plt.subplot(3, 1, 1)
plt.plot(n, s)
plt.title('Square Wave')
plt.xlim(0, 1)

plt.subplot(3, 1, 2)
plt.plot(n, m)
plt.title('Sine Wave')
plt.axis([0, 1,-1, 1])

plt.subplot(3, 1, 3)
plt.plot(n, pam)
plt.title('PAM Waveform')
plt.axis([0, 1,-1, 1])
plt.tight_layout()
plt.show()