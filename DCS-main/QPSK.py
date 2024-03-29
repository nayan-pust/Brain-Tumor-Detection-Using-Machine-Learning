import numpy as np
import matplotlib.pyplot as plt

# Input bits
x = np.array([1, 0, 1, 1, 0, 1, 1, 1, 1, 1])

# Bits to polar
p = np.where(x == 0, -1, 1)

# Separation of even and odd sequences
even_seq = p[::2]
odd_seq = p[1::2]

# NRZ polar line coder signal generation
t = np.arange(0, len(x), 0.01)
even_ps = np.zeros(len(t))
odd_ps = np.zeros(len(t))

i = 0
m = np.arange(2, len(x) + 1, 2)
for j in range(len(t)):
    if t[j] <= m[i]:
        even_ps[j] = even_seq[i]
    else:
        even_ps[j] = even_seq[i]
        i += 1

i = 0
m = np.arange(2, len(x) + 1, 2)
for j in range(len(t)):
    if t[j] <= m[i]:
        odd_ps[j] = odd_seq[i]
    else:
        odd_ps[j] = odd_seq[i]
        i += 1

plt.subplot(421)
plt.plot(t, even_ps, 'r')
plt.xlim(0, len(x))
plt.title('NRZ Polar Line Coded Signal')
plt.subplot(422)
plt.plot(t, odd_ps, 'r')
plt.xlim(0, len(x))
plt.title('NRZ Polar Line Coded Signal')
# Carrier signals generation
c1 = np.cos(2 * np.pi * 1 * t)
c2 = np.sin(2 * np.pi * 1 * t)

plt.subplot(423)
plt.plot(t, c1, 'r')
plt.xlim(0, len(x))
plt.title('Carrier Signal (Cosine)')
plt.subplot(424)
plt.plot(t, c2, 'b')
plt.xlim(0, len(x))
plt.title('Carrier Signal (Sine)')
# QPSK Waveform generation
r1 = even_ps * c1
r2 = odd_ps * c2
qpsk_sig = r1 - r2

plt.subplot(425)
plt.plot(t, r1, 'r')
plt.xlim(0, len(x))
plt.title('QPSK Modulated Signal (Even)')
plt.subplot(426)
plt.plot(t, r2, 'b')
plt.xlim(0, len(x))
plt.title('QPSK Modulated Signal (Odd)')
plt.subplot(427)
plt.plot(t, qpsk_sig, 'b')
plt.xlim(0, len(x))
plt.title('QPSK Signal')

plt.tight_layout()
plt.show()
