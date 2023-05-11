import RPi.GPIO as GPIO
import time
import sys

#check if there are only two arguments (name of file), (number)
if len(sys.argv) != 2:
    print("Please give a Number between 1 and 100")
    exit()

#print(int(sys.argv[1]))

#check if number is correct
if (int(sys.argv[1]) < 0 or  int(sys.argv[1]) > 100):
    print("Your Number is not between 1 and 100")
    exit()

else:
    print("True")

brightness = int(sys.argv[1])



MOTOR_GPIO = 20
GPIO.setmode (GPIO.BCM)

GPIO.setup (MOTOR_GPIO, GPIO.OUT)

pwmMotor = GPIO.PWM(MOTOR_GPIO, 100)

pwmMotor.start(0)
try:

    while 1:
        pwmMotor.ChangeDutyCycle(brightness)
        print (brightness)
        time.sleep(2)
except KeyboardInterrupt:
    pwmMotor.stop()




#GPIO.output (MOTOR_GPIO, GPIO.HIGH)

#time.sleep(3)

#GPIO.output(MOTOR_GPIO, GPIO.LOW)

GPIO.cleanup()

