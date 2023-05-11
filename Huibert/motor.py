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

speed = int(sys.argv[1])



MOTOR_GPIO = 21
GPIO.setmode (GPIO.BCM)

GPIO.setup (MOTOR_GPIO, GPIO.OUT)

pwmMotor = GPIO.PWM(MOTOR_GPIO, 100)

pwmMotor.start(0)
try:
    #unendlich schleife --> bis 0 eingegeben wird
    while 1:
     pwmMotor.ChangeDutyCycle(speed)
     print (speed)
     time.sleep(4)

except KeyboardInterrupt:
     pass

pwmMotor.stop()



GPIO.output (MOTOR_GPIO, GPIO.HIGH)

#time.sleep(3)

#GPIO.output(MOTOR_GPIO, GPIO.LOW)

GPIO.cleanup()