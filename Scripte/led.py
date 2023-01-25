import RPi.GPIO as GPIO
import time

MOTOR_GPIO = 20
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

