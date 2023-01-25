import RPi.GPIO as GPIO
import time
import sys

if len(sys.argv) != 1:
    print("Please give a Number between 1 and 100")
    exit()

if sys.argv[0] < 1 and  sys.argv[0] > 100:
    print("Your Number is not between 1 and 100")
    exit()



MOTOR_GPIO = 21
GPIO.setmode (GPIO.BCM)

GPIO.setup (MOTOR_GPIO, GPIO.OUT)

pwmMotor = GPIO.PWM(MOTOR_GPIO, 100)

pwmMotor.start(0)
try:

    for speed in range(0,110,10):
        pwmMotor.ChangeDutyCycle(speed)
        print (speed)
        time.sleep(2)
except KeyboardInterrupt:
    pass

pwmMotor.stop()

#GPIO.output (MOTOR_GPIO, GPIO.HIGH)

#time.sleep(3)

#GPIO.output(MOTOR_GPIO, GPIO.LOW)

GPIO.cleanup()

